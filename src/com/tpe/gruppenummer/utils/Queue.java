package com.tpe.gruppenummer.utils;

import com.tpe.gruppenummer.uebung01.Node;

/**
 * Created by Michael on 10.12.2014.
 */
public interface Queue {

    public void enter(Node value);

    public Node leave();

    public Node front();

    public boolean isEmpty();

}
