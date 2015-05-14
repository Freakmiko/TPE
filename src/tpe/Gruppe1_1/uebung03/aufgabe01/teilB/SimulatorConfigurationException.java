package tpe.Gruppe1_1.uebung03.aufgabe01.teilB;

public class SimulatorConfigurationException extends Exception {

    private String message;

    SimulatorConfigurationException(String message) {
        super(message);
        this.message = message;
    }

    public void printInfo() {
        System.err.println(message);
        printStackTrace(System.err);
    }
}
