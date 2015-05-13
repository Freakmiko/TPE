package tpe.Gruppe1_1.uebung03.aufgabe01.teilB;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlaneImplTest {

    Plane plane;

    @Before
    public void setup() throws Exception {
        plane = new PlaneImpl(new FlightRoute("Mannheim", 6, 175));
    }

    @Test(expected = GeneralFlightSimulatorException.class)
    public void testFlyNextKilometerWithOpenDoors() throws Exception {
        plane.flyNextKilometer(30);
    }


    @Test(expected = GeneralFlightSimulatorException.class)
    public void testFlyNextKilometerAscendTooMuch() throws Exception {
        plane.closeDoors();
        plane.flyNextKilometer(101);
    }

    @Test
    public void testFlyNextKilometerMaximumAscend() throws Exception {
        plane.closeDoors();
        plane.flyNextKilometer(100);
    }

    @Test(expected = GeneralFlightSimulatorException.class)
    public void testFlyNextKilometerDescendTooMuch() throws Exception {
        plane.closeDoors();
        plane.flyNextKilometer(100);
        plane.flyNextKilometer(100);
        plane.flyNextKilometer(0);
        plane.flyNextKilometer(0);
        plane.flyNextKilometer(-101);
    }

    @Test
    public void testFlyNextKilometerMaximumDescend() throws Exception {
        plane.closeDoors();
        plane.flyNextKilometer(100);
        plane.flyNextKilometer(100);
        plane.flyNextKilometer(0);
        plane.flyNextKilometer(0);
        plane.flyNextKilometer(-100);
    }

    @Test(expected = PlaneTooLowException.class)
    public void testFlyNextKilometerToLowForMinimumRoutHeight() throws Exception {
        plane.closeDoors();
        plane.flyNextKilometer(100);
        plane.flyNextKilometer(74);
    }

    @Test
    public void testFlyNextKilometerMinimumHeight() throws Exception {
        plane.closeDoors();
        plane.flyNextKilometer(100);
        plane.flyNextKilometer(75);
    }

    @Test(expected = GeneralFlightSimulatorException.class)
    public void testFlyNextKilometerStopMidair() throws Exception {
        plane.closeDoors();
        plane.flyNextKilometer(50);
        plane.stop();
    }

    @Test(expected = PlaneTooHighException.class)
    public void testFlyNextKilometerFlyTooHigh() throws Exception {
        plane.closeDoors();
        plane.flyNextKilometer(100);
        plane.flyNextKilometer(100);
        plane.flyNextKilometer(100);
        plane.flyNextKilometer(100);
    }

    @Test(expected = GeneralFlightSimulatorException.class)
    public void testFlyNextKilometerFlyTooFar() throws Exception {
        plane.closeDoors();
        plane.flyNextKilometer(100);
        plane.flyNextKilometer(100);
        plane.flyNextKilometer(0);
        plane.flyNextKilometer(0);
        plane.flyNextKilometer(0);
        plane.flyNextKilometer(0);
        plane.flyNextKilometer(0);
    }

    @Test(expected = PlaneTooLowException.class)
    public void testFlyNextKilometerTryToCrashPlane() throws Exception {
        plane.closeDoors();
        plane.flyNextKilometer(100);
        plane.flyNextKilometer(100);
        plane.flyNextKilometer(0);
        plane.flyNextKilometer(-100);
        plane.flyNextKilometer(-100);
        plane.flyNextKilometer(-100);
    }

    @Test
    public void testFlyNextKilometerFlyPerfect() throws Exception {
        plane.closeDoors();
        plane.flyNextKilometer(100);
        plane.flyNextKilometer(100);
        plane.flyNextKilometer(0);
        plane.flyNextKilometer(0);
        plane.flyNextKilometer(-100);
        plane.flyNextKilometer(-100);
        plane.stop();
        plane.openDoors();
    }

    @Test(expected = GeneralFlightSimulatorException.class)
    public void testFlyNextKilometerOpenDoorsMidair() throws Exception {
        plane.closeDoors();
        plane.flyNextKilometer(100);
        plane.flyNextKilometer(100);
        plane.flyNextKilometer(0);
        plane.flyNextKilometer(0);
        plane.openDoors();
    }

    @Test(expected = GeneralFlightSimulatorException.class)
    public void testFlyNextKilometerOpenDoorsWhileMoving() throws Exception {
        plane.closeDoors();
        plane.flyNextKilometer(100);
        plane.flyNextKilometer(100);
        plane.flyNextKilometer(0);
        plane.flyNextKilometer(0);
        plane.flyNextKilometer(-100);
        plane.flyNextKilometer(-100);
        plane.openDoors();
    }

}
