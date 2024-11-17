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
            return 0;        }
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
    public static boolean isVowel(char s){
        return s=='a' || s=='e' || s=='o' ||s=='i' ||s=='u';
    }
    // Function to calculate permutations considering repeated consonants
    public static int findpermutation1(String s){
        Set<Character> vowel = new HashSet<>(Arrays.asList('A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u'));
        StringBuilder sb = new StringBuilder();
        // Collect consonants only
        for (char ch : s.toCharArray()) {
            if (!vowel.contains(ch)) {
                sb.append(ch);
            }
        }

        String consonants = sb.toString();
        int n = consonants.length();

        if (n == 0) {
            return 0; // No consonants to permute
        }

        // Step 1: Calculate factorial of total consonants
        int totalPermutations = findfactorial(n);

        // Step 2: Calculate frequency of each consonant
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char ch : consonants.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        // Step 3: Divide by factorial of frequencies of repeated consonants
        for (int freq : freqMap.values()) {
            totalPermutations /= findfactorial(freq);
        }

        return totalPermutations;
    }
    public static int find(String s){
        s=s.toLowerCase();
        String p="";
        for (int i=0;i<s.length();i++){
            char ch =s.charAt(i);
            if(!isVowel(ch)){
                p+=ch;
            }
        }
        int n=p.length();
        int total=findfactorial(n);

        HashMap<Character,Integer>mp= new HashMap<>();
        for (char ch:s.toCharArray()){
            mp.put(ch,mp.getOrDefault(ch,0)+1);
        }
        for (int count:mp.values()){
            if (count>1){
                total /=findfactorial(count);
            }
        }
        return total;
    }
    public static void main(String[] args) {
        String a="abbccde";
//        System.out.println(countpermutation(a));
//        System.out.println(findpermutation(a));
        System.out.println(findpermutation1(a));
        System.out.println(find(a));
    }
}
