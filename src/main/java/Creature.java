import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;

public class Creature {

    //private Environment environment;
    private Environment environment;

    private ArrayList<Movement> movements;


    public Creature(Environment environment, ArrayList<Movement> movements) {
        this.environment = environment;
        this.movements = movements;
    }


    //TODO ajouter le mutationrate, et faire probabilité et mouvement mutate

    public void mutate() {

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
        return new Creature(environment, newmovements);
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
        System.out.println("X= " + X + " Y= " + Y);
        X *= X;
        Y *= Y;
        System.out.println("X= " + X + " Y= " + Y);
        return 1 / (Math.sqrt(X + Y));
    }


    public ArrayList<Movement> getMovements() {
        return movements;
    }

    public void setMovements(ArrayList<Movement> movements) {
        this.movements = movements;
    }

    public int nextmove(int indice, int maxTic, boolean print) {
        if (environment.getCreaturepositon() == environment.getEnd()) {
            movements.subList(indice, movements.size()).clear();
            return 0;
        }
        if (indice < getMovements().size()) {
            maxTic = environment.movecreature(movements.get(indice), maxTic);
        } else {
            maxTic = 0;
        }
        if (print) {
            System.out.println("tic restant: " + maxTic);
            environment.printgrid();
        }
        return maxTic;
    }
}
