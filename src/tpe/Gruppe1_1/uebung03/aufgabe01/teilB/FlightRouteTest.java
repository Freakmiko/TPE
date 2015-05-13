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
        try {
            FlightRoute fR = new FlightRoute("Mannheim", 4, 120);
        } catch(Exception e) {
            assertTrue(false);
        }
    }

    @Test(expected = SimulatorConfigurationException.class)
    public void testToHighMinimumHeight() throws Exception {
        FlightRoute fR = new FlightRoute("Mannheim", 3, 201);
    }

    @Test(expected = SimulatorConfigurationException.class)
    public void testToLowMinimumHeight() throws Exception {
        FlightRoute fR = new FlightRoute("Mannheim", 3, 49);
    }

    @Test
    public void testMaximumMinimumHeight() throws Exception {
        try {
            FlightRoute fR = new FlightRoute("Mannheim", 3, 200);
        } catch (Exception e) {
            assertTrue(false);
        }
    }

}