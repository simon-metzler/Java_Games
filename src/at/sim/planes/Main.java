package at.sim.planes;

public class Main {
    public static void main(String[] args) {

        Passenger pass1 = new Passenger("Susi", "Musterfrau");
        Passenger pass2 = new Passenger("Theo", "Schneider");

        Passenger pass3 = new Passenger("Max", "Mustermann");
        Passenger pass4 = new Passenger("Eric", "Kogler");

        Plane plane1 = new Plane("Boing143", new Position(3.0, 1.0));
        Plane plane2 = new Plane("Airbus352", new Position(9.0, 2.0));

        plane1.addPassenger(pass1);
        plane1.addPassenger(pass2);

        plane2.addPassenger(pass3);
        plane2.addPassenger(pass4);

        TrafficController trafficController = new TrafficController();

        trafficController.addPlane(plane1);
        trafficController.addPlane(plane2);

        System.out.println("Alle Flugzeuge: ");
        trafficController.printAllPlanes();
        System.out.println();

        System.out.println("Nachricht an alle: ");
        trafficController.informPeopleOnAllPlanes("Alle Flüge sind gestrichen");
        System.out.println();


        System.out.println("Nachricht an Flugzeug 1: ");
        plane1.informPassengers("Bitte warten Sie noch eine halbe Stunde.");
        System.out.println();

        System.out.println("Nachricht an Flugzeug 2: ");
        plane2.informPassengers("Bitte verlassen Sie das Flugzeug so schnell wie möglich.");
        System.out.println();

        System.out.println("Longitude von Flugzeug 1: ");
        System.out.println(plane1.getPosition().getLongitude());
        System.out.println();


    }
}
