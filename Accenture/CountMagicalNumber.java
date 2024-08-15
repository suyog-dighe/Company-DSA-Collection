package Accenture;
import java.util.Scanner;

/*
Find count A Number of Magical numbers from 1 ton iş magical if:
 1. Convert to binary.
 2. Replace O with 1 & 1 with 2 in binary string.
 3. Calculate sum of all digits in binary string.
 4. Resultant must be on ODD number.
 */

public class CountMagicalNumber {
    public static int magicalcount(int n){
        int count=0;
        for (int i=1;i<=n;i++){
            int zero=binarycount(i);
            if (zero%2==1){
                count++;
            }
        }
        return count;
    }
    // Count Number of Zero's
    public static int binarycount(int a){
       int b= binary(a);
       int count=0;
       while (b>0){
           int n=b%10;
           if (n==0){
               count++;
           }
           b /=10;
       }
       return count;
    }
    // Decimal number ot Binary Number || Convert Binary form
    public static int binary(int n){
      int an=0;
      int f=1;
      while (n>0){
         int d =n%2;
         an+=d*f;
         f*=10;
         n/=2;
      }
      return an;
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(magicalcount(n));
        System.out.println(binary(n));

    }
}
