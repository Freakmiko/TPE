package tpe.Gruppe1_1.uebung03.aufgabe01.teilB;

public class PlaneImpl implements Plane {

    int currentHeight;
    FlightRoute flightRoute;
    boolean doorsOpen;
    boolean isMoving;
    int distanceTraveled;

    PlaneImpl(FlightRoute flightRoute) {
        if(flightRoute == null)
            throw new IllegalArgumentException("FlightRoute can't be null");

        this.flightRoute = flightRoute;
        this.doorsOpen = true;
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
        if(doorsOpen)
            throw new GeneralFlightSimulatorException("Your doors are still open!");

        isMoving = true;
        currentHeight += additionalHeight;
        distanceTraveled += 1;

        if(additionalHeight > 100)
            throw new GeneralFlightSimulatorException("You can't ascend more than 100 meters in one kilometer!");
        if(additionalHeight < -100)
            throw new GeneralFlightSimulatorException("You can't descend more than 100 meters in one kilometer!");

        if(currentHeight >= flightRoute.getMaximumHeight())
            throw new PlaneTooHighException("You're flying too high! Maximum height (" + flightRoute.getMaximumHeight() +
                                                        "m) your height (" + currentHeight + "m)");
        if(currentHeight < 0)
            throw new PlaneTooLowException("You just crashed your plane!");

        // Distance traveled is checked against 2km, because the minimum flight-height
        // only needs to be checked if the plane is not within  the airport (2km radius in all directions)
        // for that matter we also subtract 2km from the length of the flightroute because at that point
        // the plane is inside the airport again.
        if(distanceTraveled >= 2 && distanceTraveled < flightRoute.getLength() - 2 && currentHeight < flightRoute.getMinimumHeight())
            throw new PlaneTooLowException("You're flying too low for your route! Minimum height: (" +
                    flightRoute.getMinimumHeight() + "m) your height (" +
                    currentHeight + "m)");
        if(distanceTraveled > flightRoute.getLength())
            throw new GeneralFlightSimulatorException("You flew too far!");


    }

    @Override
    public String toString() {
        return "Height: " + currentHeight + "m"
                + " - Minimum Height: " + flightRoute.getMinimumHeight() + "m"
                + " - Maximum Height: " + flightRoute.getMaximumHeight() + "m\n"
                + "Distance Traveled: "
                + distanceTraveled + "km" + " - Distance to fly: "
                + (flightRoute.getLength() - distanceTraveled) + "km" +"\n"
                + "Doors: " + (doorsOpen ? "Open" : "Closed")
                + (isMoving ? " - Plane is moving" : " - Plane standing still");
    }
}
