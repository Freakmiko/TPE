package tpe.Gruppe1_1.uebung03.aufgabe01.teilB;

public class PlaneImpl implements Plane {

    private int currentHeight;
    private FlightRoute flightRoute;
    private boolean doorsOpen;
    private boolean isMoving;

    PlaneImpl(FlightRoute flightRoute) {
        if(flightRoute == null)
            throw new IllegalArgumentException("FlightRoute can't be null");

        this.flightRoute = flightRoute;

    }

    /**
     * Opens the doors of the airplane
     * To be able to open the doors the airplane must stop on ground.
     *
     * @throws GeneralFlightSimulatorException If airplane is in the air or doesn't stop on ground.
     */
    @Override
    public void openDoors() throws GeneralFlightSimulatorException {
        // TODO: check if this even makes sense
        if(isMoving)
            throw new GeneralFlightSimulatorException("Can't open the doors, the plane is still moving!");
        if(currentHeight > 0)
            throw new GeneralFlightSimulatorException("Can't open the doors, the plane is still flying!");

        doorsOpen = true;
    }

    /**
     * Closes the doors of the airplane
     */
    @Override
    public void closeDoors() {
        doorsOpen = false;
    }

    /**
     * Stops the airplane when it moves on the ground.
     *
     * @throws GeneralFlightSimulatorException If the airplane is in the air
     */
    @Override
    public void stop() throws GeneralFlightSimulatorException {
        if(currentHeight > 0)
            throw new GeneralFlightSimulatorException("Can't stop, the plane is still flying!");

        isMoving = false;
    }

    /**
     * Lets the airplane go on one more kilometer, the altitude
     * difference is passed as a parameter.
     *
     * @param additionalHeight The altitude difference the airplane is ascending/descending for the next
     *                         kilometer.
     *                         positive -> ascending, negative -> descending
     * @throws GeneralFlightSimulatorException If problems occur while flying.
     */
    @Override
    public void flyNextKilometer(int additionalHeight) throws GeneralFlightSimulatorException {
        if(additionalHeight > 100)
            throw new GeneralFlightSimulatorException("You can't ascend more than 100 meters in one kilometer!");

        isMoving = true;


    }
}
