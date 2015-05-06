package tpe.Gruppe1_1.uebung02.aufgabe03;

public class GasolineCar extends Car implements Gasoline {

    private int emissionTier;

    GasolineCar(String brand, int constructionYear, int price, int emissionTier) {
        super(brand, constructionYear, price);
        this.emissionTier = emissionTier;
    }

    GasolineCar(int id) {
        super(id);
    }

    @Override
    public int getEmissionTier() {
        return emissionTier;
    }
}
