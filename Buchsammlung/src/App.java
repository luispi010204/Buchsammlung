/**
 * Diese Klasse App verwaltet die Buchsammlung.
 * Sie verwaltet die Kommunikation mit dem Benutzer.
 * Diese Klasse verwendet die Klasse Einleser2.java, um die Eingaben zu verwalten.
 *
 * @author luigi
 * @version 0.1
 * @since 02.05.2020
 */


public class App {
    Sammlung sammlung;
    Einleser2 einleser2;

    public App() {
        sammlung = new Sammlung();
        einleser2 = new Einleser2();
        initSammlung();
    }

    public static void main(String[] args) {
        App app = new App();
        app.run();
    }

    public void run() {
        Einleser2 einleser = new Einleser2();

        char auswahlMenue = ' ';

        while (auswahlMenue != 'x') {

            System.out.println("Willkommen in der Buchsammlung \n Was möchten sie machen? Wählen sie: \n a\t um die Buchsammlung anzuzeigen" +
                    "\n b\t um ein neues Buch hinzuzufügen \n g\t um ein neues Genre hinzuzufügen \n l\t um ein Buch oder Genre zu löschen");

            auswahlMenue = einleser.readChar();

            if (auswahlMenue == 'a') {
                auswahlAnzeigen();
            } else if (auswahlMenue == 'b') {
                auswahlBuchErstellen();
            } else if (auswahlMenue == 'g') {
                auswahlGenreErstellen();
            } else if (auswahlMenue == 'l') {
                auswahlLoeschen();
            }


            System.out.println("\nDrücken sie h um zum Hauptmenue zurück zu kehren.");
            System.out.println("Drücken sie x um das Programm zu schliessen.");
            auswahlMenue = einleser.readChar();

        }
        System.out.println("Auf wiedersehen! Bis zum nächsten Mal =)");
    }

    /**
     * Das ist eine Methode um die gewählte Auswahl anzuzeigen.
     */
    private void auswahlAnzeigen() {

        System.out.println("Welches Genre möchten sie anzeigen? \nWählen sie ein Genre durch die Zahl:");
        int auswahlZahl;
        sammlung.showGenres();
        while (true) {
            auswahlZahl = einleser2.readInt();
            if (auswahlZahl > (sammlung.getAnzGenres() - 1) || auswahlZahl < 0 ) {
                System.out.println("Diese Zahl steht nicht zur Auswahl.");

            } else {
                break;

            }
        }
        Genre genre = sammlung.getGenre(auswahlZahl);

        System.out.println("Sie haben das Genre " + genre.getName() + " gewählt, \nhier sind alle Bücher aus diesem Genre:");

        genre.showBuecher();
    }


    /**
     * Das ist eine Methode um ein Buch zu erstellen und hinzuzufügen.
     */

    private void auswahlBuchErstellen() {
        System.out.println("Zu welchem Genre möchten sie das Buch hinzufügen? \nWählen sie ein Genre durch die Zahl:\n");
    int auswahlZahl;
        sammlung.showGenres();

        while (true) {
        auswahlZahl = einleser2.readInt();
        if (auswahlZahl > sammlung.getAnzGenres() - 1) {
            System.out.println("Diese Zahl steht nicht zur Auswahl.");

        } else {
            break;

        }
    }

    Genre genre = sammlung.getGenre(auswahlZahl);

        System.out.println("Sie haben das Genre " + genre.getName() + " gewählt.\nGeben sie jetzt den Buchtitel des neuen Buches ein:");

    String titel = einleser2.readString();
        genre.addBuch(new Buch(titel));

        System.out.println("Das Buch  wurde dem Genre " + genre.getName() + " hinzugefügt.");
}

    /**
     * Das ist eine Methode um ein Genre zu erstellen und hinzuzufügen.
     */

    private void auswahlGenreErstellen() {
        System.out.println("Welches Genre möchten sie hinzufügen? \nhier eingeben:");

        String name = einleser2.readString();
        Genre newGenre = new Genre(name);

        sammlung.addGenre(newGenre);

        System.out.println("Sie haben das Genre " + newGenre.getName() + " hinzugefügt.");
    }


    /**
     * Das ist eine Methode um das ausgewählte Buch oder Genre zu löschen.
     */

    private void auswahlLoeschen() {
        System.out.println("Was möchten sie löschen? Wählen sie: \nG für Genre \n B für Buch");

        char eingabeLoeschen = einleser2.readChar();

        if (eingabeLoeschen == 'G') {

            System.out.println("Welches Genre möchten sie löschen?\nGeben sie die Zahl ein:");
            sammlung.showGenres();
            int auswahlZahl;
            while (true) {
                auswahlZahl = einleser2.readInt();
                if (auswahlZahl > sammlung.getAnzGenres() - 1) {
                    System.out.println("Diese Zahl steht nicht zur Auswahl.");

                } else {
                    break;

                }
            }

            int wasLoeschen = auswahlZahl;
            System.out.println("Das Genre " + sammlung.getGenre(wasLoeschen).getName() + " und Inhalt wurde gelöscht.");
            sammlung.removeGenre(wasLoeschen);
        } else if (eingabeLoeschen == 'B') {
            System.out.println("Aus welchem Genre wollen sie ein Buch löschen? \nWählen sie:");
            sammlung.showGenres();
            Genre genre = sammlung.getGenre(einleser2.readInt());
            System.out.println("Sie haben das Genre " + genre.getName() + " gewählt.\nWelches Buch wollen sie löschen?");
            genre.showBuecher();
            genre.removeBuch(einleser2.readInt());
            System.out.println("Sie haben Das Buch erfolgreich gelöscht.");
        } else {
            System.out.println("Zeichen steht nicht zur Auswahl. Bitte wählen sie erneut:");
        }
    }

    /**
     * Das ist eine Liste von Bücher und Genres die von anfang an in der Sammlung vorhanden sind.
     */

    private void initSammlung() {

        Genre genre1 = new Genre("Fantasy");
        genre1.addBuch(new Buch("Der Herr der Ringe"));
        genre1.addBuch(new Buch("Harry Potter und der Stein der Weisen"));

        Genre genre2 = new Genre("Romantik");
        genre2.addBuch(new Buch("Der Klang des Härzens"));
        genre2.addBuch(new Buch("Don't love me"));

        Genre genre3 = new Genre("Krimi");
        genre3.addBuch(new Buch("Die Wächter"));

        sammlung.addGenre(genre1);         // Hier werden die Genres hinzugefügt.
        sammlung.addGenre(genre2);
        sammlung.addGenre(genre3);
    }


}
