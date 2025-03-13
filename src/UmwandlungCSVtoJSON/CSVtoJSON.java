package UmwandlungCSVtoJSON;

import Dateien.FileOperations;

import java.util.ArrayList;
import java.util.Arrays;

public class CSVtoJSON {

    public static void main(String[] args) {
        String filename = "Z:\\Contractor\\IHK\\MAN_Inhouse_2025\\MAN_Codeweitergabe\\src\\UmwandlungCSVtoJSON\\segments_neue Strecke 4.0.csv";
        String json_filename = "map.json";

        testMethod(filename, json_filename);
    }

    public static void writeNodesToFile(ArrayList<Knoten> nodeList, String filename){
        StringBuilder builder = new StringBuilder();

        for(Knoten knoten: nodeList){
            builder.append(knoten.jsonAusgabe() + ",\n");
        }

        FileOperations.appendFile(filename, builder.toString());

    }

    public static void testMethod(String filename, String json_filename){
        String content = FileOperations.getFileContent(filename);

        String[] contentArray = removeFirstString(content);

        ArrayList<Knoten> nodeList = filterNodes(contentArray);

        writeNodesToFile(nodeList, json_filename);


        /*
        for(String i : stringArray){
            System.out.println(i + "\n");
        }
        */


    }

    // Teilt den Content auf in einzelne Strings und entfernt den ersten String mit Metadaten
    public static String[] removeFirstString(String content){
        // Teilt den Gesamtstring content in mehrere einzelne Strings auf
        String[] stringArray = content.split("\n");

        String[] contentArray = new String[stringArray.length - 1];

        for(int i = 1; i < stringArray.length; i++){
            contentArray[i - 1] = stringArray[i];
        }

        /*
        for(String i : contentArray){
            System.out.println(i + "\n");
        }
        */

        return contentArray;
    }

    public static ArrayList<Knoten> filterNodes(String[] pointArray){
        ArrayList<String> pointList = new ArrayList<>(Arrays.asList(pointArray));

        ArrayList<Knoten> nodeList = new ArrayList<>();

        // ArrayList Endpunkte
        // Merken vorangegangener Eintrag von pointList

        for(int i = 0; i < pointList.size(); i++){
            String current = pointList.get(i);

            String[] point = current.split(";");

            if(point[1].equals("0")){
                // Umwandeln vorangegangener Eintrag in Knoten und Speichern dieses Knotens in Endpunkte

                Knoten knoten = new Knoten(point[0],
                                            Conversion.normalizeSynaos(point[2]),
                                            Conversion.normalizeSynaos(point[3]));
                nodeList.add(knoten);
            }
            // vorangegangener Eintrag = current
        }

        // letzter Eintrag muss auch umgewandelt und zu Endpunkte

        for(Knoten nodes : nodeList){
            System.out.println(nodes.jsonAusgabe());
        }

        return nodeList;
    }
}
