package tpe.Gruppe1_1.uebung03.aufgabe01.teilB;

public class GeneralFlightSimulatorException extends Exception {

    private String message;

    public GeneralFlightSimulatorException(String message) {
        super(message);
        this.message = message;
    }

    public void printInfo() {
        System.err.println(message);
        printStackTrace(System.err);
    }
    
}
