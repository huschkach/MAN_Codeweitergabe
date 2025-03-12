package Wettrennen;

public interface Motion {
    // Interface-methoden sind abstract, müssen also IMMER implementiert werden
    // Dadurch kann aber auch von zwei Interfaces gleichzeitig geerbt werdeen

    void fahren();

    void bremsen();
}
