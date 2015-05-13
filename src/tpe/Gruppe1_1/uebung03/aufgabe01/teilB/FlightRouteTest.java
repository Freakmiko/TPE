package tpe.Gruppe1_1.uebung03.aufgabe01.teilB;

import org.junit.Test;

import static org.junit.Assert.*;

public class FlightRouteTest {

    @Test(expected = SimulatorConfigurationException.class)
    public void testTooShortFlightLength() throws Exception {
        FlightRoute fR = new FlightRoute("Mannheim", 0, 120);
    }

    @Test(expected = SimulatorConfigurationException.class)
    public void testNegativeFlightLength() throws Exception {
        FlightRoute fR = new FlightRoute("Mannheim", -1, 120);
    }

    @Test
    public void testNormalFlightLength() throws Exception {
        FlightRoute fR = new FlightRoute("Mannheim", 4, 120);
    }

    @Test(expected = SimulatorConfigurationException.class)
    public void testToHighMinimumHeight() throws Exception {
        FlightRoute fR = new FlightRoute("Mannheim", 3, 201);
    }

    @Test(expected = SimulatorConfigurationException.class)
    public void testToLowNegativeHeight() throws Exception {
        FlightRoute fR = new FlightRoute("Mannheim", 3, -1);
    }

    @Test(expected = SimulatorConfigurationException.class)
    public void testToLowMinimumHeight() throws Exception {
        FlightRoute fR = new FlightRoute("Mannheim", 3, 0);
    }

    @Test
    public void testMaximumMinimumHeight() throws Exception {
        FlightRoute fR = new FlightRoute("Mannheim", 3, 200);
    }

}