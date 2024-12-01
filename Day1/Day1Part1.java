import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Day1Part1{
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

    public static int[] genererTableau1(File file) throws IOException{
        int[] tab1 = new int[nbLignes(file)];
        String ligne;
        int index = 0;
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        while((ligne = br.readLine())!=null){
            String[] parties = ligne.trim().split("\\s+");
            int nb1 = Integer.parseInt(parties[0]);
            tab1[index] = nb1;
            index++;
        }
        br.close();
        return tab1;
    }

    public static int[] genererTableau2(File file) throws IOException{
        int[] tab1 = new int[nbLignes(file)];
        String ligne;
        int index = 0;
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        while((ligne = br.readLine())!=null){
            String[] parties = ligne.trim().split("\\s+");
            int nb2 = Integer.parseInt(parties[1]);
            tab1[index] = nb2;
            index++;
        }
        br.close();
        return tab1;
    }

    public static void afficheTableau(int[]t){
        for (int i = 0; i<t.length; i++){
            System.out.print(t[i]+" ");
        }
            System.out.println();
    }



    public static int[] decouper(int[]t, int deb, int fin){
        int[] tDecoupe = new int[fin-deb];
        for (int i = 0; i<tDecoupe.length; i++){
            tDecoupe[i] = t[i+deb];
        }
        return tDecoupe;
    }

    public static int[] triFusion(int[] tab1, int[] tab2){
        int indiceTab1 = 0; 
        int indiceTab2 = 0; 
        int indice = 0; 
        int[] tabFusion = new int[tab1.length+tab2.length];
        while(indiceTab1<tab1.length && indiceTab2<tab2.length){
            if(tab1[indiceTab1]<tab2[indiceTab2]){
                tabFusion[indice] = tab1[indiceTab1++];

            }
            else{
                tabFusion[indice] = tab2[indiceTab2++];
            }
            indice++;

        }
        while(indiceTab1<tab1.length){
            tabFusion[indice++] = tab1[indiceTab1++];
        }
        while(indiceTab2<tab2.length){
            tabFusion[indice++] = tab2[indiceTab2++];
        }
        return tabFusion;
    }

    public static void fusion(int[]t){
        if(t.length>1){
            int[] t1 = decouper(t, 0, t.length/2);
            int[] t2 = decouper(t, t.length/2, t.length);
            fusion(t1);
            fusion(t2);
            int[] tFusion = triFusion(t1, t2);
            System.arraycopy(tFusion, 0, t, 0, t.length);
        }

    }


    public static int distance(File file) throws IOException{
       int[] tab1 = genererTableau1(file);
       int[] tab2 = genererTableau2(file);
       fusion(tab1);
       fusion(tab2);

       int distanceTotale = 0;
       for (int i = 0; i<tab1.length; i++){
            distanceTotale += Math.abs(tab1[i]-tab2[i]);

       }
        return distanceTotale;

    }


    public static void main(String[] args) {
       try{
            File file = new File("input.txt");
            System.out.println(nbLignes(file));
            System.out.println("La distance totale est de : " + distance(file));
        }
        catch(IOException e){
            e.getMessage();
        } 
    }
}
