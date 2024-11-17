package Accenture;

public class SumOfAllPrimeNumber {
    public static int sumprime(int n){
        if (n<2){
            return 0;
        }
        int sum=0;
        for (int i=2;i<=n;i++){
            if (isprime(i)){
                sum +=i;
            }
        }
        return sum;
    }
    public static boolean isprime(int n){
        for (int i=2;i<=Math.sqrt(n);i++){
            if (n%i==0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int a=11;
        System.out.println(Math.sqrt(a));
        System.out.println(sumprime(a));

    }
}
