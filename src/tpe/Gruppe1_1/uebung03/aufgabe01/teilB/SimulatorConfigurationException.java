package tpe.Gruppe1_1.uebung03.aufgabe01.teilB;

public class SimulatorConfigurationException extends Exception {

    String message;

    SimulatorConfigurationException(String message) {
        this.message = message;
    }

    public void printInfo() {
        System.out.println(message);
        printStackTrace(System.out);
    }
}
