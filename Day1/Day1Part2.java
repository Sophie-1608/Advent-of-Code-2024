import java.io.File;
import java.io.IOException;

public class Day1Part2 {
    public static int nbOccurrences(int[]t, int n){
        int cmpt = 0;
        for (int i = 0; i<t.length;i++){
            if(t[i] == n){
                cmpt++;
            }

        }
        return cmpt;
    }

    public static int calculSimilarites(int[]t1, int[]t2){
        int similaritesCmpt = 0;
        for (int i = 0; i<t1.length; i++){
            similaritesCmpt += t1[i] * nbOccurrences(t2, t1[i]);
        }
        return similaritesCmpt;
        
    }

    public static void main(String[] args) {
       try{
            File file = new File("input.txt");
            int[] t1 = Day1Part1.genererTableau1(file);
            int[] t2 = Day1Part1.genererTableau2(file);
            System.out.println(calculSimilarites(t1, t2));
        }
        catch(IOException e){
            e.getMessage();
        } 
    }

}
