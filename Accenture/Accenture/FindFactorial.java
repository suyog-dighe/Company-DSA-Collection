package Accenture;

public class FindFactorial {
    public static int findfact(int n){
        if (n==0 || n==1){
            return 1;
        }
        int fact=1;
        for (int i=2;i<=n;i++){
            fact *=i;
        }
        return fact;
    }
    public static void main(String[] args) {
        int n=5;
        System.out.println(findfact(n));

    }
}
