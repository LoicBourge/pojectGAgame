import java.util.Arrays;

public class Creature implements Igenomes {

    private Environment environment;
    private double score;
    private Coordinates position;

    private Movement[] movements;

    public Creature() {
    }

    public Creature(Environment environment, Movement[] movements) {
        this.environment = environment;
        this.movements = movements;
    }

    @Override
    public void mutate() {

    }

    @Override
    public String toString() {
        return "Creature{" +
                "environment=" + environment +
                ", score=" + score +
                ", position=" + position +
                ", movements=" + Arrays.toString(movements) +
                '}';
    }
}
