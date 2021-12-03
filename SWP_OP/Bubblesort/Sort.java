package SWP_OP.Bubblesort;

import java.util.Random;
import java.util.Scanner;

public class Sort {
    
    private static int[] numbers;
    private static int swaps;
    private static long timeForSorting;

    public static void main(String[] args) {

        createArray();
        swaps = sortArray(numbers);
        System.out.println("Das Array wurde " + swaps + " mal vertauscht zum Sortieren");
        System.out.println("Dieser Sortiervorgang dauerte " + timeForSorting + "ms");
        
    }
    
    public static void createArray(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Wie lang soll das zu sortierende Array sein?");
        int length = Integer.parseInt(sc.nextLine());
        sc.close();
        numbers = new int[length];

        for(int i = 0; i<length;i++){
            numbers[i] = i;
        }
        Random rand = new Random();
		
		for (int i = 0; i < numbers.length; i++) {
			int randomIndexToSwap = rand.nextInt(numbers.length);
			int temp = numbers[randomIndexToSwap];
			numbers[randomIndexToSwap] = numbers[i];
			numbers[i] = temp;
		}
    }

    public static int sortArray(int[] arr){
        int swaps = 0;
        long t1 = System.nanoTime();

        for(int i = arr.length; i>1; i--){
            for(int j=0;j<i-1;j++){
                if(arr[j] > arr[j+1]){
                    swaps++;
                    int help = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = help;
                }
            }
        }

        long t2 = System.nanoTime();

        timeForSorting = (t2-t1)/1000000;

        return swaps;
    }
}
