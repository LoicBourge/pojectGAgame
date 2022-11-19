import java.sql.SQLOutput;
import java.util.Arrays;

public class Creature implements Igenomes {

    //private Environment environment;
    private Environment environment=null;

    private Movement[] movements;

    public Creature() {
    }

    public Creature(Environment environment, Movement[] movements) {
        this.environment = environment;
        this.movements = movements;
    }
    public Creature(Movement[] movements) {
        this.movements = movements;
    }

    //TODO ajouter le mutationrate, et faire probabilité et mouvement mutate
    @Override
    public void mutate() {

    }

    @Override
    public String toString() {
        return "Creature{" +
                //"environment=" + environment +
                ", movements=" + Arrays.toString(movements) +
                '}';
    }

    public double getScore() {

        double X=environment.getCreaturepositon().getX()-environment.getEnd().getX();
        double Y=environment.getCreaturepositon().getY()-environment.getEnd().getY();
        System.out.println("X= "+X+" Y= "+Y);
        X=X*X;
        Y=Y*Y;
        System.out.println("X= "+X+" Y= "+Y);
        return 1/(Math.sqrt(X+Y));
    }


    public Movement[] getMovements() {
        return movements;
    }

    public void setMovements(Movement[] movements) {
        this.movements = movements;
    }

    public int nextmove(int indice,int maxTic,boolean print){
        if(indice<getMovements().length)
        {
            maxTic=environment.movecreature(getMovements()[indice],maxTic);
        }
        else
        {
            maxTic=0;
        }
        if(print){
            System.out.println("tic restant: "+maxTic);
            environment.printgrid();
        }
        return maxTic;
    }
}
