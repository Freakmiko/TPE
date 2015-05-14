package tpe.Gruppe1_1.uebung03.aufgabe01.teilB;

import org.junit.Test;

import static org.junit.Assert.*;

public class FlightRouteTest {

    @Test(expected = SimulatorConfigurationException.class)
    public void testTooShortFlightLength() throws Exception {
        FlightRoute fR = new FlightRoute("Mannheim", 0, 120, 400);
    }

    @Test(expected = SimulatorConfigurationException.class)
    public void testNegativeFlightLength() throws Exception {
        FlightRoute fR = new FlightRoute("Mannheim", -1, 120, 400);
    }

    @Test
    public void testNormalFlightLength() throws Exception {
        FlightRoute fR = new FlightRoute("Mannheim", 2, 120, 400);
    }

    @Test(expected = SimulatorConfigurationException.class)
    public void testToHighMinimumHeight() throws Exception {
        FlightRoute fR = new FlightRoute("Mannheim", 6, 201, 400);
    }

    @Test(expected = SimulatorConfigurationException.class)
    public void testToLowNegativeHeight() throws Exception {
        FlightRoute fR = new FlightRoute("Mannheim", 6, -1, 400);
    }

    @Test(expected = SimulatorConfigurationException.class)
    public void testToLowMinimumHeight() throws Exception {
        FlightRoute fR = new FlightRoute("Mannheim", 6, 0, 400);
    }

    @Test
    public void testMaximumMinimumHeight() throws Exception {
        FlightRoute fR = new FlightRoute("Mannheim", 6, 200, 400);
    }

    @Test(expected = SimulatorConfigurationException.class)
    public void testEmtpyName() throws Exception {
        FlightRoute fR = new FlightRoute("", 6, 200, 400);
    }

    @Test(expected = SimulatorConfigurationException.class)
    public void testNullName() throws Exception {
        FlightRoute fR = new FlightRoute(null, 6, 200, 400);
    }

    @Test(expected = SimulatorConfigurationException.class)
    public void testMaximumHeightEqualToMinimumHeight() throws Exception {
        FlightRoute fR = new FlightRoute("Mannheim", 6, 200, 200);
    }

    @Test
    public void testMaximumHeightOneMeterOverMinimumHeight() throws Exception {
        FlightRoute fR = new FlightRoute("Mannheim", 6, 200, 201);
    }

}