/**
 * Diese Klasse ist eine Liste von Genres, welche Bücher beinhalten.
 * In dieser Klasse sind mehrere Genres möglich.
 *
 * @author luigi
 * @version 0.1
 * @since 02.05.2020
 */
public class Sammlung {

    private Genre[] genres;
    private int anzGenres;
    private final int MAX_GENRES = 10;


    public Sammlung() {
        genres = new Genre[MAX_GENRES];  // Die Sammlung hat maximal 5 Genres.
        anzGenres = 0;                  // zu Beginn hat die Sammlung noch keine Genres.
    }

    /**
     * Diese Methode fügt ein neues Genre der Sammlung hinzu.
     *
     * @param genre ein Neues Genre wird der Sammlung hinzugefügt.
     */

    public void addGenre(Genre genre) {
        genres[anzGenres] = genre;
        anzGenres++;
    }

    /**
     * eine Methode um alle Genres anzuzeigen.
     */

    public void showGenres() {
        if (anzGenres == 0) {
            System.out.println("Es sind keine Genres erfasst");
        } else {
            for (int x = 0; x < anzGenres; x++) {
                System.out.println("<" + x + ">\t" + genres[x].getName());
            }
        }
    }

    /**
     * Eine Methode um ein Genre zu löschen.
     * dabei wird der ganze Inhalt gelöscht.
     *
     * @param zahl Die Nummer des Genres das gelöscht werden söll.
     *             Die Nummer entsteht mit einer Nummerierung.
     */
    public void removeGenre(int zahl) {
        if (zahl > anzGenres || zahl < 0) {
            System.out.println("Zeichen steht nicht zur Auswahl. Bitte wählen sie erneut:");
        } else {
            Genre[] genresCopy = new Genre[MAX_GENRES];
            int anzGenresCopy = 0;
            for (int x = 0; x < anzGenres; x++) {
                if (x != zahl) {
                    genresCopy[anzGenresCopy] = genres[x];
                    anzGenresCopy++;
                }
            }
            genres = genresCopy;
            anzGenres = anzGenresCopy;
        }
    }

    /**
     * Eine Methode um das gewählte Genre auszugeben.
     *
     * @param zahl Die Nummer des Buches das gelöscht werden söll.
     *             Die Nimmer entsteht mit einer Nummerierung.
     * @return gibt ein Genre mit seiner Nummer zurück.
     */
    public Genre getGenre(int zahl) {
        if (zahl > anzGenres || zahl < 0) {
            System.out.println("Zeichen steht nicht zur Auswahl. Bitte wählen sie erneut:");
            return null;
        } else {
            return genres[zahl];
        }
    }

    public int getAnzGenres() {
        return anzGenres;
    }
}


