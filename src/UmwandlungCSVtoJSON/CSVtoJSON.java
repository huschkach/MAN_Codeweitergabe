package UmwandlungCSVtoJSON;

import Dateien.FileOperations;

import java.util.ArrayList;
import java.util.Arrays;

public class CSVtoJSON {
    // TODO: Tidy up!

    private static ArrayList<Knoten> endNodes;
    private static ArrayList<Knoten> nodeList;
    private static ArrayList<Edges> edgeList;

    public static void main(String[] args) {
        // TODO: Einfügen von Eingabeoption
        String filename = "Z:\\Contractor\\IHK\\MAN_Inhouse_2025\\MAN_Codeweitergabe\\src\\UmwandlungCSVtoJSON\\segments_neue Strecke 4.0.csv";
        String json_filename = "map.json";

        testMethod(filename, json_filename);
    }

    public static void writeNodesToFile(ArrayList<Knoten> nodeList, String filename){
        StringBuilder builder = new StringBuilder();

        builder.append("\"nodes\": [\n");
        for(Knoten knoten: nodeList){
            builder.append(knoten.jsonAusgabe() + ",\n");
        }
        builder.delete(builder.length() - 2, builder.length());
        builder.append("\n],\n");

        FileOperations.appendFile(filename, builder.toString());
    }

    public static void writeEdgesToFile(ArrayList<Edges> edgeList, String filename){
        StringBuilder builder = new StringBuilder();

        builder.append("\"edges\": [\n");

        for(Edges edges: edgeList){
            builder.append(edges.jsonAusgabe() + ",\n");
        }
        builder.delete(builder.length() - 2, builder.length());
        builder.append("\n],\n");

        FileOperations.appendFile(filename, builder.toString());
    }

    public static void testMethod(String filename, String json_filename){
        String content = FileOperations.getFileContent(filename);

        String[] contentArray = removeFirstString(content);

        filterNodes(contentArray);
        edgeFinder();

        writeNodesToFile(nodeList, json_filename);

        writeEdgesToFile(edgeList, json_filename);


        /*
        for(String i : stringArray){
            System.out.println(i + "\n");
        }
        */


    }

    public static void edgeFinder(){
        edgeList = new ArrayList<>();

        for(int i = 0; i < nodeList.size(); i++){
            Knoten startNode = nodeList.get(i);

            for(int j = 0; j < endNodes.size(); j++){
                Knoten endNode = endNodes.get(j);

                if(startNode.getGraphX() == endNode.getGraphX() &&
                   startNode.getGraphY() == endNode.getGraphY() &&
                   startNode.getGraphZ() == endNode.getGraphZ()){
                    Edges edge = new Edges(startNode.getId(), endNode.getId());
                    edgeList.add(edge);
                }
            }
        }

        for(int i = 0; i < edgeList.size(); i++){
            String id = "" + (i + 1);
            edgeList.get(i).setId(id);
        }
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

    public static void filterNodes(String[] pointArray){
        ArrayList<String> pointList = new ArrayList<>(Arrays.asList(pointArray));

        nodeList = new ArrayList<>();

        endNodes = new ArrayList<>();
        // ArrayList Endpunkte
        String[] lastPoint = pointList.get(0).split(";");
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
                if(i != 0){
                    Knoten node = new Knoten(lastPoint[0],
                                                Conversion.normalizeSynaos(lastPoint[2]),
                                                Conversion.normalizeSynaos(lastPoint[3]));
                    endNodes.add(node);
                }
            }
            lastPoint = point;
            // vorangegangener Eintrag = current
        }

        Knoten node = new Knoten(lastPoint[0],
                Conversion.normalizeSynaos(lastPoint[2]),
                Conversion.normalizeSynaos(lastPoint[3]));
        endNodes.add(node);

        // letzter Eintrag muss auch umgewandelt und zu Endpunkte

        /*
        for(Knoten nodes : nodeList){
            System.out.println(nodes.jsonAusgabe());
        }

        for(Knoten nodes : endNodes){
            System.out.println(nodes.jsonAusgabe());
        }
        */
    }
}
