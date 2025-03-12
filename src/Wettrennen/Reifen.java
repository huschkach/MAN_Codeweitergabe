package Wettrennen;

public class Reifen {
    // POJO - Plain Old Java Object
    // Bezeichnet ein ganz normales Objekt bzw die entsprechende Klasse

    // final sorgt dafür, dass das Attribut nicht mehr geändert werden kann.
    // Attribute
    public String brand = "Goodyear"; // Jede Klasse kann darauf zugreifen

    protected String weather = "Summer"; // Die eigene Klasse und davon abgeleitete Klassen können darauf zugreifen
    // In Java das komplette Paket(package)

    private double maxSpeed = 200; // Kann nur noch innerhalb der eignen Klasse gesehen + verändert werden


    // Konstruktoren
    public Reifen(){}

    public Reifen(String brand, String weather, double maxSpeed){
        this.brand = brand;
        this.weather = weather;
        this.maxSpeed = maxSpeed;
    }

    // Methoden
    // Setter+Getter
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getBrand(){
        return this.brand;
    }

    public String getWeather(){
        return weather;
    }

    public double getMaxSpeed(){
        return this.maxSpeed;
    }
}
