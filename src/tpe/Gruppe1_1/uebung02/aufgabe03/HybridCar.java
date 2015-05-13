package tpe.Gruppe1_1.uebung02.aufgabe03;

public class HybridCar extends Car implements Gasoline, Electric {

    boolean highVoltage;
    int emissionTier;

    public HybridCar(String brand, int constructionYear, int price, boolean highVoltage, int emissionTier) {
        super(brand, constructionYear, price);
        this.emissionTier = emissionTier;
        this.highVoltage = highVoltage;
    }

    @Override
    public int getVoltage() {
        return highVoltage ? HIGH_VOLTAGE : LOW_VOLTAGE;
    }

    @Override
    public int getEmissionTier() {
        return emissionTier;
    }
}
