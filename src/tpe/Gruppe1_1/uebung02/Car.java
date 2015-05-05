package tpe.Gruppe1_1.uebung02;

public abstract class Car implements Comparable {

    private static int carIDCounter = 0;

    private int id;
    private String brand;
    private int constructionYear;
    private int price;


    Car(String brand, int constructionYear, int price) {
        this.brand = brand;
        this.constructionYear = constructionYear;
        this.price = price;
        this.id = carIDCounter++;
    }

    @Override
    public int compareTo(Object o) {
        if(id == ((Car)o).id)
            return 0;
        else if (id > ((Car)o).id)
            return 1;
        return -1;
    }

    @Override
    public String toString() {
        return "[" + id + "] " + brand + ": " + constructionYear + ", " + price;
    }
}
