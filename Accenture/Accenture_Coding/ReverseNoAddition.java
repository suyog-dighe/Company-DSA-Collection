package Accenture_Coding;
public class ReverseNoAddition {
    public static int reverseNo(int n){
        int reverse=0;
        while (n>0){
            int di=n%10;
            reverse= reverse*10+di;
            n /=10;
        }
        return reverse;
    }

    public static int reverseUsingString(int n){
        String p=String.valueOf(n);
        String s=new StringBuilder(p).reverse().toString();
        int d=Integer.parseInt(s);
        return d;
    }
    public static int numberSum(int m,int n){
        int sum=0;
        for (int i=m;i<=n;i++){
            int no=reverseNo(i);
            sum +=no;
        }
        return sum;
    }
    public static void main(String[] args) {
//        Time Complexity (TC): O((n - m + 1) * log(n))
//        Space Complexity (SC): O(1)
        // which is better than string approach
        int m=6;
        int n=9;
        int p=12345;
        System.out.println(reverseNo(p));
        System.out.println(reverseUsingString(p));
        System.out.println(reverseNo(m));
        System.out.println(numberSum(m,n));

    }
}
