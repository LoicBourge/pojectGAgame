import java.util.Arrays;

public class Creature implements Igenomes {

    //private Environment environment;
    private double score;

    private Movement[] movements;

    public Creature() {
    }

    //public Creature(Environment environment, Movement[] movements) {
     //   this.environment = environment;
     //   this.movements = movements;
    //}
    public Creature(Movement[] movements) {
        this.movements = movements;
    }

    @Override
    public void mutate() {

    }

    @Override
    public String toString() {
        return "Creature{" +
                //"environment=" + environment +
                ", score=" + score +
                ", movements=" + Arrays.toString(movements) +
                '}';
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public Movement[] getMovements() {
        return movements;
    }

    public void setMovements(Movement[] movements) {
        this.movements = movements;
    }
}
