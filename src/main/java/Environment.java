import java.io.FileReader;
import java.util.Arrays;
import com.opencsv.CSVReader;

public class Environment {
    private int m;
    private int n;
    private Coordinates begin;
    private Coordinates end;

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
            begin=new Coordinates(nextLine[2]);
            end= new Coordinates(nextLine[3]);
            grid =new EnvironmentTile[m][n];
            int i=0,j=0;
            while ((nextLine = reader.readNext()) != null)
            {
                for(String token : nextLine)
                {
                    grid[i][j]=EnvironmentTile.values()[Integer.parseInt(token)];
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
        Environment test=new Environment("src/main/resources/test.csv");
        test.printgrid();
    }
}
