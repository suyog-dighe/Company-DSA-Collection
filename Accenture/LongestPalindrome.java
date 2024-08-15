package Accenture;

public class LongestPalindrome {
    public static String palindrome(String s){
        int n=s.length();
        if (n==1 || n<0) return s;
        int st=0;
        int max=Integer.MIN_VALUE;
        // for odd case
        for (int i=0;i<n;i++){
            int l=i,j=i;
            while(l>=0 && j<n){
                if (s.charAt(l)==s.charAt(j)){
                    l--;
                    j++;
                }else{
                    break;
                }
            }
            int len=j-l-1;
            if(max<len){
                max=len;
                st=l+1;
            }
        }
        // even
        for (int i=0;i<n-1;i++){
            int l=i,j=i+1;
            while (l>=0 && j<n){
                if (s.charAt(l)==s.charAt(j)){
                    l--;
                    j++;
                }else{
                    break;
                }
            }
            int len=j-l-1;
            if(max<len){
                max=len;
                st=l+1;
            }
        }
        return s.substring(st,max);
    }
    public static int countsize(String v){
        return v.length();
    }
    public static void main(String[] args) {
        String s= "sanjivani";
        String v=palindrome(s);
        System.out.println(v);
        System.out.println(countsize(v));
//        System.out.println(s.length());
    }
}
