package tpe.Gruppe1_1.uebung03.aufgabe01.teilB;

public class GeneralFlightSimulatorException extends Exception {

    private String message;

    public GeneralFlightSimulatorException(String message) {
        this.message = message;
    }

    public void printInfo() {
        System.out.println(message);
        printStackTrace(System.out);
    }
    
}
