package Accenture;

import java.util.Arrays;

public class CountAll_Palindrome {
    public static int countPalindrome(String s,int i,int j, int[][]dp){
        if (i==j){
            return 1;
        }
        if (i>j){
            return 0;
        }
        if (dp[i][j]!=-1){
            return dp[i][j];
        }
        if (s.charAt(i)==s.charAt(j)){
            return dp[i][j]=1+countPalindrome(s,i+1,j,dp)+countPalindrome(s,i,j-1,dp);
        }
        else {
            return dp[i][j]=countPalindrome(s,i+1,j,dp)+countPalindrome(s,i,j-1,dp)-countPalindrome(s,i+1,j-1,dp);
        }
    }
    public static void main(String[] args) {
    String v="naman";
    int i=0;
    int j=v.length()-1;
    int[][]dp=new int[v.length()][v.length()];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        System.out.println(countPalindrome(v,i,j,dp));
    }
}
