import java.io.FileReader;
import java.util.Arrays;
import com.opencsv.CSVReader;

public class Environment {
    private int m;
    private int n;
    private Coordinates begin;
    private Coordinates end;
    private Coordinates creaturepositon;

    private EnvironmentTile[][] grid;

    public Environment(int m, int n) {
        this.m = m;
        this.n = n;
    }

    public Environment(String pathname){
        CSVReader reader;
        try
        {
            reader = new CSVReader(new FileReader(pathname));
            String [] nextLine= reader.readNext();
            m=Integer.parseInt(nextLine[0]);
            n=Integer.parseInt(nextLine[1]);
            grid =new EnvironmentTile[m][n];
            int i=0,j=0;
            while ((nextLine = reader.readNext()) != null)
            {
                for(String token : nextLine)
                {
                    grid[i][j]=EnvironmentTile.values()[Integer.parseInt(token)];
                    if(grid[i][j]==EnvironmentTile.START)
                    {
                        begin=new Coordinates(j,i);
                        creaturepositon=begin;
                    }
                    if(grid[i][j]==EnvironmentTile.END)
                    {
                        end=new Coordinates(j,i);
                    }
                    //System.out.print(token);
                    j++;
                }
                i++;
                j=0;
                //System.out.print("\n");
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        System.out.println(Arrays.deepToString(grid));

    }

    public void generate(){
        //TODO génerer l'environnement
    }

    private void setCreaturepositon(Coordinates newcreaturepositon) {
        System.out.println("Creature position "+creaturepositon + "begin "+begin );
        if(creaturepositon==begin){
            grid[creaturepositon.getY()][creaturepositon.getX()]=EnvironmentTile.START;
        }
        else
        {
            grid[creaturepositon.getY()][creaturepositon.getX()]=EnvironmentTile.VIDE;
        }
        creaturepositon = newcreaturepositon;
        grid[creaturepositon.getY()][creaturepositon.getX()]=EnvironmentTile.CREATURE;
    }

    public boolean movecreature(Movement movement){
        System.out.println("Mouv "+movement+" X "+movement.getX()+" Y "+movement.getY());
        Coordinates newposition=new Coordinates(creaturepositon.getX()-movement.getX(),creaturepositon.getY()-movement.getY());
        System.out.println("Creature position "+creaturepositon+"newposition"+newposition+"|"+grid[newposition.getX()][newposition.getY()]);
        if(grid[newposition.getY()][newposition.getX()]!=EnvironmentTile.TILE)
        {
            setCreaturepositon(newposition);
            movegraviti(movement);
            return true;
        }
        return false;
    }
    public void movegraviti(Movement movement){
        if(movement==Movement.UP || movement==Movement.RIGHT || movement==Movement.LEFT || movement==Movement.DOWN_LEFT || movement==Movement.DOWN_RIGHT){
            Coordinates newposition=new Coordinates(creaturepositon.getX(),creaturepositon.getY()+1);
            if(grid[newposition.getY()][newposition.getX()]!=EnvironmentTile.TILE)
            {
                setCreaturepositon(newposition);
            }
        }
    }

    @Override
    public String toString() {
        return "environnement{" +
                "m=" + m +
                ", n=" + n +
                ", begin=" + begin +
                ", end=" + end +
                ", grid=\n" + Arrays.deepToString(grid) +
                '}';
    }

    public void printgrid(){
        for (EnvironmentTile[] environmentTiles : grid) {
            for (EnvironmentTile environmentTile : environmentTiles) {
                System.out.print(environmentTile);
            }
            System.out.println();
        }
        System.out.println();
    }


    public static void main(String[] args) {
        //Environment test=new Environment("src/main/resources/test.csv");
        //test.printgrid();
    }
}
