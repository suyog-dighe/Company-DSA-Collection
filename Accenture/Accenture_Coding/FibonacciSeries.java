package Accenture_Coding;

public class FibonacciSeries {

    //Using for loop  Tc:- O(n)   &   SC :- O(1)
    public static void fibo(int n){
        if (n == 0) {
            System.out.print("0 ");
            return;
        }
        if (n == 1) {
            System.out.print("0 1 ");
            return;
        }
        System.out.print("0 1 ");
        int prev=0,prev1=1;
        for(int i=2;i<=n;i++){
            int curr=prev+prev1;
            System.out.print(curr+" ");
            prev=prev1;
            prev1=curr;
        }
//        return prev1;
    }

    //Using Recursive Approach
    public static int fiborecursive(int n){
        if (n==0){
            return 0;
        }
        if (n==1){
            return 1;
        }
        return fiborecursive(n-1)+fiborecursive(n-2);
    }

    public static void main(String[] args) {
        int n=4;
        int s=7;
        System.out.println("heli");
        fibo(n);
        System.out.println();
        System.out.println(fiborecursive(n));

    }
}
