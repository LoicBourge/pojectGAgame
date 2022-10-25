public class Game {
    int maxTick;
    Creature creature;
    Environment environment;

    public Game(int maxTick, Creature creature, Environment environment) {
        this.maxTick = maxTick;
        this.creature=creature;
        this.environment=environment;
    }

    public void playGame(boolean print){
        for (int i = 0; i < maxTick; i++) {
            System.out.println(environment.movecreature(creature.getMovements()[i]));
            if(print){
                environment.printgrid();
            }
        }
    }

    public static void main(String[] args) {
        Environment environment=new Environment("src/main/resources/test.csv");
        Creature creature=new Creature(Movement.multiplechoiceMovement("43123"));
        Game game=new Game(4,creature,environment);
        game.playGame(true);
    }

}
