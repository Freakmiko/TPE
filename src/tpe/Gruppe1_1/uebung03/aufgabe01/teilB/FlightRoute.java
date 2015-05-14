package tpe.Gruppe1_1.uebung03.aufgabe01.teilB;

public class FlightRoute {

    /**
     * Gets the name of the FlightRoute
     *
     * @return returns the Name of the FlightRoute
     */
    public String getName() {
        return name;
    }

    private String name;

    /**
     * Gets the length of the FlightRoute
     *
     * @return returns the length of the FlightRoute
     *          in kilometers
     */
    public int getLength() {
        return length;
    }

    private int length;


    /**
     * Gets the minimum height for the FlightRoute
     *
     * @return returns the minimum height in meters
     */
    public int getMinimumHeight() {
        return minimumHeight;
    }

    private int minimumHeight;

    /**
     * Gets the maximum height of the FlightRoute
     *
     * @return returns the maximum height of the FlightRoute in meters
     */
    public int getMaximumHeight() {
        return maximumHeight;
    }

    private int maximumHeight;


    /**
     * Creates a new FlightRoute with a given length and miminum height for the plane to fly.
     *
     * @param length the length of the FlightRoute in kilometers.
     * @param minimumHeight the minimum height of the FlightRoute in meters.
     * @throws SimulatorConfigurationException
     *          If the length is smaller than 0 kilometers or the minimumHeight is
     *          higher than 200 meters or lower than or equal to 0 meters.
     */
    FlightRoute(String name, int length, int minimumHeight, int maximumHeight) throws SimulatorConfigurationException {
        if (length <= 1)
            throw new SimulatorConfigurationException("The length of the FlightRoute" +
                    " can't be smaller than 2 kilometers (" + length + ")");
        if (minimumHeight > 200 || minimumHeight <= 0)
            throw new SimulatorConfigurationException("The minimum height can't be higher" +
                    " than 200 meters or lower than 0 meters (" + minimumHeight + "m)");
        if (name == null || name.equals(""))
            throw new SimulatorConfigurationException("The name can't be null or empty!");
        if (maximumHeight <= minimumHeight)
            throw new SimulatorConfigurationException("You can't set the maximum height lower than (or equal to) your minimum height!");


        this.length = length;
        this.minimumHeight = minimumHeight;
        this.maximumHeight = maximumHeight;
    }

}