package com.tpe.gruppenummer.uebung01;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Michael on 02.04.2015.
 */
public class NodeTest {

    @Test
    public void testSize() throws Exception {
        Node node = new Node(1);
        node.getKeys()[0] = 3;
        assertEquals(1, node.size());
        node.getKeys()[1] = 9;
        assertEquals(2, node.size());
    }
}