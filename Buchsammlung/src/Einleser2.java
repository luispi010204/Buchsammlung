import java.io.Serializable;
import java.util.Scanner;

/**
 * Diese Klasse wird verwendet um von der Kommandoziele einzulesen.
 *
 * @author luigi Spina
 * @version 4.0
 * @since 2.05.2020
 */


public class Einleser2 {

    static Scanner scanner;


    public Einleser2() {
        scanner = new Scanner(System.in);
    }

    /**
     * Diese Methode kann verwendet werden um ein double vom Terminal einzulesen.
     *
     * @param "" kein Parameter vorhanden
     * @return Gibt einen Double zurück, welcher eingelesen wurde.
     */

    public double readDouble() {
        while (!scanner.hasNextDouble()) {
            System.out.println("Bitte eine Zahl eingeben!");
            scanner.next();
        }
        double zahl = scanner.nextDouble();
        return zahl;
    }

    /**
     * Diese Methode kann verwendet werden um ein int vom Terminal einzulesen.
     *
     * @param "" kein Parameter vorhanden
     * @return Gibt einen Int zurück, welcher eingelesen wurde.
     */

    public int readInt() {
        System.out.print("> ");
        while (!scanner.hasNextInt()) {
            scanner.next();
            System.out.println("Bitte eine Ganzzahl eingeben!");
            scanner.next();
        }
        int zahl = scanner.nextInt();
        scanner.nextLine();
        return zahl;
    }

    /**
     * Diese Methode kann verwendet werden um ein Boolean (true/false) vom Terminal einzulesen.
     *
     * @param "" kein Parameter vorhanden
     * @return Gibt einen Boolean (true/false) zurück, welcher eingelesen wurde.
     */

    public Boolean readBoolean() {
        while (!scanner.hasNextBoolean()) {
            System.out.println("Bitte \"true\" oder \"false\" eingeben!");
            scanner.next();
        }
        boolean bool = scanner.nextBoolean();
        return bool;
    }

    /**
     * Diese Methode kann verwendet werden um ein Boolean (ja/nein) vom Terminal einzulesen.
     *
     * @param "" kein Parameter vorhanden
     * @return Gibt einen Boolean (ja/nein) zurück, welcher eingelesen wurde.
     */

    public boolean readBooleanDeutsch() {
        boolean bool;
        String eingabe = scanner.nextLine();
        if (eingabe.equalsIgnoreCase("ja")) {
            bool = true;
        } else if (eingabe.equalsIgnoreCase("nein")) {
            bool = false;
        } else {
            System.out.println("Bitte \"ja\" oder \"nein\" eingeben!");
            bool = readBooleanDeutsch();
        }

        return bool;
    }

    /**
     * Diese Methode kann verwendet werden um ein char vom Terminal einzulesen.
     *
     * @param "" kein Parameter vorhanden
     * @return Gibt einen Char zurück, welcher eingelesen wurde.
     */
    public char readChar() {
        System.out.print("> ");
        String input = scanner.nextLine();
        if(!input.isEmpty()){
            char ch = input.charAt(0);
            while (ch != 'a' && ch != 'b' && ch != 'g' && ch != 'l' && ch != 'h' && ch != 'x' && ch != 'B' && ch != 'G' ) {
                System.out.println("Bitte einen Buchstaben aus der Auswahl eingeben!");
                System.out.print("> ");

                String text = scanner.nextLine();
                if (text.isEmpty()){
                    System.out.println("Diese Eingabe darf nicht leer bleiben. Bitte geben sie etwas ein.");
                    return readChar();
                }else{
                    ch =text.charAt(0);
                }
            }
            return ch;
        }else{
            System.out.println("Diese Eingabe darf nicht leer bleiben. Bitte geben sie etwas ein.");
            return readChar();
        }


    }


        /**
         * Diese Methode kann verwendet werden um ein String vom Terminal einzulesen.
         *
         * @param "" kein Parameter vorhanden
         * @return Gibt einen String zurück, welcher eingelesen wurde.
         */

        public String readString() {

            while (!scanner.hasNext()) {
                System.out.println("Bitte einen Text eingeben!");
                scanner.next();
            }
            String text = scanner.nextLine();
            return text;
        }

    }
