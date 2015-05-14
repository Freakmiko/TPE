package tpe.Gruppe1_1.uebung03.aufgabe01.teilB;

public interface Plane {

    /**
     * Opens the doors of the airplane
     * To be able to open the doors the airplane must stop on ground.
     *
     * @throws GeneralFlightSimulatorException
     *          If airplane is in the air or doesn't stop on ground.
     */
    void openDoors() throws GeneralFlightSimulatorException;

    /**
     * Closes the doors of the airplane
     */
    void closeDoors();

    /**
     * Stops the airplane when it moves on the ground.
     *
     * @throws GeneralFlightSimulatorException
     *          If the airplane is in the air
     */
    void stop() throws GeneralFlightSimulatorException;

    /**
     * Lets the airplane go on one more kilometer, the altitude
     * difference is passed as a parameter.
     *
     * @param additionalHeight
     *          The altitude difference the airplane is ascending/descending for the next
     *          kilometer.
     *          positive -> ascending, negative -> descending
     * @throws GeneralFlightSimulatorException
     *          If problems occur while flying.
     */
    void flyNextKilometer(int additionalHeight) throws GeneralFlightSimulatorException;



}
