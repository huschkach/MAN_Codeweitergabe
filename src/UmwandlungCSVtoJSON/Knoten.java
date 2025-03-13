package UmwandlungCSVtoJSON;

public class Knoten{
    private String id;
    private double graphX;
    private double graphY;
    private double graphZ;
    private int[] dependentNodeIDs;

    public Knoten() {
    }

    public Knoten(String id, double graphX, double graphY) {
        this.id = id;
        this.graphX = graphX;
        this.graphY = graphY;
    }

    public Knoten(String id, double graphX, double graphY, double graphZ, int[] dependentNodeIDs) {
        this.id = id;
        this.graphX = graphX;
        this.graphY = graphY;
        this.graphZ = graphZ;
        this.dependentNodeIDs = dependentNodeIDs;
    }

    public String jsonAusgabe(){
        return "{\n"
                + "\t\"id\": \"" + id + "\",\n"
                + "\t\"graphX\": " + graphX + ",\n"
                + "\t\"graphY\": " + graphY + ",\n"
                + "\t\"graphZ\": " + graphZ + ",\n"
                + "\t\"dependentNodeIds\": " + "[]\n" +
                "}";

    }

    public String getId() {
        return id;
    }

    public double getGraphX() {
        return graphX;
    }

    public double getGraphY() {
        return graphY;
    }

    public double getGraphZ() {
        return graphZ;
    }
}
