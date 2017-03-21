import exception.NoLocationException;
import model.Destination;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by csyk on 2017.03.20..
 */
public class RoutePlanner {

    private List<Character> finalRoute = new ArrayList<Character>();

    public List<Character> planner(ArrayList<Destination> destinations) throws NoLocationException {
        if (destinations == null) {
            throw new NoLocationException();
        }

        for (Destination destinationPair : destinations) {

            //without dependency
            if (destinationPair.getDependency() == 0 & !finalRoute.contains(destinationPair.getPoint())) {
                finalRoute.add(destinationPair.getPoint());

                //with dependency
            } else if (destinationPair.getDependency() != 0) {
                //not at all in finalRoute
                if(!finalRoute.contains(destinationPair.getDependency()) &
                        !finalRoute.contains(destinationPair.getPoint())) {
                    finalRoute.add(destinationPair.getDependency());
                    finalRoute.add(destinationPair.getPoint());

                    //just destination's point is not in finalRoute
                } else if(!finalRoute.contains(destinationPair.getPoint())) {
                    finalRoute.add(destinationPair.getPoint());

                    //just destination's dependency is not in finalRoute
                } else if(!finalRoute.contains(destinationPair.getDependency())) {
                    for (int index = 0; index < finalRoute.size(); index++) {
                        if (finalRoute.get(index) == (destinationPair.getPoint())) {
                            finalRoute.add(index, destinationPair.getDependency());
                            break;
                        }
                    }
                }
            }
        }

        return finalRoute;
    }
}