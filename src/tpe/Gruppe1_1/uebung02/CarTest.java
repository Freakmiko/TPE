package tpe.Gruppe1_1.uebung02;

import org.junit.Before;
import org.junit.Test;
import tpe.Gruppe1_1.uebung01.BTree;
import tpe.Gruppe1_1.uebung01.BTreeImplementation;

import static org.junit.Assert.*;

public class CarTest {

    BTree tree = new BTreeImplementation(1);

    @Before
    public void setup() {
        Car a = new GasolineCar("BMW", 2012, 25000, 2);
        tree.insert(a);
        Car b = new GasolineCar("Audi", 2011, 22000, 3);
        tree.insert(b);
        Car c = new ElectricCar("Tesla", 2015, 50000, true);
        tree.insert(c);
    }

    @Test
    public void testCarThingy() {
        tree.printInorder();
    }

}