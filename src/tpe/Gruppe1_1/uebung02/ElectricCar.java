package tpe.Gruppe1_1.uebung02;

public class ElectricCar extends Car implements Electric {

    private boolean highVoltage;

    ElectricCar(String brand, int constructionYear, int price, boolean highVoltage) {
        super(brand, constructionYear, price);
        this.highVoltage = highVoltage;
    }

    @Override
    public int getVoltage() {
        return highVoltage ? HIGH_VOLTAGE : LOW_VOLTAGE;
    }
}
