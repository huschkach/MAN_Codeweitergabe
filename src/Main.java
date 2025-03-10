public class Main {

    public static void main(String[] args) {
        int zahl = 9;
        String wort = "Hallo";

        // Gezählte Schleife
        // i ist die Zählvariable
        // SOLANGE i kleiner ist als die Länge der Variable wort, erhöhe i um Schrittweite 1
        for(int i = 0; i < wort.length(); i++){
            System.out.println(wort.charAt(i));
        }

        int i = 9;

        // Sichtbarkeit
        {
            float gleitkomma = 3.4567f;
        }

        AndereKlasse andere = new AndereKlasse();

        andere.zahl = 45;

        System.out.println("Hello World!");

        zahl = 7;
        zahl = zahl + 1;
        zahl += 1;

        // Java statisch typisiert
        // zahl = "World";
        // String zahl;

        System.out.println(zahl);

        verzweigung();

        schleifen();
    }

    public void andereMethode(){
        String zahl = "6";
    }

    public static void verzweigung(){

        System.out.println("Verzweigung");

        int a = 8, b = 1;
        char sign = '-';

        // Optimierung: Je weiter oben die Option steht, desto häufiger sollte sie wahr sein
        // WENN sign gleich '**
        if(sign == '*'){
            // DANN Gib auf der Konsole das Ergebnis von a * b aus
            System.out.println(a * b);
        } // SONST WENN sign gleich -
        else if(sign == '-'){
            // DANN Gib auf der Konsole das Ergebnis von a - b aus
            System.out.println(a - b);
        } else if(sign == '+'){
            System.out.println(a + b);
        }
        else if(sign == '/'  && b != 0){
            // DANN Gib auf der Konsole das Ergebnis von a / b aus
            System.out.println(a / b);
        }

        /*
        if(sign == '*'){
            //mach dies
        } else {
            if(sign == '/'){
                // mach jenes
            } else {
                if (sign == '-'){
                    // oder dieses
                }
            }
        }
        */

        // == Gleichheit
        // != Ungleich -> sign != '*'
        // < kleiner als (Zahlenwerte)
        // > größer als
        // <= kleiner gleich
        // = Zuweisung

        // Boole'sche Algebra
        // AND/UND-Verknüpfung  -> &&
        //  a   b       y
        //  0   0       0
        //  0   1       0
        //  1   0       0
        //  1   1       1

        // OR/ODER-Verknüpfung  -> ||
        //  a   b       y
        //  0   0       0
        //  0   1       1
        //  1   0       1
        //  1   1       1

        // NOT/NICHT-Verknüpfung -> !
        //  a       y
        //  0       1
        //  1       0

        if(true){
            System.out.println("Diese Aussage ist wahr");
        }


        switch(sign){
            case '*':
                System.out.println(a * b);
                break; // Wenn nicht vorhanden, dann "Durchfallen" der Fälle
            case '/': // Überprüfung nur auf einen Wert
                System.out.println((a / b));
                break;
            case '-':
                System.out.println(a - b);
                break;
            case '+':
                System.out.println(a + b);
                break;
            default:
                System.out.println("Das Rechenzeichen ist nicht bekannt.");
                break;
        }
    }

    public static void schleifen(){

        // while-Schleife -> Kopfgesteuerte Schleife
        int abbruch = 10;
        while(true){
            System.out.println("Hallo");

            if(abbruch != 0){
                abbruch--;
                // Dekrement
            } else{
                break;
            }
        }

        abbruch = 10;
        while(abbruch != 0){
            System.out.println("Welt");
            abbruch--;
        }

        /*
        int x = 1;
        int y = 0;

        while( y < x){
            y = x;
            x++;
        }
        System.out.println("x: " + x);
        System.out.println("y: " + y);
        */


        //      0 101 -> 5
        //     +0 011 -> 3
        //      1 000 -> -0
        //
        //      1 011 -> -3
        //     +0 101 -> +5
        //      0 000 -> 0

        //      0000 -> 0111 0 ->7
        //      1000 -> 1111 -8 -> -1
        //
        //      0001 -> 1110 (Invertierung = Einserkomplement) -> 1111 (+1 = ZweierKomplement)
        //
        //      1111        0100    0100 -> 4
        //     +0001       +1110   +0100 -> 4
        //   1...0000  11...0010    1000 -> -8
        // => Y2k38 -> Jahr-2038-Problem

        // For-Schleife -> Gezählten Schleife
        for(int i = 34; i <= 40; i++){
            System.out.println(i);
        }

        int potenz = 30;
        long basis = 3;

        long ergebnis = 1;

        /*
        ergebnis = ergebnis * basis; // 1 * 3 = 3
        ergebnis = ergebnis * basis; // 3 * 3 = 9
        ergebnis = ergebnis * basis;´// 9 * 3 = 27
        ergebnis = ergebnis * basis; // 27 * 3 = 81
        */

        // int = 32 Bit -> long = 64 Bit
        for(int i = 0; i < potenz; i++){
            ergebnis = ergebnis * basis;
        }

        System.out.println(ergebnis);

        int durchlauf = 0;

        // Do-While-Schleife -> Fußgesteuerte Schleife
        // Wird mindestens einmal durchlaufen
        do{
            // Schleifenkörper
            System.out.println(durchlauf + ".Schleifendurchlauf");
            durchlauf++;
        } while(durchlauf < 10); // Schleifenfuß
    }
}
