package tpe.Gruppe1_1.uebung03.aufgabe01.teilB;

public class FlightRoute {

    private int length;
    private int minimumHeight;


    /**
     * Creates a new FlightRoute with a given length and miminum height for the plane to fly.
     * @param length the length of the FlightRoute in kilometers.
     * @param minimumHeight the minimum height of the FlightRoute in meters.
     * @throws SimulatorConfigurationException
     *          If the length is smaller than 0 or the minimumHeight is higher than 200.
     */
    FlightRoute(int length, int minimumHeight) throws SimulatorConfigurationException {
        if (length <= 0)
            throw new SimulatorConfigurationException("The length of the FlightRoute" +
                    " can't be smaller than 1 (" + length + ")");
        if (minimumHeight >= 200)
            throw new SimulatorConfigurationException("The minimum height can't be higher" +
                    " than 200 meters (" + minimumHeight + ")");

        this.length = length;
        this.minimumHeight = minimumHeight;
    }

    /**
     * Gets the length of the FlightRoute
     * @return returns the length of the FlightRoute
     *          in kilometers
     */
    public int getLength() {
        return length;
    }

    /**
     * Gets the minimum height for the FlightRoute
     * @return returns the minimum height in meters
     */
    public int getMinimumHeight() {
        return minimumHeight;
    }
}