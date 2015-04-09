package com.tpe.gruppenummer.uebung01;

import static gdi.MakeItSimple.*;

public class BTreeMenu {

    // Array mit 9 BTrees
    static BTree bTreeArray[] = new BTree[9];

    // Standard workingTree
    static int workingTree = 0;

    @SuppressWarnings("InfiniteLoopStatement")
    public static void main(String[] args) {

        println("Geben Sie die Ordnung des Baumes an:");

        int ordnung = readInt();
        readLine();

        for (int i = 0; i < bTreeArray.length; i++)
            bTreeArray[i] = new BTreeImplementation(ordnung);

        while (true) {
            makeMenu();
        }
    }

    public static void makeMenu() {

        Integer tempValue;
        String filename;
        int workingTreeNumber;

        println("------------------- Men� ------------------");
        println("01) insert(Integer object)");
        println("02) insert(String filename)");
        println("03) contains(Integer object)");
        println("04) size()");
        println("05) height()");
        println("06) getMax()");
        println("07) getMin()");
        println("08) isEmpty()");
        println("09) addAll(BTree otherTree)");
        println("10) cloneDeep(BTree otherTree)");
        println("11) printInorder()");
        println("12) printPostorder()");
        println("13) printPreorder()");
        println("14) printLevelorder()");
        println("15) Alle Printmethoden");
        println("16) change workingTree");
        println("17) Exit");


        int selection = readInt();

        switch (selection) {

            // insert(Integer object)
            case 1:
                println("Geben Sie den einzuf�genden Wert ein:");
                tempValue = readInt();
                if (bTreeArray[workingTree].insert(tempValue)) {
                    println("Der Wert konnte in den aktuellen Baum eingef�gt werden.");
                } else {
                    println("Der Wert konnte nicht in den aktuellen baum eingef�gt werden.");
                }

                break;

            // insert(String filename)
            case 2:
                println("Geben Sie die Dateinamen mit den einzuf�genden Werten ein:");
                filename = readLine();
                if (bTreeArray[workingTree].insert(filename)) {
                    println("Alle werte aus der Datei konnten in den aktuellen Baum eingef�gt werden.");
                } else {
                    println("Mindestens einer der Werte aus der Datei konnte nicht in den aktuellen Baum eingef�gt werde.");
                }
                break;

            // contains(Integer object)
            case 3:
                println("Geben Sie den gesuchten Wert ein:");
                tempValue = readInt();
                if (bTreeArray[workingTree].contains(tempValue)) {
                    println("Der gesuchte Wert konnte im aktuellen Baum gefunden werden.");
                } else {
                    println("Der gesuchte Wert konnte nicht im aktuellen Baum gefunden werde.");
                }
                break;

            // size()
            case 4:
                println("Im aktuellen Baum sind " + bTreeArray[workingTree].size() + " Werte.");
                break;

            // height
            case 5:
                println("Der aktuellen Baum hat die H�he " + bTreeArray[workingTree].height() + ".");
                break;

            // getMax()
            case 6:
                println("Im aktuellen Baum ist " + bTreeArray[workingTree].getMax() + " der gr��te Wert.");
                break;

            // getMin()
            case 7:
                println("Im aktuellen Baum ist " + bTreeArray[workingTree].getMin() + " der kleinste Wert.");
                break;

            // isEmpty()
            case 8:
                if (bTreeArray[workingTree].isEmpty()) {
                    println("Der aktuelle Baum ist leer.");
                } else {
                    println("Der aktuelle Baum ist nicht leer.");
                }
                break;

            // addAll(BTree otherTree)
            case 9:
                println("Geben Sie die Nummer des Baumes ein, den Sie in den aktuellen Baum einf�gen m�chten:");
                bTreeArray[workingTree].addAll(bTreeArray[readInt()]);
                println("Der gew�nschte Baum wurde dem aktuellen Baum hinzugef�gt.");
                break;

            // cloneDeep(BTree otherTree)
            case 10:
                println("Geben Sie die Nummer des Baumes ein, den Sie tief in den aktuleen Baum kopieren m�chten: ");
                bTreeArray[workingTree] = BTreeImplementation.cloneDeep(bTreeArray[readInt()]);
                println("Der gew�nschte Baum wurde tief in den aktuellen Baum kopiert.");
                break;

            // printInorder()
            case 11:
                println("Der aktuelle Baum sieht mit Inorder wie folgt aus:");
                println();
                bTreeArray[workingTree].printInorder();
                break;

            // printPostorder()
            case 12:
                println("Der aktuelle Baum sieht mit Postorder wie folgt aus:");
                println();
                bTreeArray[workingTree].printPostorder();
                break;

            // printPreorder()
            case 13:
                println("Der aktuelle Baum sieht mit Preorder wie folgt aus:");
                println();
                bTreeArray[workingTree].printPreorder();
                break;

            // printLevelorder
            case 14:
                println("Der aktuelle Baum sieht mit Levelorder wie folgt aus:");
                println();
                bTreeArray[workingTree].printLevelorder();
                break;

            case 15:
                println("Der aktuelle Baum sieht mit Inorder wie folgt aus:");
                println();
                bTreeArray[workingTree].printInorder();
                println("Der aktuelle Baum sieht mit Postorder wie folgt aus:");
                println();
                bTreeArray[workingTree].printPostorder();
                println("Der aktuelle Baum sieht mit Preorder wie folgt aus:");
                println();
                bTreeArray[workingTree].printPreorder();
                println("Der aktuelle Baum sieht mit Levelorder wie folgt aus:");
                println();
                bTreeArray[workingTree].printLevelorder();
                break;

            // change workingTree
            case 16:
                println("Geben Sie die Nummer des gew�nschten Baumes ein:");
                workingTreeNumber = readInt();
                if (workingTreeNumber < 0 && workingTreeNumber > 9) {
                    println("Die gew�nschte Nummer ist nicht m�glich.");
                } else {
                    workingTree = workingTreeNumber;
                }
                break;
            case 17:
                return;

            default:
                break;

        }
        readLine();

    }
}
