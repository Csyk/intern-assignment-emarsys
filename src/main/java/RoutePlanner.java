import java.util.ArrayList;
import java.util.List;

/**
 * Created by csyk on 2017.03.20..
 */
public class RoutePlanner {

    private List<Character> finalRoute = new ArrayList<Character>();

    public List<Character> planner(char[][] destinations) {
        for (char[] destinationPair : destinations) {
            if (destinationPair.length == 1 & !finalRoute.contains(destinationPair[0])) {
                finalRoute.add(destinationPair[0]);
            } else if (destinationPair.length == 2) {
                if(!finalRoute.contains(destinationPair[1]) & !finalRoute.contains(destinationPair[0])) {
                    finalRoute.add(destinationPair[1]);
                    finalRoute.add(destinationPair[0]);
                } else if(!finalRoute.contains(destinationPair[0])) {
                    finalRoute.add(destinationPair[0]);
                } else if(!finalRoute.contains(destinationPair[1])) {
                    for (int index = 0; index < finalRoute.size(); index++) {
                        if (finalRoute.get(index) == (destinationPair[0])) {
                            finalRoute.add(index, destinationPair[1]);
                            break;
                        }
                    }
                }

            }
        }
        return finalRoute;
    }
}
