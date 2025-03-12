package Wettrennen;

import java.util.ArrayList;

public class MainWettrennen {

    // static Methoden können auch verwendet werden, wenn KEINE Instanziierung stattgefunden hat.
    public static void main(String[] args) {

        /*
        // Reifen.getMaxSpeed();
        Reifen reifen = new Reifen();

        double speed = reifen.getMaxSpeed();

        System.out.println(speed);
        */

        Auto auto = new Auto();
        Auto bmw = new Auto("Blau", 245, 2022, "BMW", 1, 0.0, new ArrayList<>());

        System.out.println(auto.getFarbe());
        System.out.println(bmw.getFarbe());

        System.out.println(auto);
        System.out.println(bmw);

        Motorrad bike = new Motorrad();

        System.out.println(bike.getFarbe());

        System.out.println(bike.getClass());

        if(bike instanceof Fahrzeug){
            System.out.println("Motorrad ist auch ein Fahrzeug");
        }



    }


}
