import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

/**
 * Created by csyk on 2017.03.20..
 */
public class RoutePlannerTest {

    private RoutePlanner routePlanner = new RoutePlanner();
    private Destination destinationX = new Destination('x');
    private Destination destinationY = new Destination('y');
    private Destination destinationZ = new Destination('z');
    private Destination destinationXY = new Destination('x', 'y');
    private Destination destinationYZ = new Destination('y', 'z');
    private Destination destinationTX = new Destination('t', 'x');
    private Destination destinationVU = new Destination('v', 'u');
    private Destination destinationUW = new Destination('u', 'w');

    @Test
    public void plannerWithOneXDestination() throws Exception{
        List finalRoute = routePlanner.planner(new ArrayList<Destination>(asList(destinationX)));
        ArrayList<Character> expected = new ArrayList<Character>(asList('x'));
        assertEquals(expected, finalRoute);
    }

    @Test
    public void plannerWithOneYDestination() throws Exception {
        List finalRoute = routePlanner.planner(new ArrayList<Destination>(asList(destinationY)));
        ArrayList<Character> expected = new ArrayList<Character>(asList('y'));
        assertEquals(expected, finalRoute);
    }

    @Test
    public void plannerWithTwoIndependentDestinations() throws Exception {
        List finalRoute = routePlanner.planner(new ArrayList<Destination>(asList(destinationY, destinationX)));
        ArrayList<Character> expected = new ArrayList<Character>(asList('y', 'x'));
        assertEquals(expected, finalRoute);
    }

    @Test
    public void plannerWithTwoDependentDestinations() throws Exception {
        List finalRoute = routePlanner.planner(new ArrayList<Destination>(asList(destinationXY, destinationY)));
        ArrayList<Character> expected = new ArrayList<Character>(asList('y', 'x'));
        assertEquals(expected, finalRoute);
    }

    @Test
    public void plannerWithThreeDestinationsXpointYdependecyUnknown() throws Exception {
        List finalRoute = routePlanner
                .planner(new ArrayList<Destination>(asList(destinationZ, destinationXY, destinationYZ)));
        ArrayList<Character> expected = new ArrayList<Character>(asList('z', 'y', 'x'));
        assertEquals(expected, finalRoute);
    }

    @Test
    public void plannerWithFourDestinationsTpointUnknown() throws Exception {
        List finalRoute = routePlanner
                .planner(new ArrayList<Destination>(asList(destinationZ, destinationXY, destinationYZ, destinationTX)));
        ArrayList<Character> expected = new ArrayList<Character>(asList('z', 'y', 'x', 't'));
        assertEquals(expected, finalRoute);
    }

    @Test
    public void plannerWithFiveDestinationsWdependencyUnknown() throws Exception {
        List finalRoute = routePlanner
                .planner(new ArrayList<Destination>(asList(destinationZ, destinationXY, destinationYZ, destinationVU,
                        destinationUW)));
        ArrayList<Character> expected = new ArrayList<Character>(asList('z', 'y', 'x', 'w', 'u', 'v'));
        assertEquals(expected, finalRoute);
    }
}
