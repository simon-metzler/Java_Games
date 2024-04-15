package at.sim.planes;

import java.util.ArrayList;
import java.util.List;

public class Plane {

    private String name;
    private List<Passenger> passengers;
    private Position position;


    public Plane(String name, Position position) {
        this.name = name;
        this.passengers = new ArrayList<>();
        this.position = position;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void addPassenger(Passenger passenger) {
        this.passengers.add(passenger);
    }

    public void informPassengers(String message) {
        for (Passenger passenger : this.passengers) {
            passenger.inform(message);
        }
    }

}
