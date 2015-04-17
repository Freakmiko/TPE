package tpe.Gruppe1_1.utils;

import tpe.Gruppe1_1.uebung01.Node;

public interface Queue {

    void enter(Node value);

    Node leave();

    Node front();

    boolean isEmpty();

}
