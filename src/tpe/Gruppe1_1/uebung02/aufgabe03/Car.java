package tpe.Gruppe1_1.uebung02.aufgabe03;

public abstract class Car implements Comparable {

    private static int carIDCounter = 0;

    private int id;
    private String brand;
    private int constructionYear;
    private int price;


    public Car(String brand, int constructionYear, int price) {
        this.brand = brand;
        this.constructionYear = constructionYear;
        this.price = price;
        this.id = carIDCounter++;
    }

    Car(int id) {
        this.id = id;
    }

    @Override
    public int compareTo(Object o) {
        if(id == ((Car)o).id)
            return 0;
        else
            return (""+brand+constructionYear+price+id).compareTo(""+((Car)o).brand+((Car)o).constructionYear+((Car)o).price+((Car)o).id);
    }

    @Override
    public String toString() {
        return "[" + id + "] " + brand + ": " + constructionYear + ", " + price;
    }
}
