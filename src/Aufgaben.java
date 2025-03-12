public class Aufgaben {

    public static void main(String[] args) {

    }


    public static void prime(){
        int number = 1234512345;
        if(is_prime(number)){
            System.out.println(number + " ist eine Primzahl");
        } else {
            System.out.println(number + " ist keine Primzahl");
        }
    }

    public static boolean is_prime(int zahl){
        if (zahl <= 1){
            return false;
        }

        if(zahl == 2){
            return true;
        }

        if(zahl % 2 == 0){
            return false;
        }

        for(int i = 3; i < zahl/2; i += 2){
            if(zahl % i == 0){
                return false;
            }
        }
        return true;
    }


}
