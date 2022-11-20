import java.util.ArrayList;

public class Creature {

    //private Environment environment;
    private final Environment environment;

    private ArrayList<Movement> movements;


    public Creature(Environment environment, ArrayList<Movement> movements) {
        this.environment = environment;
        this.movements = movements;
    }


    public Creature mutate(double mutationRate) {
        for (int i = 0; i < movements.size(); i++) {
            Movement movement;
            if (Math.random() <= mutationRate) {
                do {
                    movement = Movement.values()[(int) (1 + Math.random() * 7)];
                } while (movement == movements.get(i));
                movements.set(i, movement);
            }
        }
        return this;
    }


    public Creature crossover(Creature b, Environment environment, double crossoverRate) {
        ArrayList<Movement> newmovements = new ArrayList<>();
        for (int i = 0; i < movements.size(); i++) {
            if (Math.random() <= crossoverRate) {
                newmovements.add(movements.get(i));
            } else {
                newmovements.add(b.movements.get(i));
            }
        }
        return new Creature(new Environment(environment), newmovements);
    }

    @Override
    public String toString() {
        return "Creature{" +
                "environment=" + environment +
                ", movements=" + movements +
                '}';
    }

    public double getScore() {
        double X = environment.getCreaturepositon().getX() - environment.getEnd().getX();
        double Y = environment.getCreaturepositon().getY() - environment.getEnd().getY();
        X *= X;
        Y *= Y;
        return 1 / (Math.sqrt(X + Y));
    }


    public ArrayList<Movement> getMovements() {
        return movements;
    }

    public void setMovements(ArrayList<Movement> movements) {
        this.movements = movements;
    }

    public int nextMove(int indice, int maxTic, boolean print) {
        if (environment.getCreaturepositon().equals(environment.getEnd())) {
            movements.subList(indice, movements.size()).clear();
            System.out.println("Fin ");
            return 0;
        }
        if (indice < getMovements().size()) {
            maxTic = environment.movecreature(movements.get(indice), maxTic);
        } else {
            maxTic = 0;
        }
        if (print) {
            System.out.println("tic restant: " + maxTic);
            environment.printGrid();
        }
        return maxTic;
    }

    public Environment getEnvironment() {
        return environment;
    }
}
