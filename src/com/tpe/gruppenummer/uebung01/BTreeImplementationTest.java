package com.tpe.gruppenummer.uebung01;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BTreeImplementationTest {
    private BTree bTree;
    private BTree fullTree;

    @Before
    public void setup() {
        bTree = new BTreeImplementation(1);
        fullTree = new BTreeImplementation(1);
        fullTree.insert(2);
        fullTree.insert(3);
        fullTree.insert(1);
        fullTree.insert(4);
        fullTree.insert(6);
        fullTree.insert(9);
        fullTree.insert(10);
        fullTree.insert(15);
        fullTree.insert(14);
    }


    @Test
    public void testThingy() throws Exception {
        BTree tesyt = new BTreeImplementation(2);
        tesyt.insert(323);
        tesyt.printInorder();
        tesyt.insert(1);
        tesyt.printInorder();
        tesyt.insert(4);
        tesyt.printInorder();
        tesyt.insert(84);
        tesyt.printInorder();
        tesyt.insert(895);
        tesyt.printInorder();
        tesyt.insert(69);
        tesyt.printInorder();
        tesyt.insert(70);
        tesyt.printInorder();
        tesyt.insert(71);
        tesyt.printInorder();
    }


    @Test
    public void testInsert() throws Exception {
        bTree.insert(2);
        bTree.printInorder();
        bTree.insert(3);
        bTree.printInorder();
        bTree.insert(1);
        bTree.printInorder();
        bTree.insert(4);
        bTree.printInorder();
        bTree.insert(6);
        bTree.printInorder();
        bTree.insert(9);
        bTree.printInorder();
        bTree.insert(10);
        bTree.printInorder();
        bTree.insert(6);
        bTree.printInorder();
        bTree.insert(15);
        bTree.printInorder();
        bTree.insert(14);
        bTree.printInorder();
    }

    @Test
    public void testInsertFile() throws Exception {

    }

    @Test
    public void testContains() throws Exception {
        assertEquals(true, fullTree.contains(2));
        assertEquals(true, fullTree.contains(3));
        assertEquals(true, fullTree.contains(1));
        assertEquals(true, fullTree.contains(4));
        assertEquals(true, fullTree.contains(6));
        assertEquals(true, fullTree.contains(9));
        assertEquals(true, fullTree.contains(10));
        assertEquals(true, fullTree.contains(15));
        assertEquals(true, fullTree.contains(14));
        assertEquals(false, fullTree.contains(95));
        assertEquals(false, fullTree.contains(-1));
    }

    @Test
    public void testSize() throws Exception {
        assertEquals(9, fullTree.size());
    }

    @Test
    public void testHeight() throws Exception {
        assertEquals(3, fullTree.height());
    }

    @Test
    public void testGetMax() throws Exception {
        assertEquals(15, fullTree.getMax().intValue());
    }

    @Test
    public void testGetMin() throws Exception {
        assertEquals(1, fullTree.getMin().intValue());
    }

    @Test
    public void testIsEmpty() throws Exception {

    }

    @Test
    public void testAddAll() throws Exception {
        BTree t1 = new BTreeImplementation(2);
        BTree t2 = new BTreeImplementation(2);

        t1.insert(5);
        t1.insert(4);
        t1.insert(75);
        t1.insert(54);
        t1.insert(1);
        t1.insert(19);

        t2.insert(3);
        t2.insert(69);
        t2.insert(36);
        t2.insert(133);
        t2.insert(6);
        t2.insert(7);

        t1.addAll(t2);

        assertEquals(true, t1.contains(5));
        assertEquals(true, t1.contains(4));
        assertEquals(true, t1.contains(75));
        assertEquals(true, t1.contains(54));
        assertEquals(true, t1.contains(1));
        assertEquals(true, t1.contains(19));
        assertEquals(true, t1.contains(3));
        assertEquals(true, t1.contains(69));
        assertEquals(true, t1.contains(36));
        assertEquals(true, t1.contains(133));
        assertEquals(true, t1.contains(6));
        assertEquals(true, t1.contains(7));
        assertEquals(false, t1.contains(53424));
        assertEquals(false, t1.contains(-3));

    }
}