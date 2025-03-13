package UmwandlungCSVtoJSON;

public class Conversion {
    public static double strToDouble(String text){
        double zahl = 0.0;
        try{
            zahl = Double.parseDouble(text);
        } catch (Exception e){
            e.printStackTrace();
        }
        return zahl;
    }

    public static double normalizeSynaos(String text){
        return strToDouble(text) / 1000.0;
    }
}
