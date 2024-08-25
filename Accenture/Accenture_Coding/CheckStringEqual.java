package Accenture_Coding;
import java.util.Arrays;
public class CheckStringEqual {
    public static boolean checkequal(String s1, String s2){
        int n=s1.length();
        int m=s2.length();
        char s[]= new char[s1.length()];
        char d[]= new char[s2.length()];
        if (n!=m){
            return false;
        }
        for (int i=0;i<n;i++){
            s[i]=s1.charAt(i);
            d[i]=s2.charAt(i);
        }
        Arrays.sort(s);
        Arrays.sort(d);
        for (int i=0;i<n;i++){
            if (s[i]!=d[i]){
                return false;
            }
        }
        return true;
//        return s1.length() == s2.length() && s1.chars().sorted().toArray().equals(s2.chars().sorted().toArray());
    }


    public static boolean areAnagrams(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        if (n != m) {
            return false;
        }
        int[] charCount = new int[26];
        for (int i = 0; i < n; i++) {
            charCount[s1.charAt(i) - 'a']++; // Increment count for character in s1
            charCount[s2.charAt(i) - 'a']--; // Decrement count for character in s2
        }
        for (int count : charCount) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String s="listen";
        String d="silent";
//        int res=s.compareTo(d);
//        System.out.println(res);
        System.out.println(areAnagrams(s,d));
        System.out.println(checkequal(s,d));
    }
}
