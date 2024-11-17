package Accenture_New_One;

public class NaturalSum {
    static int sum=0;
    public static void natural(int n){
//        int sum=0;
        if (n==0){
            return;
        }
        sum+=n;
        natural(n-1);
//        for (int i=0;i<=n;i++){
//            sum+=i;
//        }
//        System.out.println(sum);
    }
    public static void main(String[] args) {
        int n=10;
//        int sum=0;
       natural(n);
        System.out.println(sum);
    }
}
