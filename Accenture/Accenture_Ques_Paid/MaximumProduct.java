package Accenture_Ques_Paid;

public class MaximumProduct {
    public static int maxi(int n){
        if (n==2) return 1;
        if (n==3)return 2;

        int product=1;
        while (n>4){
            product *=3;
            n=n-3;
        }
        product *=n;
        return product;
    }
    public static void main(String[] args) {
        int n=10;
        int s=9;
        int d=6;
        System.out.println(maxi(n));
        System.out.println(maxi(s));
        System.out.println(maxi(d));
    }
}
