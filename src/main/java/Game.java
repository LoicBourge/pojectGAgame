public class Game {
    int maxTic;
    Creature creature;
    Environment environment;

    public Game(int maxTic, Creature creature, Environment environment) {
        this.maxTic = maxTic;
        this.creature=creature;
        this.environment=environment;
    }

    public void playGame(boolean print){
        for (int i = 0; i < maxTic; i++) {
            maxTic= creature.nextmove(i,maxTic,print);
        }
        System.out.println("Score: "+creature.getScore());
    }

    public static void main(String[] args) {
        Environment environment=new Environment("src/main/resources/test.csv");
        Creature creature=new Creature(environment,Movement.multiplechoiceMovement("4"));
        Game game=new Game(15,creature,environment);
        game.playGame(true);
    }

}
