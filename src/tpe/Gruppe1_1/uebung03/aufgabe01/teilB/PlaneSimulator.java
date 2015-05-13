package tpe.Gruppe1_1.uebung03.aufgabe01.teilB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PlaneSimulator {

    static Plane plane;

    public static void main(String[] args) {
        try {

            configureSimulation();
            menu();

        } catch (IOException e) {
            System.err.print(e.getMessage());
            e.printStackTrace(System.err);
        }


    }

    private static void configureSimulation() throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        printTitle();
        System.out.println("++++++++++++ CONFIGURATION ++++++++++++");
        System.out.println();


        System.out.println("Please enter the name for the route: ");
        String routeName = console.readLine();
        System.out.println("Please enter the length of the route in kilometers: ");
        int routeLength = Integer.parseInt(console.readLine());
        System.out.println("Please enter the minimum height for the route: ");
        int routeMinHeight = Integer.parseInt(console.readLine());

        try {
            FlightRoute route = new FlightRoute(routeName, routeLength, routeMinHeight);
            plane = new PlaneImpl(route);
        } catch (SimulatorConfigurationException e) {
            e.printInfo();
        }

    }

    private static void menu() throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            printTitle();
            System.out.println("+++++++++++++ SIMULATION ++++++++++++++");
            System.out.println(plane.toString());
            System.out.println();
            System.out.println("Please choose your next action!");

            System.out.println("1) Fly one kilometer");
            System.out.println("2) Open Doors");
            System.out.println("3) Close Doors");
            System.out.println("4) Stop plane");

            boolean waitingForChoice = true;
            int choice = 0;

            while(waitingForChoice) {
                try {
                    choice = Integer.parseInt(console.readLine());
                    waitingForChoice = false;
                } catch(NumberFormatException e) {
                    System.out.println("Please enter a number!");
                } catch (IOException e) {
                    System.err.println(e.getMessage());
                    e.printStackTrace();
                }
            }

            switch(choice) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                default:
                    break;
            }

        }
    }


    private static void printTitle() {
        System.out.println();
        System.out.println("++++++++ FLIGHT SIMULATOR 2000 ++++++++");
    }

}
