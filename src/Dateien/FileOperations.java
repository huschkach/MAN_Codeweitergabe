package Dateien;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileOperations {

    // CRUD
    // -> C: CREATE -> writeFile(filename)
    // -> R: READ   -> readFile(filename)
    // -> U: UPDATE -> muss selbst geschrieben werden
    // -> D: DELETE -> deleteFile(filename)

    public static void createFile(String filename){
        // Diese Methode soll Dateien basierend auf ihrem Dateinamen anlegen
        File myFile = new File(filename);
        // firstfile.txt -> Relativen Pfad
        // "Z:/Contractor/IHK/MAN_Inhouse_2025/firstfile.txt" -> Absoluten Pfad

        try {
            boolean file = myFile.createNewFile();

            if(file){
                System.out.println("Die Datei wurde erfolgreich erstellt.");
            } else {
                System.out.println("Die Datei existiert bereits.");
                // Erweiterungsidee: Möglichkeit zum Überschreiben implementieren
            }
        } catch (IOException e){
            System.out.println("Es gab Probleme beim Erstellen der Datei");
        }
    }

    public static void writeFile(String filename, String content){
        // Löscht alles was in der Datei war und beschreibt diese potentiell neu
        try{
            FileWriter fileWriter = new FileWriter(filename);
            fileWriter.write(content);

            fileWriter.write("\nbla bla bla - Armin");
            fileWriter.close();
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void appendFile(String filename, String content){
        try{
            // Anhängen an den Dateiinhalt
            FileWriter fileWriter = new FileWriter(filename, true);
            fileWriter.write(content);

            // fileWriter.write("\nbla bla bla - Armin");
            fileWriter.close();
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void readFile(String filename){
        String content = "";
        File myFile = new File(filename);

        StringBuilder  builder = new StringBuilder()
;
        try{
            Scanner scanner = new Scanner(myFile);

            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                // content += line; // Funktioniert, ABER diese Art gilt seit längerem als "unschön"
                builder.append(line);
            }

            scanner.close();
        } catch (Exception e){
            System.out.println("Die Datei existiert nicht");
        }

        System.out.println(builder);
    }

    public static String getFileContent(String filename){
        File myFile = new File(filename);

        StringBuilder  builder = new StringBuilder();
        try{
            Scanner scanner = new Scanner(myFile);

            while(scanner.hasNextLine()){
                String line = scanner.nextLine() + "\n";
                // content += line; // Funktioniert, ABER diese Art gilt seit längerem als "unschön"
                builder.append(line);
            }

            scanner.close();
        } catch (Exception e){
            System.out.println("Die Datei existiert nicht");
        }

        return builder.toString();
    }

    public static void deleteFile(String filename){
        File myFile = new File(filename);

        try{
            if(myFile.delete()) {
                System.out.println("Die Datei wurde gelöscht");
            } else{
                System.out.println("Die Datei hat sicher der Löschung entzogen");
            }
        } catch (Exception e){
            System.out.println("Die Datei konnte aus noch unbekannten Gründen nicht gelöscht werden.");
        }
    }

    public static void main(String[] args) {
        String filename = "datei.txt";
        String content = "Kochen, Backen, Putzen";

        createFile(filename);
        writeFile(filename, content);
        appendFile(filename, content);
        readFile(filename);
        deleteFile(filename);
    }
}
