package UmwandlungCSVtoJSON;

public class Edges{
    private String id;
    private String startNodeId;
    private  String endNodeId;

    public Edges() {
    }

    public Edges(String startNodeId, String endNodeId) {
        this.startNodeId = startNodeId;
        this.endNodeId = endNodeId;
    }

    public Edges(String id, String startNodeId, String endNodeId) {
        this.id = id;
        this.startNodeId = startNodeId;
        this.endNodeId = endNodeId;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String jsonAusgabe(){
        // Nodes vielleicht vertauscht?
        return "{\n"
                + "\t\"id\": \"" + id + "\",\n"
                + "\t\"startNodeId\": \"" + endNodeId + "\",\n"
                + "\t\"endNodeId\": \"" + startNodeId + "\"\n"
                + "}";
    }
}
