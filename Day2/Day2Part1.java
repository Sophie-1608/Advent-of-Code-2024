import java.io.*;

public class Day2Part1{

    public static int nbLignes(File file) throws IOException{
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String ligne;
        int lignesCmpt = 0;
        while ((ligne = br.readLine())!=null){
            lignesCmpt++;
        }
        br.close();
        return lignesCmpt;
    }

    public static int[] genererTab(File file) throws IOException{
        int[] tab = new int[nbLignes(file)];
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String ligne;
        int index = 0;
        while((ligne = br.readLine())!=null){
            tab[index] = Integer.parseInt(ligne.trim());
            index++;

        }
        return tab;
    }

    public static boolean estDecroissant(String[]niveaux){
        for (int i = 0; i < niveaux.length-1; i++){
            if(Integer.parseInt(niveaux[i])<Integer.parseInt(niveaux[i+1])){
                return false;
            }
        }
        return true;
    }

    public static boolean estCroissant(String[]niveaux){
        for (int i = 0; i < niveaux.length-1; i++){
            if(Integer.parseInt(niveaux[i])>Integer.parseInt(niveaux[i+1])){
                return false;
            }
        }
        return true;
    }

    public static int valAbs(int a, int b){
        if(a<b){
            return b-a;
        }
        else{
            return a-b;
        }
    }

    public static boolean differenceAdjacent(String[] niveaux){
        for (int i = 0; i < niveaux.length-1; i++){
            int diff = valAbs(Integer.parseInt(niveaux[i]),Integer.parseInt(niveaux[i+1]));
            if (diff<1 || diff >=4){
                return false;
            }
            
        }
        return true;
    }

    public static int comptListeSafe(File file) throws IOException{
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String ligne;
        int cmpt = 0;
        while((ligne = br.readLine())!=null){
            String[] niveaux = ligne.split(" ");
            if(estDecroissant(niveaux)||estCroissant(niveaux) && differenceAdjacent(niveaux)){
                cmpt++;
            }

        }
        br.close();
        return cmpt;
    }
    public static void main(String[] args) {
        try{
            File file = new File("input.txt");
            System.out.println(comptListeSafe(file));
        }
        catch(IOException e){
            e.getMessage();
        } 
    }
}
