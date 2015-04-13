package tpe.gruppenummer.utils;

import tpe.gruppenummer.uebung01.Node;

public interface Queue {

    void enter(Node value);

    Node leave();

    Node front();

    boolean isEmpty();

}
