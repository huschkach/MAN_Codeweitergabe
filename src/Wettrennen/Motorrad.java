package Wettrennen;

import java.util.ArrayList;

// Die Klasse Motorrad erweitert die Klasse Fahrzeug um folgende Attribute und Methoden:
public class Motorrad extends Fahrzeug{

    private String kennzeichen = "A-IH-4532";

    public Motorrad(){}

    public Motorrad(String farbe, int ps, int baujahr, String marke,
                    int gang, double speed, ArrayList<Reifen> reifen,
                    String kennzeichen) {
        super(farbe, ps, baujahr, marke, gang, speed, reifen);
        this.kennzeichen = kennzeichen;
    }


}

