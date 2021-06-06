/**
 * Diese Klasse beinhaltet eine Liste an Büchern.
 * Ein Genre kann mehrere Bücher speichern.
 *
 * @author luigi
 * @version 0.1
 * @since 02.05.2020
 *
 */
public class Genre {
    private  String name;
    private Buch[] buecher;
    private int anzBuecher;
    private final int MAX_BUECHER = 10;

    /**
     * Konstruktor für ein Genre.
     *
     * @param name Der Name des Genres.
     */
    public Genre(String name) {
        this.name = name;
        buecher = new Buch[MAX_BUECHER]; // die maximale Anzahl der Bücher ist 5
        anzBuecher = 0;                 // Beim Erstellen eines neuen Genres sind noch keine Bücher vorhanden.
    }

    /**
     * das ist eine Methode um ein Buch dem Genre hinzuzufügen.
     * @param buch ein Buch was hinzugefügt werden soll.
     */
    public void addBuch(Buch buch) {
        buecher[anzBuecher] = buch;
        anzBuecher++;
    }

    /**
     * Methode um alle Bücher anzuzeigen.
     * Die Bücher werden mit dem Buchtitel aufgelistet und werden nummeriert.
     */

    public void showBuecher() {
        if (anzBuecher == 0) {
            System.out.println("Es sind keine Bücher erfasst");
        } else {
            for (int x = 0; x < anzBuecher; x++){
                System.out.println("<"+x+">\t"+ buecher[x].getTitel());
            }
        }
    }

    /**
     * Methode um ein Buch zu läschen.
     *
     * @param zahl Die Nummer des Buches das gelöscht werden söll.
     *             Die Nummer entsteht mit einer Nummerierung.
     */

    public void removeBuch(int zahl) {
        if (zahl > anzBuecher || zahl < 0) {
            System.out.println("Zeichen steht nicht zur auswahl. Bitte wählen sie erneut:");
        }else {
            Buch[] buecherCopy = new Buch[MAX_BUECHER];
            int anzBuecherCopy = 0;
            for (int x = 0; x < anzBuecher; x++){
                if (x != zahl) {
                    buecherCopy[anzBuecherCopy] = buecher[x];
                    anzBuecherCopy++;
                }
            }
            buecher = buecherCopy;
            anzBuecher = anzBuecherCopy;
        }
    }


    /**
     * Setter für das Attribut "name"
     *
     * @param name
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter für das Attribut "name"
     * @return
     */

    public String getName() {
        return name;
    }
}

