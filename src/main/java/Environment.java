import java.io.FileReader;
import java.util.Arrays;
import com.opencsv.CSVReader;

public class Environment {
    private int m;
    private int n;
    private Coordinates begin;
    private Coordinates end;

    private String[][] plateau;

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
            plateau=new String[m][n];
            int i=0,j=0;
            while ((nextLine = reader.readNext()) != null)
            {
                for(String token : nextLine)
                {
                    plateau[i][j]=token;
                    System.out.print(token);
                    j++;
                }
                i++;
                j=0;
                System.out.print("\n");
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        System.out.println(Arrays.deepToString(plateau));

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
                ", plateau=\n" + Arrays.deepToString(plateau) +
                '}';
    }

    public static void main(String[] args) {
        //Environment test=new Environment("src/main/resources/test.csv");
        //System.out.println(test);
    }
}
