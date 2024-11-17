package Accenture;
import java.util.*;

/*
You are provided Two Strings S1 And S2. In S1, you can perform operation
such as adding, removing or swapping letters. Each Operation has a specific
 Cost value Associated with it, as shown below.

• If a letter is removed from S1, the cost is 0.
• If a pair of letters are swapped in S1 the cost is 0.
- a new letter is added to the end of S1 then cost is 1.

Your task is to find and return an integer value representing the minimum cost required
 to transform string s1 to s2.
 Note: S1 and S2 contains only Uppercase english letters
Input 1:
S1-ABD
S2-AABCCAD
Output: 4
 */
public class MinCostToTransform {
    public static int mincost(String s1,String s2){
        Map<Character,Integer> mp1=new HashMap<>();
        Map<Character,Integer> mp2= new HashMap<>();

        //for s1 string count all frequency
        for (char c: s1.toCharArray()){
            mp1.put(c,mp1.getOrDefault(c,0)+1);
        }
        //for s2 string count all character frquency
        for (char c: s2.toCharArray()){
            mp2.put(c,mp2.getOrDefault(c,0)+1);
        }
        int cost=0;
        for (char c: mp2.keySet()){
            int need=mp2.get(c);
            int avail=mp1.getOrDefault(c,0);
            // remove the available character in mp1 to the needed character
            if (need>avail){
                cost += need - avail;
            }
        }
        return cost;
    }
    public static void main(String[] args) {
        String s1="ABC";
        String s2="AABCCAD";
        System.out.println(mincost(s1,s2));
    }
}
