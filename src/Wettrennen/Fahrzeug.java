package Wettrennen;

import java.util.ArrayList;

public class Fahrzeug extends AbstraktHupe implements Motion, Motor{
    // Attribute
    public String farbe = "Grau";
    public int ps = 120;
    public int baujahr = 2000;
    public String marke = "MAN";
    public int gang = 1;
    public double speed = 0; // m/s
    public ArrayList<Reifen> reifen = new ArrayList<>();

    public double entfernung = 0.0; // m


    // Konstruktoren
    public Fahrzeug() {
    }

    public Fahrzeug(String farbe, int ps, int baujahr, String marke,
                    int gang, double speed, ArrayList<Reifen> reifen) {
        this.farbe = farbe;
        this.ps = ps;
        this.baujahr = baujahr;
        this.marke = marke;
        this.gang = gang;
        this.speed = speed;
        this.reifen = reifen;
    }

    // Methoden

    public String getFarbe() {
        return farbe;
    }

    public void setFarbe(String farbe) {
        this.farbe = farbe;
    }

    public int getPs() {
        return ps;
    }

    public void setPs(int ps) {
        this.ps = ps;
    }

    public int getBaujahr() {
        return baujahr;
    }

    public void setBaujahr(int baujahr) {
        this.baujahr = baujahr;
    }

    public String getMarke() {
        return marke;
    }

    public void setMarke(String marke) {
        this.marke = marke;
    }

    public int getGang() {
        return gang;
    }

    public void setGang(int gang) {
        this.gang = gang;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public ArrayList<Reifen> getReifen() {
        return reifen;
    }

    public void setReifen(ArrayList<Reifen> reifen) {
        this.reifen = reifen;
    }

    @Override
    public void press_horn(){
        System.out.println("Tut tut");
    }

    @Override
    public String toString(){
        return this.farbe + " " + this.marke + " " + this.baujahr + " - "
                + this.speed*3.6 + " km/h, " + this.entfernung + " m";
    }


    // Interfacemethoden
    public void fahren(){
        // Bewegung immer in 1s Schritten
        if(speed > 0.0){
            entfernung += speed;

            if(speed <= 55.56){
                speed *= 1.001;
                // speed = speed * 1.001;
            } else {
                speed = 55.65;
            }
        } else {
            speed = 0.2;
        }
    };

    public void bremsen(){

    };

    public void starten(){};

    public void stoppen(){};

}
