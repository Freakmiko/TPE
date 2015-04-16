package tpe.GruppeXY.utils;

import tpe.GruppeXY.uebung01.Node;

public interface Queue {

    void enter(Node value);

    Node leave();

    Node front();

    boolean isEmpty();

}
