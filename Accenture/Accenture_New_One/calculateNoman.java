package Accenture_New_One;

public class calculateNoman {
    public static void calc(int n, int min){
        int remain=240-min;
        int count=0;
        int ans=0;
        for (int i=1;i<=n;i++){
             ans += 5*i;
            if (ans< remain){
                count++;
            }
        }
        System.out.println(count);
    }
    public static void main(String[] args) {
        int n=8;
        int m=30;
        calc(n,m);
    }
}
