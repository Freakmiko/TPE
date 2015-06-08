package tpe.Gruppe1_1.uebung04.aufgabe01;

import tpe.Gruppe1_1.uebung02.aufgabe03.ElectricCar;
import tpe.Gruppe1_1.uebung02.aufgabe03.GasolineCar;
import tpe.Gruppe1_1.uebung02.aufgabe03.HybridCar;

import java.io.FileNotFoundException;

import static gdi.MakeItSimple.*;

public class CarBTreeMenu {

    // Array with 9 BTrees
    static BTreeImplementation bTreeArray[] = new BTreeImplementation[9];

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
        int workingTreeNumber;

        println("------------------- Menu ------------------");
        println("01) insert car");
        println("02) size()");
        println("03) height()");
        println("04) getMax()");
        println("05) getMin()");
        println("06) isEmpty()");
        println("07) remove()");
        println("08) printInorder()");
        println("09) printPostorder()");
        println("10) printPreorder()");
        println("11) printLevelorder()");
        println("12) All Printmethods");
        println("13) change workingTree");
        println("14) Save Tree");
        println("15) Load Tree");
        println("16) Exit");


        int selection = readInt();
        readLine();

        switch (selection) {

            // insert(Integer object)
            case 1:
                println("Please enter the brand:");
                String brand = readLine();
                println("Please enter the construction year:");
                int constructionYear = readInt();
                println("Please enter the price:");
                int price = readInt();
                println("What type of car do you want to insert?");
                println("1) Gasoline car");
                println("2) Electric car");
                println("3) Hybrid car");
                switch(readInt()) {
                    case 1:
                        println("Please enter the emission tier:");
                        int emisionTier = readInt();
                        GasolineCar car = new GasolineCar(brand, constructionYear, price, emisionTier);
                        bTreeArray[workingTree].insert(car);
                        break;
                    case 2:
                        println("Is it a High voltage car? y\\N");
                        boolean highVoltage;
                        readLine();
                        switch(readChar()) {
                            case 'y' | 'Y':
                                highVoltage = true;
                                break;
                            case 'n' | 'N':
                                highVoltage = false;
                                break;
                            default:
                                highVoltage = false;
                        }
                        ElectricCar eCar = new ElectricCar(brand, constructionYear, price, highVoltage);
                        bTreeArray[workingTree].insert(eCar);
                        break;
                    case 3:
                        println("Please enter the emission tier:");
                        int hybridEmissionTier = readInt();
                        println("Is it a High voltage car? y\\N");
                        boolean hybridHighVoltage;
                        readLine();
                        switch(readChar()) {
                            case 'y' | 'Y':
                                hybridHighVoltage = true;
                                break;
                            case 'n' | 'N':
                                hybridHighVoltage = false;
                                break;
                            default:
                                hybridHighVoltage = false;
                        }
                        HybridCar hCar = new HybridCar(brand, constructionYear, price, hybridHighVoltage, hybridEmissionTier);
                        bTreeArray[workingTree].insert(hCar);
                        break;
                    default:
                        println("Invalid Input");
                }
                break;
            // size()
            case 2:
                println("The size of the tree is " + bTreeArray[workingTree].size() + ".");
                break;

            // height
            case 3:
                println("The height of the tree is " + bTreeArray[workingTree].height() + ".");
                break;

            // getMax()
            case 4:
                println("The maximum of the tree is " + bTreeArray[workingTree].getMax() + ".");
                break;

            // getMin()
            case 5:
                println("The minimum of the tree is " + bTreeArray[workingTree].getMin() + ".");
                break;

            // isEmpty()
            case 6:
                if (bTreeArray[workingTree].isEmpty())
                    println("The tree is empty.");
                else
                    println("The tree is not empty.");
                break;

            // remove()
            case 7:
                bTreeArray[workingTree].printInorder();
                println("Please enter the id of the car to remove");
                int id = readInt();
                GasolineCar gCar = new GasolineCar(id);
                bTreeArray[workingTree].remove(gCar);
                bTreeArray[workingTree].printInorder();

            // printInorder()
            case 8:
                println();
                bTreeArray[workingTree].printInorder();
                break;

            // printPostorder()
            case 9:
                println();
                bTreeArray[workingTree].printPostorder();
                break;

            // printPreorder()
            case 10:
                println();
                bTreeArray[workingTree].printPreorder();
                break;

            // printLevelorder
            case 11:
                println();
                bTreeArray[workingTree].printLevelorder();
                break;

            case 12:
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
            case 13:
                println("Please enter the number of the tree you want to switch to:");
                workingTreeNumber = readInt();
                if (workingTreeNumber < 0 || workingTreeNumber > 9) {
                    println("This is not a valid number.");
                } else {
                    workingTree = workingTreeNumber;
                }
                break;
            case 14:
                println("The tree will now be saved");
                bTreeArray[workingTree].SaveTree("tree" + workingTree + ".tree");
                break;
            case 15:
                println("Please enter the path to the file: ");
                String path = readLine();
                try {
                    bTreeArray[workingTree] = BTreeImplementation.LoadTree(path);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

                break;
            case 16:
                return false;

            default:
                break;

        }
        readLine();
        return true;
    }
}
