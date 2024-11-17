package Accenture_Ques_Paid;

public class TribonacciSeries {
    public static int triborecursive(int n){
        if (n==0){
            return 0;
        }
        if (n==1 || n==2){
            return 1;
        }
        return triborecursive(n-1)+triborecursive(n-2)+triborecursive(n-3);
    }
    public static void main(String[] args) {
        int n=9;
        System.out.println(triborecursive(n));
    }
}
