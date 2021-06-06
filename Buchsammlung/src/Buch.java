/**
 * Diese Klasse beinhaltet den Buchtitel der Bücher die abgespeichert werden.
 * Das Buch wird in Genres eingeteilt und in diesen abgespeichert.
 *
 * @author luigi
 * @version 0.1
 * @since 02.05.2020
 */


public class Buch {
    private String titel;

    /**
     * Das ist der Konstruktor für ein Buch.
     *
     * @param titel der Buchtitel zum Buch.
     */

    public Buch(String titel) {
        this.titel = titel;
    }

    /**
     * Setter für das Attibut "titel"
     *
     * @param titel Titel zum Buch
     */

    public void setTitel(String titel) {
        this.titel = titel;
    }

    /**
     * Getter für das Attribut "titel"
     *
     * @return den Buchtitel des Buches.
     */

    public String getTitel() {
        return titel;
    }

}

