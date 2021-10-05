package SWP_OP.BinarySearch;

import java.util.Random;
import java.util.stream.IntStream;

public class BinäreSuche{

    static int[] werte;
    static int gesuchteZahl;

    public static void main(String[] args) {
        
            werte = IntStream.range(1, randomAmount()).toArray();
            gesuchteZahl = randomNumber();
            System.out.println(werte.length + " , " + gesuchteZahl);
            Iterate(werte, gesuchteZahl);
            BinarySearch(werte, gesuchteZahl);

    }

    private static int randomAmount(){
    	
    	Random random = new Random();
        
    	int x = random.nextInt(99999) + 1;
        return x;

    }

    private static int randomNumber(){

    	Random random = new Random();
    	
        int rN = random.nextInt(werte.length);

        return rN;

    }

    private static void Iterate(int[] arr, int num){

        int runs = 0;
        
        for(int i = 0; i<arr.length;i++){
            runs++;
            if(arr[i] == num){
                System.out.println("Iteration-Durchläufe: " + runs);
                break;
            }
        }

    }

    private static void BinarySearch(int[] arr, int num){

        double split = 1;
        double addOrSub = 0;
        int runs = 0;
        
        for(int i = 0; i<arr.length;i++){
        	runs++;
            if(arr[(int) (arr.length/2+addOrSub)] == num){
                System.out.println("BinarySearch-Durchläufe: " + runs);
                break;
            }else if(arr[(int) (arr.length/2+addOrSub)] < num){
            	split*=2;
            	addOrSub+=(double) (arr.length/2.0/split);
            }else{
            	split*=2;
            	addOrSub-=(double) (arr.length/2.0/split);
            }

        }

    }

}