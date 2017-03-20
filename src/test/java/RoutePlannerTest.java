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

    @Test
    public void plannerWithOneXDestination() throws Exception{
        List finalRoute = routePlanner.planner(new char[][]{{'x'}});
        ArrayList<Character> expected = new ArrayList<Character>(asList('x'));
        assertEquals(expected, finalRoute);
    }

    @Test
    public void plannerWithOneYDestination() throws Exception {
        List finalRoute = routePlanner.planner(new char[][]{{'y'}});
        ArrayList<Character> expected = new ArrayList<Character>(asList('y'));
        assertEquals(expected, finalRoute);
    }

    @Test
    public void plannerWithTwoIndependentDestinations() throws Exception {
        List finalRoute = routePlanner.planner(new char[][]{{'y'}, {'x'}});
        ArrayList<Character> expected = new ArrayList<Character>(asList('y', 'x'));
        assertEquals(expected, finalRoute);
    }

    @Test
    public void plannerWithTwoDependentDestinations() throws Exception {
        List finalRoute = routePlanner.planner(new char[][]{{'x', 'y'}, {'y'}});
        ArrayList<Character> expected = new ArrayList<Character>(asList('y', 'x'));
        assertEquals(expected, finalRoute);
    }

    @Test
    public void plannerWithThreeDestinations() throws Exception {
        List finalRoute = routePlanner.planner(new char[][]{{'z'}, {'x', 'y'}, {'y', 'z'}});
        ArrayList<Character> expected = new ArrayList<Character>(asList('z', 'y', 'x'));
        assertEquals(expected, finalRoute);
    }
}
