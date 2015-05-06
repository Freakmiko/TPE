package tpe.Gruppe1_1.uebung02.aufgabe03;

import org.junit.Before;
import org.junit.Test;
import tpe.Gruppe1_1.uebung01.BTree;
import tpe.Gruppe1_1.uebung02.aufgabe01.BTreeImplementation;

import static org.junit.Assert.assertEquals;

public class CarTest {

    BTree tree = new BTreeImplementation(1);

    @Before
    public void setup() {
        Car a = new GasolineCar("BMW", 2012, 25000, 2);
        Car b = new GasolineCar("Audi", 2011, 22000, 3);
        Car c = new ElectricCar("Tesla", 2015, 50000, true);
        Car d = new HybridCar("VW", 2014, 30000, false, 1);

    }


    @Test
    public void compareTwoDifferentGasolineCar() {
        Car a = new GasolineCar("BMW", 2012, 25000, 2);
        Car b = new GasolineCar("Audi", 2011, 22000, 3);

        assertEquals(true, (a.compareTo(b)) > 0);
    }

    @Test
    public void compareTwoSameGasolineCar() {
        Car a = new GasolineCar("Audi", 2011, 22000, 3);
        Car b = new GasolineCar("Audi", 2011, 22000, 3);

        assertEquals(true, (a.compareTo(b)) < 0);
    }

    @Test
    public void compareGasolineCarWithElectricCar() {
        Car a = new GasolineCar("Audi", 2011, 22000, 3);
        Car b = new ElectricCar("Tesla", 2015, 50000, true);

        assertEquals(true, (a.compareTo(b)) < 0);
    }

    @Test
    public void compareGasolineCarWithHybridCar() {
        Car a = new GasolineCar("Audi", 2011, 22000, 3);
        Car b = new HybridCar("VW", 2014, 30000, false, 1);

        assertEquals(true, (a.compareTo(b)) < 0);
    }

    @Test
    public void compareTwoDifferentElectricCar() {
        Car a = new ElectricCar("Tesla", 2003, 24000, false);
        Car b = new ElectricCar("Tesla", 2015, 50000, true);

        assertEquals(true, (a.compareTo(b)) < 0);
    }

    @Test
    public void compareTwoSameElectricCar() {
        Car a = new ElectricCar("Tesla", 2003, 24000, false);
        Car b = new ElectricCar("Tesla", 2003, 24000, false);

        assertEquals(true, (a.compareTo(b)) < 0);
    }

    @Test
    public void compareElectricCarWithHybridCar() {
        Car a = new ElectricCar("Tesla", 2015, 50000, true);
        Car b = new HybridCar("VW", 2014, 30000, false, 1);

        assertEquals(true, (a.compareTo(b)) < 0);
    }

    @Test
    public void compareTwoDifferentHybridCar() {
        Car a = new HybridCar("VW", 2014, 30000, false, 1);
        Car b = new HybridCar("Opel", 2015, 45000, true, 1);

        assertEquals(true, (a.compareTo(b)) > 0);
    }

    @Test
    public void compareTwoSameHybridCar() {
        Car a = new HybridCar("VW", 2014, 30000, false, 1);
        Car b = new HybridCar("VW", 2014, 30000, false, 1);

        assertEquals(true, (a.compareTo(b)) < 0);
    }

    @Test
    public void insertAllTreeTypCarsInATree() throws Exception {
        BTree tree = new BTreeImplementation(1);

        Car a = new GasolineCar("Audi", 2011, 22000, 3);
        Car b = new ElectricCar("Tesla", 2015, 50000, true);
        Car c = new HybridCar("VW", 2014, 30000, false, 1);

        tree.insert(a);
        tree.insert(b);
        tree.insert(c);

        assertEquals(true, tree.contains(a));
        assertEquals(true, tree.contains(b));
        assertEquals(true, tree.contains(c));

    }

    @Test
    public void insertTwoGasolineCarsWithTheSameAttributs() throws Exception {
        BTree tree = new BTreeImplementation(1);

        Car a = new GasolineCar("Audi", 2011, 22000, 3);
        Car b = new GasolineCar("Audi", 2011, 22000, 3);

        tree.insert(a);
        tree.insert(b);

        assertEquals(true, tree.contains(a));
        assertEquals(true, tree.contains(b));

    }

    @Test
    public void insertTwoElectricCarWithTheSameAttributs() throws Exception {
        BTree tree = new BTreeImplementation(1);

        Car a = new ElectricCar("Tesla", 2015, 50000, true);
        Car b = new ElectricCar("Tesla", 2015, 50000, true);

        tree.insert(a);
        tree.insert(b);

        assertEquals(true, tree.contains(a));
        assertEquals(true, tree.contains(b));

    }

    @Test
    public void insertHybridCarWithTheSameAttributs() throws Exception {
        BTree tree = new BTreeImplementation(1);

        Car a = new HybridCar("VW", 2014, 30000, false, 1);
        Car b = new HybridCar("VW", 2014, 30000, false, 1);

        tree.insert(a);
        tree.insert(b);

        assertEquals(true, tree.contains(a));
        assertEquals(true, tree.contains(b));

    }

    @Test
    public void GetBiggestCar () throws Exception {
        BTree tree = new BTreeImplementation(1);

        Car a = new GasolineCar("BMW", 2012, 25000, 2);
        Car b = new GasolineCar("Audi", 2011, 22000, 3);
        Car c = new ElectricCar("Tesla", 2015, 50000, true);
        Car d = new HybridCar("VW", 2014, 30000, false, 1);

        tree.insert(a);
        tree.insert(b);
        tree.insert(c);
        tree.insert(d);

        assertEquals(d, tree.getMax());
    }

    @Test
    public void GetSmallestCar () throws Exception {
        BTree tree = new BTreeImplementation(1);

        Car a = new GasolineCar("BMW", 2012, 25000, 2);
        Car b = new GasolineCar("Audi", 2011, 22000, 3);
        Car c = new ElectricCar("Tesla", 2015, 50000, true);
        Car d = new HybridCar("VW", 2014, 30000, false, 1);

        tree.insert(a);
        tree.insert(b);
        tree.insert(c);
        tree.insert(d);

        assertEquals(b, tree.getMin());
    }

    @Test
    public void getHightWithFourCars() throws Exception {
        BTree tree = new BTreeImplementation(1);

        Car a = new GasolineCar("BMW", 2012, 25000, 2);
        Car b = new GasolineCar("Audi", 2011, 22000, 3);
        Car c = new ElectricCar("Tesla", 2015, 50000, true);
        Car d = new HybridCar("VW", 2014, 30000, false, 1);

        tree.insert(a);
        tree.insert(b);
        tree.insert(c);
        tree.insert(d);

        assertEquals(2, tree.height());
    }

    @Test
    public void treeSize() throws Exception {
        BTree tree = new BTreeImplementation(1);

        Car a = new GasolineCar("BMW", 2012, 25000, 2);
        Car b = new GasolineCar("Audi", 2011, 22000, 3);
        Car c = new ElectricCar("Tesla", 2015, 50000, true);
        Car d = new HybridCar("VW", 2014, 30000, false, 1);

        tree.insert(a);
        tree.insert(b);
        tree.insert(c);
        tree.insert(d);

        assertEquals(4, tree.size());
    }

    @Test
    public void tryInsertTwoTImeTheSameCar() throws Exception {
        BTree tree = new BTreeImplementation(1);

        Car a = new GasolineCar("BMW", 2012, 25000, 2);

        tree.insert(a);
        tree.insert(a);

        assertEquals(1, tree.size());

    }

}