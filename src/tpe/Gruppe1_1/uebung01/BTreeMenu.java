package tpe.Gruppe1_1.uebung01;

import static gdi.MakeItSimple.*;

public class BTreeMenu {

    // Array with 9 BTrees
    static BTree bTreeArray[] = new BTree[9];

    static int workingTree = 0;

    @SuppressWarnings({"StatementWithEmptyBody"})
    public static void main(String[] args) {

        println("Please enter the order of the trees:");

        int order = readInt();
        readLine();

        for (int i = 0; i < bTreeArray.length; i++)
            bTreeArray[i] = new BTreeImplementation(order);

        while(makeMenu()) {}
    }

    public static boolean makeMenu() {

        Integer tempValue;
        String filename;
        int workingTreeNumber;

        println("------------------- Menu ------------------");
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
        println("15) All Printmethods");
        println("16) change workingTree");
        println("17) Exit");


        int selection = readInt();
        readLine();

        switch (selection) {

            // insert(Integer object)
            case 1:
                println("Please enter the value to insert:");
                tempValue = readInt();
                if (bTreeArray[workingTree].insert(tempValue))
                    println("The value has been inserted into the tree.");
                else
                    println("The value could not be inserted (duplicate).");

                break;

            // insert(String filename)
            case 2:
                println("Please enter the path to the file:");
                filename = readLine();
                if (bTreeArray[workingTree].insert(filename))
                    println("Every element in the file has been inserted into the tree.");
                else
                    println("Only some elements have been inserted into the tree because there was a duplicate.");
                break;

            // contains(Integer object)
            case 3:
                println("Please enter the value that you want to look for:");
                tempValue = readInt();
                if (bTreeArray[workingTree].contains(tempValue))
                    println("The value is in the tree.");
                else
                    println("The value is not in the tree.");
                break;

            // size()
            case 4:
                println("The size of the tree is " + bTreeArray[workingTree].size() + ".");
                break;

            // height
            case 5:
                println("The height of the tree is " + bTreeArray[workingTree].height() + ".");
                break;

            // getMax()
            case 6:
                println("The maximum of the tree is " + bTreeArray[workingTree].getMax() + ".");
                break;

            // getMin()
            case 7:
                println("The minimum of the tree is " + bTreeArray[workingTree].getMin() + ".");
                break;

            // isEmpty()
            case 8:
                if (bTreeArray[workingTree].isEmpty())
                    println("The tree is empty.");
                else
                    println("The tree is not empty.");
                break;

            // addAll(BTree otherTree)
            case 9:
                println("Please enter the number of the tree from which you want all values to be inserted\ninto the current tree:");
                bTreeArray[workingTree].addAll(bTreeArray[readInt()]);
                println("All values have been inserted.");
                break;

            // cloneDeep(BTree otherTree)
            case 10:
                println("Please enter the number of the tree that you want to be cloned deep over the current tree: ");
                bTreeArray[workingTree] = BTreeImplementation.cloneDeep(bTreeArray[readInt()]);
                println("The tree has been cloned.");
                break;

            // printInorder()
            case 11:
                println();
                bTreeArray[workingTree].printInorder();
                break;

            // printPostorder()
            case 12:
                println();
                bTreeArray[workingTree].printPostorder();
                break;

            // printPreorder()
            case 13:
                println();
                bTreeArray[workingTree].printPreorder();
                break;

            // printLevelorder
            case 14:
                println();
                bTreeArray[workingTree].printLevelorder();
                break;

            case 15:
                println("Inorder:");
                println();
                bTreeArray[workingTree].printInorder();
                println("Postorder:");
                println();
                bTreeArray[workingTree].printPostorder();
                println("Preorder:");
                println();
                bTreeArray[workingTree].printPreorder();
                println("Levelorder:");
                println();
                bTreeArray[workingTree].printLevelorder();
                break;

            // change workingTree
            case 16:
                println("Please enter the number of the tree you want to switch to:");
                workingTreeNumber = readInt();
                if (workingTreeNumber < 0 || workingTreeNumber > 9) {
                    println("This is not a valid number.");
                } else {
                    workingTree = workingTreeNumber;
                }
                break;
            case 17:
                return false;

            default:
                break;

        }
        readLine();
        return true;
    }
}
