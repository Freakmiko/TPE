package tpe.Gruppe1_1.uebung03.aufgabe01.teilB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PlaneSimulator {

    static PlaneImpl plane;
    static FlightRoute route;
    static BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

    static int generalFlightSimulatorExceptionCount = 0;
    static int planeTooHighExceptionCount = 0;
    static int planeTooLowExceptionCount = 0;
    static int successfulSimulations = 0;

    public static void main(String[] args) {
        try {

            configureSimulation();

            boolean continueSimulation = true;

            do {
                plane = new PlaneImpl(route);
                menu();

                boolean waitForChoice = true;
                while(waitForChoice) {
                    System.out.println("Do you want to continue? 1)Yes 2)No :");
                    int cont = readNumber();
                    switch (cont) {
                        case 1:
                            continueSimulation = true;
                            waitForChoice = false;
                            break;
                        case 2:
                            continueSimulation = false;
                            waitForChoice = false;
                            break;
                        default:
                            break;
                    }
                }

            } while (continueSimulation);

        } catch (IOException e) {
            System.err.print(e.getMessage());
            e.printStackTrace(System.err);
        }

        System.out.println("Results: ");
        System.out.println("GeneralFlightSimulatorExceptions: " + generalFlightSimulatorExceptionCount);
        System.out.println("PlaneTooHighExceptions: " + planeTooHighExceptionCount);
        System.out.println("PlaneTooLowExceptions: " + planeTooLowExceptionCount);
        System.out.println("Successful simulations: " + successfulSimulations);


    }

    private static void configureSimulation() throws IOException {
        //BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        printTitle();
        System.out.println("++++++++++++ CONFIGURATION ++++++++++++");
        System.out.println();


        System.out.print("Please enter the name for the route: ");
        String routeName = console.readLine();
        System.out.print("Please enter the length of the route in kilometers: ");
        int routeLength = readNumber();
        System.out.print("Please enter the minimum height (in meters) for the route: ");
        int routeMinHeight = readNumber();
        System.out.print("Please enter the maximum height (in meters) for the route: ");
        int routeMaxHeight = readNumber();

        try {
            route = new FlightRoute(routeName, routeLength, routeMinHeight, routeMaxHeight);
        } catch (SimulatorConfigurationException e) {
            e.printInfo();
        }

    }

    private static void menu() throws IOException {
        //BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

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
            System.out.print("Your choice: ");
            int choice = readNumber();

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Please enter the height difference for the kilometer (in meters): ");
                        int difference = readNumber();
                        plane.flyNextKilometer(difference);
                        break;
                    case 2:
                        System.out.println("Opening Doors!");
                        plane.openDoors();
                        break;
                    case 3:
                        System.out.println("Closing Doors!");
                        plane.closeDoors();
                        break;
                    case 4:
                        System.out.println("Stopping the Plane!");
                        plane.stop();
                        break;
                    default:
                        break;
                }
            } catch(PlaneTooHighException e) {
                System.out.println();
                System.out.println("+++++++++++++++ FAILED ++++++++++++++++");
                System.out.println("PlaneTooHighException");
                System.err.println(e.getMessage());
                planeTooHighExceptionCount++;
                break;
            } catch(PlaneTooLowException e) {
                System.out.println();
                System.out.println("+++++++++++++++ FAILED ++++++++++++++++");
                System.out.println("PlaneTooLowException");
                System.err.println(e.getMessage());
                planeTooLowExceptionCount++;
                break;
            } catch(GeneralFlightSimulatorException e) {
                System.out.println();
                System.out.println("+++++++++++++++ FAILED ++++++++++++++++");
                System.out.println("GeneralFlightSimulatorException");
                System.err.println(e.getMessage());
                generalFlightSimulatorExceptionCount++;
                break;
            }

            if(!plane.isMoving && plane.distanceTraveled == plane.flightRoute.getLength() && plane.doorsOpen) {
                System.out.println();
                System.out.println("+++++++++++ CONGRATULATIONS +++++++++++");
                System.out.println("You managed to fly the route without failing");
                successfulSimulations++;
                break;
            }
        }
    }

    private static int readNumber() {
        boolean waitingForInput = true;
        int number = 0;

        while(waitingForInput) {
            try {
                number = Integer.parseInt(console.readLine());
                waitingForInput = false;
            } catch(NumberFormatException e) {
                System.out.println("Please enter a number!");
            } catch (IOException e) {
                System.err.println(e.getMessage());
                e.printStackTrace();
            }
        }

        return number;
    }

    private static void printTitle() {
        System.out.println();
        System.out.println("++++++++ FLIGHT SIMULATOR 2000 ++++++++");
    }

}
