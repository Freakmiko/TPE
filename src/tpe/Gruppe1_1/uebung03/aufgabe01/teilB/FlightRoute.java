package tpe.Gruppe1_1.uebung03.aufgabe01.teilB;

public class FlightRoute {

    private String name;
    private int length;
    private int minimumHeight;


    /**
     * Creates a new FlightRoute with a given length and miminum height for the plane to fly.
     *
     * @param length the length of the FlightRoute in kilometers.
     * @param minimumHeight the minimum height of the FlightRoute in meters.
     * @throws SimulatorConfigurationException
     *          If the length is smaller than 0 kilometers or the minimumHeight is
     *          higher than 200 meters or lower than 0 meters.
     */
    FlightRoute(String name, int length, int minimumHeight) throws SimulatorConfigurationException {
        if (length <= 0)
            throw new SimulatorConfigurationException("The length of the FlightRoute" +
                    " can't be smaller than 1 (" + length + ")");
        if (minimumHeight > 200 || minimumHeight < 0)
            throw new SimulatorConfigurationException("The minimum height can't be higher" +
                    " than 200 meters or lower than 0 meters (" + minimumHeight + ")");
        if (name == null || name.equals(""))
            throw new SimulatorConfigurationException("The name can't be null or empty!");


        this.length = length;
        this.minimumHeight = minimumHeight;
    }

    /**
     * Gets the length of the FlightRoute
     *
     * @return returns the length of the FlightRoute
     *          in kilometers
     */
    public int getLength() {
        return length;
    }

    /**
     * Gets the minimum height for the FlightRoute
     *
     * @return returns the minimum height in meters
     */
    public int getMinimumHeight() {
        return minimumHeight;
    }
}