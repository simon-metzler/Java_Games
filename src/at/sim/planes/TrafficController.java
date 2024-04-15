package at.sim.planes;

import java.util.ArrayList;
import java.util.List;

public class TrafficController {

    private List<Plane> planes;

    public TrafficController() {
        this.planes = new ArrayList<>();
    }

    public void addPlane(Plane plane) {
        this.planes.add(plane);
    }

    public void printAllPlanes() {
        for (Plane plane : planes) {
            System.out.println(plane.getName());
        }
    }

    public void informPeopleOnAllPlanes(String message) {
        for (Plane plane : planes) {
            plane.informPassengers(message);
        }
    }


}
