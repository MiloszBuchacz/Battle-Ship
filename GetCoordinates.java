/* Why can i not use addCoordinates if invoked in Main? */

import java.util.ArrayList;
import java.util.List;

public class GetCoordinates {
    private List<Coordinates> coordinates = new ArrayList<>();

    public void addCordinates(Coordinates place)/*<= can't be resolved'*/ {
        this.coordinates.add(place);
    }

    public void showAllCoordinates() {
        for (Coordinates place: coordinates) {
            System.out.println("x: " + place.getX() + " y: " + place.getY());
        }
    }
}