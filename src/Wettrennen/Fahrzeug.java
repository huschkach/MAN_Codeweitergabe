package Wettrennen;

import java.util.ArrayList;

public class Fahrzeug {
    // Attribute
    public String farbe = "Grau";
    public int ps = 120;
    public int baujahr = 2000;
    public String marke = "MAN";
    public int gang = 1;
    public double speed = 0;
    public ArrayList<Reifen> reifen = new ArrayList<>();

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
}
