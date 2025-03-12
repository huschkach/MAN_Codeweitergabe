import java.util.Scanner;

public class Taschenrechner {

    public static void main(String[] args) {
        // rechner();
        // fakultaet_function();
        System.out.println(fakultaet_rekursiv(7) + "\n");

        System.out.println(potenz_berechnen(6,4));
        System.out.println(potenz_berechnen(4,6));
    }

    // Pascal_Case
    // CamelCase
    // snake_case
    // varianteZwischenDrinGr0ß
    // GLOBALE_VARIABLEN


    public static void rechner(){
        double zahl1 = 0.0, zahl2 = 0.0;
        String sign = "";
        // Deklarieren des Objekts Scanner names scanner
        // Scanner scanner = new Scanner(System.in);
        // Instanziierung eines Objekts vom Typen Scanner
        // System.in = Basicinputstream = Konsoleneingabe

        /*
        System.out.println("Bitte geben Sie Zahl 1 ein: ");
        try{
            zahl1 = scanner.nextDouble();
        } catch (Exception e){
            System.out.println("Es ist ein Fehler aufgetreten");
        }
        */

        // zahl1 = Eingaben.double_einlesen("Zahl 1");
        zahl1 = Eingaben.enter_text_convert_double("Zahl 1");
        // zahl2 = Eingaben.double_einlesen("Zahl 2");
        zahl2 = Eingaben.enter_text_convert_double("Zahl 2");

        // Scanner scanner = new Scanner(System.in);

        //System.out.println("Bitte geben Sie das Rechenzeichen ein: ");
        // sign = scanner.nextLine();
        sign = Eingaben.string_einlesen("Rechenzeichen");

        // scanner = new Scanner(System.in);

        /*
        System.out.println("Bitte geben Sie Zahl 2 ein: ");
        try{
            zahl2 = scanner.nextDouble();
        } catch (Exception e){
            System.out.println("Es ist ein Fehler aufgetreten");
        }
        */


        double ergebnis = 0.0;
        if(sign.equals("/") && zahl2 != 0){
            ergebnis = zahl1 / zahl2;
        } else if (sign.equals("*")) {
            ergebnis = zahl1 * zahl2;
        } else if (sign.equals("-")) {
            ergebnis = zahl1 - zahl2;
        } else if (sign.equals("+")) {
            ergebnis = zahl1 + zahl2;
        } else {
            System.out.println("Das Rechenzeichen exisitiert nicht.");
        }

        System.out.println("Die Rechnung " + zahl1 + " " + sign + " " + zahl2 + " ergibt als Ergebnis: " + ergebnis);

    }

    public static void fakultaet_function(){
        // 6! = 1 * 2 * 3 * 4 * 5 * 6 = 720
        // 0! = 1

        int zahl = 7;
        int fak = 1;

        for(int i = 1; i <= zahl; i++){
            fak *= i;
        }

        System.out.println("Die Fakultät der Zahl " + zahl + " ist: " + fak);
    }


    public static int fakultaet_rekursiv(int zahl){
        // divide and conquer
        if (zahl == 0){
            //  Fakultät von 0 ist als 1 definiert
            return 1;
        } else {
            int aktuell = fakultaet_rekursiv(zahl - 1) * zahl;
            System.out.println(aktuell);
            return aktuell;
        }

        // 1 * (2 - 1) * (3 - 1) * (4 - 1) * .... * (n - 1) * n

        // 7 * (7 - 1)!
        // 7 * (7 - 1) * (6 - 1)!

    }


    /* Es kann nur eine der beiden Methoden geben
    public static int potenz_berechnen(int basis){
        // Möglichkeit um mit Default-Werten arbeiten zu können.
        return potenz_berechnen(basis, 1);
    }

    public static int potenz_berechnen(int exponent){
        // Möglichkeit um mit Default-Werten arbeiten zu können.
        return potenz_berechnen(0, exponent);
    }
    */

    // Mehrere Methoden mit dem gleichen Namen sind gültig -> Überladen/Overloading
    public static int potenz_berechnen(){
        return potenz_berechnen(0, 1);
    }


    public static int potenz_berechnen(int basis, int exponent){
        if (exponent == 0){
            return 1;
        } else {
            return potenz_berechnen(basis, exponent - 1) * basis;
            // (exponent * basis) * basis
        }

        // 2^4 => 2 * 2 * 2 * 2    * 1
        //      2^4  2^3  2^2  2^1  2^0
        // 2^4 => 2^3 * 2 => 2^2 * 2 => 2^1 * 2 => 2^0 * 2 => 1
        // ----> Aufbau der Rechnung vom Start aus betrachtet:
        // 2^4 = 2 * 2^3 = 2 * 2 * 2^2 = 2 * 2 * 2 * 2^1 = 2 * 2 * 2 * 2 * 2^0 = 2 * 2 * 2 * 2 * 1

        // Auflösung bzw Berechnung
        // 1 => 1 * 2 => 1 * 2 * 2  =>  1 * 2 * 2 * 2   =>  1 * 2 * 2 * 2 * 2
        // 1 => 1 * 2 =>  2 * 2     =>      4 * 2       =>         8 * 2
    }
}
