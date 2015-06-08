package tpe.Gruppe1_1.uebung02.aufgabe03;

import java.io.Serializable;

public class GasolineCar extends Car implements Gasoline, Serializable {

    private int emissionTier;

    public GasolineCar(String brand, int constructionYear, int price, int emissionTier) {
        super(brand, constructionYear, price);
        this.emissionTier = emissionTier;
    }

    public GasolineCar(int id) {
        super(id);
    }

    @Override
    public int getEmissionTier() {
        return emissionTier;
    }
}
