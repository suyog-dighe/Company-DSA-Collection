package Accenture;

public class IsPalindromeString {
    public static boolean ispalindrome(String s){
        int left=0;
        int right=s.length()-1;
        while (left < right){
            if (s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    // make new string of n's numbers
    public static String makeNewString(String s,int k){
        String  ans="";
        while (k-->0){
            ans+=s;
        }
        return ans;
    }
    public static void main(String[] args) {

        String  v="Aniket";
        String  d="nitin";
        int s=3;
        System.out.println(makeNewString(v,s));
        System.out.println(ispalindrome(v));
        System.out.println(ispalindrome(d));

    }
}
