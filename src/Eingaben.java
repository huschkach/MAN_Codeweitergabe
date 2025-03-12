import java.util.InputMismatchException;
import java.util.Scanner;

public class Eingaben {
    public static void main(String[] args) {
        eingaben();
    }

    public static double double_einlesen(String text){

        double zahl = 0.0;

        while(true){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Bitte geben Sie " + text + " ein: ");
            try{
                zahl = scanner.nextDouble();
                break;
            } catch (Exception e){
                System.out.println("Es ist ein Fehler aufgetreten");
            } finally {
                scanner.close();
            }
        }

        return zahl;
    }

    public static double enter_text_convert_double(String text){
        System.out.println("Bitte geben Sie " + text + " ein: ");
        String zahl;
        double double_zahl = 0.0;
        boolean correct = false;


        while(!correct){
            Scanner scanner = new Scanner(System.in);
            zahl = scanner.next();

            try{
                // Umwandeln eines Strings in ein double
                double_zahl = Double.parseDouble(zahl);
                if (Double.isInfinite(double_zahl)){
                    throw new Exception("Infinite is too big");
                }
                correct = true;
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        return double_zahl;
    }


    public static String string_einlesen(String text){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bitte geben Sie das " + text + " ein: ");
        return scanner.nextLine();
    }

    public static void eingaben(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bitte gib deinen Namen ein: ");

        String namen = scanner.nextLine();
        System.out.println("Hallo " + namen);

        System.out.println("Wie viele Hände hast du: ");

        int anzahl_hands = 0;

        while(true) {
            try { // Code innerhalb der Klammern wird versucht durchzuführen
                anzahl_hands = scanner.nextInt();
                break;
            } catch (InputMismatchException ime){
                ime.printStackTrace();
            } catch (Exception e) { // Wenn ein Fehler im try-Block auftritt, wird der Fehler abgefangen
                System.out.println("Gib bitte eine Zahl ein");
            } finally { // Wird immer ausgeführt.
                System.out.println("Der Try-Catch-Block wird nun verlassen.");
                scanner = new Scanner(System.in);
            }
        }

        scanner.close();


        /*
        String hands = scanner.nextLine();

        if(hands.equals("zwei") || hands.equals("Zwei") || hands.equals("2")){
            anzahl_hands = 2;
        } else if(hands.equals(("drei")) || hands.equals("Drei") || hands.equals("3")){
            anzahl_hands = 3;
        } else {
            System.out.println("Wie kam es dazu, dass du keine zwei Hände hast?");
        }

        /*
        switch(hands){
            case "zwei":
            case "Zwei":
            case "2":
                anzahl_hands = 2;
                break;
        }
        */




        if(anzahl_hands != 2){
            System.out.println("Wie kam es denn dazu, dass du keine 2 Hände hast?");
        } else {
            System.out.println("Schön ich auch!");
        }
    }
}
