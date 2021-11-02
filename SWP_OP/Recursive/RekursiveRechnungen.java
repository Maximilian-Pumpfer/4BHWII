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
        System.out.println("Iterativ: " + IterSum(amount));
        System.out.println("Rekursiv: " + RecSum(amount));
       }
       if(ans.equals("Potenz")){
           right = true;
        System.out.println("Zahl:");
        int num = Integer.parseInt(s.nextLine());
        System.out.println("Potenz:");
        int amount = Integer.parseInt(s.nextLine());
        System.out.println(RecPow(num, amount));
       }
       if(right == false){
           System.out.println("Eingabe ist falsch, bitte erneut eingeben!");
           String n = s.nextLine();
           processInput(n);
       }

    }

public static int IterSum(int count){
    int result = 0;
    for(int i = 0; i < count; i++){
        result+=i;
    }
    return result;
}

public static int RecSum(int count){

       if (count == 0){
        return count;
       }else{
            return count-1 + RecSum(count - 1);
       }
}

public static double RecPow(int num, int pow){
    if (pow == 1){
        return num;
       }else{
            return num * RecPow(num, pow - 1);
       }
}

}
