package Accenture_Coding;

public class DeciToBinary {
    public static String decitobin(int n){
        String ans="";
        if (n==0){
            return "0";
        }
        while (n>0){
//            if (n%2==0){
//                ans="0"+ans;
//            }else {
//                ans="1"+ans;
//            }
            ans= ((n%2==0)?"0":"1") + ans;
            n/=2;
        }
        return ans;
    }

    public static int decitobin1(int n){
        int a=0;
        int p=1;

        while (n>0){
            int d=n%2;
            a+=d*p;
            p*=10;
            n/=2;
        }
        return a;
    }
    public static void main(String[] args) {
        int a=6;
        System.out.println(decitobin(a));
        System.out.println(decitobin1(a));

    }
}
