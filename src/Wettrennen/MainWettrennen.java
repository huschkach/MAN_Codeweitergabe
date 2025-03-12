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

        /*
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

        // AbstraktHupe hupe = new AbstraktHupe();

         */

        ArrayList<Fahrzeug> fahrzeuge = new ArrayList<>();
        Motorrad motor1 = new Motorrad();
        Motorrad motor2 = new Motorrad();
        motor2.setFarbe("Rot");
        fahrzeuge.add(motor1);
        fahrzeuge.add(motor2);

        if( motor1 instanceof Fahrzeug){
            System.out.println("Das Motorrad ist ein Fahrzeug!");
        }

        Auto auto = new Auto();
        /*
        if(auto instanceof Fahrzeug){
        // Fehlermeldung weil es gecastet werden müsste
            fahrzeuge.add(auto);
        } else {
            System.out.println("Auto ist kein Fahrzeug");
        }
        */

        for(int i = 0; i < 3600; i++){
            for(Fahrzeug fahr : fahrzeuge){
                fahr.fahren();
                System.out.println(fahr);

                if(i == 3490 && fahr.getFarbe().equals("Rot")){
                    fahr.speed = 0.0;
                }
            }
        }




    }


}
