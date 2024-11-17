package Accenture_Coding;
import java.util.ArrayList;

public class AllPrimeUptoN {
    public static ArrayList<Integer> primeNo(int n){
        ArrayList<Integer> list= new ArrayList<>();
        for (int i=0;i<=n;i++){
            if (isprime(i)){
                list.add(i);
            }
        }
        return list;
    }
    public static boolean isprime(int n){
        if (n<=1){
            return false;
        }
        for (int i=2;i<=n/2;i++){
            if (n%i==0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int n=10;
        System.out.println(primeNo(n));
    }
}
