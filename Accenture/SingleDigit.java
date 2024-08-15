package Accenture;

/*
level - Easy
Give a no N your task is to make it single digit
- If N is odd make it floor (N/2);
- If N is even make it floor (N-2)/2;
- If N is already a single digit print as it is
 */

public class SingleDigit {
    public static int makesingle(int n){
        while(n>9){
            if(n%2==0){
               n= (n-2)/2;
            }
            else{
                n= n/2;
            }
        }
        return n;
    }
    public static void main(String[] args) {
        int a=12;
        System.out.println(makesingle(a));

    }
}
