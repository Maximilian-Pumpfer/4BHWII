package SWP_OP.Recursive;

import java.util.Scanner;

public class RekursiveRechnungen {

    static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Soll eine Summe oder Potenz berechnet werden?");
       
       String ans = s.nextLine();
           processInput(ans);
       }

    public static void processInput(String ans){
        boolean right = false;
       if(ans.equals("Summe")){
        right = true;
        System.out.println("Anzahl:");
        int amount = Integer.parseInt(s.nextLine());

        long t1 = System.nanoTime();
        System.out.print("Iterativ: " + IterSum(amount));
        long t2 = System.nanoTime();
        System.out.println("\tZeit: " + ((t2-t1)/1000) + "µs");

        long t3 = System.nanoTime();
        System.out.print("Rekursiv: " + RecSum(amount));
        long t4 = System.nanoTime();
        System.out.println("\tZeit: " + ((t4-t3)/1000) + "µs");

        long t5 = System.nanoTime();
        System.out.print("End-Rekursiv: " + EndRecSum(0, amount));
        long t6 = System.nanoTime();
        System.out.println("\tZeit: " + ((t6-t5)/1000) + "µs");
       }
       if(ans.equals("Potenz")){
           right = true;
        System.out.println("Zahl:");
        int num = Integer.parseInt(s.nextLine());
        System.out.println("Potenz:");
        int amount = Integer.parseInt(s.nextLine());
        
        long t1 = System.nanoTime();
        System.out.print("Rekursiv: " + RecPow(num, amount));
        long t2 = System.nanoTime();
        System.out.println("\tZeit: " + ((t2-t1)/1000) + "µs");

        long t3 = System.nanoTime();
        System.out.print("End-Rekursiv: " + EndRecPow(num, num, amount));
        long t4 = System.nanoTime();
        System.out.println("\tZeit: " + ((t4-t3)/1000) + "µs");
       }
       if(right == false){
           System.out.println("Eingabe ist falsch, bitte erneut eingeben!");
           String n = s.nextLine();
           processInput(n);
       }

    }

public static long IterSum(long count){
    long result = 0;
    for(long i = 0; i < count; i++){
        result+=i;
    }
    return result;
}

public static long RecSum(long count){

       if (count == 0){
        return count;
       }else{
            return count-1 + RecSum(count - 1);
       }
}

public static long EndRecSum(long result, long amount){
    if(amount==0){
        return result;
    }else{
        return EndRecSum(result+(amount-1), amount-1);
    }
}

public static long IterPow(long num, long pow){
    int result = 0;
    for(int i=0; i<pow; i++){
        result*=num;
    }
    return result;
}

public static long RecPow(long num, long pow){
    if (pow == 1){
        return num;
       }else{
            return num * RecPow(num, pow - 1);
       }
}
public static long EndRecPow(long num, long base, long pow) {
    if(pow==1){
        return num;
    }else{
        return EndRecPow(num*base, base, pow-1);
    }
}

}
