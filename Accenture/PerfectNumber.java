package Accenture;

public class PerfectNumber {
    public static boolean perfect(int n){
        if (n<=1){
            return false;
        }
        int sum=1;
        for (int i=2;i<=n/2;i++){
            if (n %i==0){
                sum+=i;
            }
        }
        return sum==n;
    }
    public static void main(String[] args) {

        int s=9;
        int d=28;
        System.out.println(perfect(s));
        System.out.println(perfect(d));
    }
}
