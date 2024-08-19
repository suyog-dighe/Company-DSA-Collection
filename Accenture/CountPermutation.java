package Accenture;

import java.util.*;
public class CountPermutation {

    // First Approach :- Tc:-O(n) sc:- O(n)
    // using :- Identifying Consonants Directly and Calculating Permutations
    public static int countpermutation(String s){
        List<Character> cons= new ArrayList<>();
        Set<Character> vowels= new HashSet<>(Arrays.asList('A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u'));
        for (char ch: s.toCharArray()){
            if (!vowels.contains(ch)){
                cons.add(ch);
            }
        }
        if (cons.isEmpty()){
            return 0;
        }
        int n=cons.size();
        return findfactorial(n);
    }

    // Second Approach :- Tc:-O(n) sc:- O(n)
    // Using :- Removing Vowels and Calculating Permutations

    public static int findpermutation(String s){
        Set<Character> vowel= new HashSet<>(Arrays.asList('A','E','I','O','U','a','i','o','e','u'));
        StringBuilder sb= new StringBuilder();
        for (char ch: s.toCharArray()){
            if (!vowel.contains(ch)){
                sb.append(ch);
            }
        }
        int n=sb.length();
        if (n==0){
            return 0;
        }
        return findfactorial(n);
    }
    public static int findfactorial(int n){
        if (n==0 || n==1){
            return 1;
        }
        int fact=1;
        for (int i=2;i<=n;i++){
            fact *=i;
        }
        return fact;
    }
    public static void main(String[] args) {
        String a="suyog";
        System.out.println(countpermutation(a));
        System.out.println(findpermutation(a));
    }
}
