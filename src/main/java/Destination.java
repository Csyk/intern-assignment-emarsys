/**
 * Created by csyk on 2017.03.21..
 */
public class Destination {

    private char point;
    private char dependency;

    public Destination(char point){
        this.point = point;
    }

    public Destination(char point, char dependency){
        this.point = point;
        this.dependency = dependency;
    }

    public char getPoint() {
        return point;
    }

    public char getDependency() {
        return dependency;
    }
}

