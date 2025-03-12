package Wettrennen;

public abstract class AbstraktHupe {
    // Kann nicht instanziiert werden
    private String hupton = "Tröt tröt";

    public AbstraktHupe(){};

    public void hupen(){
        System.out.println(hupton);
    }

    abstract void press_horn();
    // Muss von einer Kindklasse erst implementiert werden
}
