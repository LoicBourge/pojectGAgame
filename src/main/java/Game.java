import java.util.ArrayList;
import java.util.Comparator;

public class Game {
    int maxTic;
    int nbrCreatures = 10;
    double mutationRate = 0.02;
    double crossoverRate = 0.5;
    double pourcentkeepparents = 0.2;
    int nbrGeneration = 2;

    ArrayList<Creature> creatures = new ArrayList<>();
    //Creature creature;
    Environment environment;

    public Game(int maxTic, Environment environment) {
        this.maxTic = maxTic;
        this.environment = environment;
        for (int i = 0; i < nbrCreatures; i++) {
            creatures.add(new Creature(new Environment(environment), Movement.multiplechoiceMovement("3344")));
        }
    }

    private Creature playGame(boolean print) {

        for (int i = 0; i < nbrGeneration; i++) {
            for (Creature creature : creatures) {
                System.out.println("Creature debut : "+creature.getEnvironment().getCreaturepositon());

                int temp=maxTic;
                for (int j = 0; j < temp; j++) {
                    temp = creature.nextMove(j, temp, print);
                }
                System.out.println("Score: " + creature.getScore());
                System.out.println("Creature fin");
            }
            newGeneration(bestfitselection());
            System.out.println("End generation " + i);
        }
        return bestfitselection().get(0);
    }

    public static void main(String[] args) {
        Environment environment = new Environment("src/main/resources/test.csv");
        Game game = new Game(15, environment);
        Creature bestcreature=game.playGame(true);
        System.out.println("Best creature "+bestcreature);
    }

    private ArrayList<Creature> bestfitselection() {
        int nbrkeepparents = (int) (creatures.size() * pourcentkeepparents);
        creatures.sort(Comparator.comparingDouble(Creature::getScore));
        ArrayList<Creature> selectedcreature = new ArrayList<>(creatures);
        selectedcreature.subList(nbrkeepparents, selectedcreature.size()).clear();
        return selectedcreature;
    }

    private void newGeneration(ArrayList<Creature> newcreatures) {
        for (int i = newcreatures.size(), j = 0; i < nbrCreatures; i++, j++) {
            newcreatures.add((creatures.get(j).crossover(creatures.get(j + 1), new Environment(environment), crossoverRate)).mutate(mutationRate));
        }
        creatures.clear();
        creatures.addAll(newcreatures);
    }

}
