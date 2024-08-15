package Accenture;
import java.util.HashMap;

// Question 1. Count Frequency of String
//QUestion 2. return Maximum Frequency Character or Frequency Number

public class CountStringFrequency {
    public static HashMap<Character,Integer> count(String s){
        HashMap<Character,Integer> map= new HashMap<>();
        for (char c: s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        return map;
    }
    public static char maximum(HashMap<Character, Integer> map) {
        char maxChar = '\0';
        int maxCount = 0;
        for (char c : map.keySet()) {
            if (map.get(c) > maxCount) {
                maxChar = c;
                maxCount = map.get(c);
            }
        }

        /*
        //  Return Maximum Frequency Character,
         //if more than one character are same frequency then return all character

        HashSet<Character> maxChars = new HashSet<>();
        int maxCount = 0;
        for (char c : frequencyMap.keySet()) {
            int count = frequencyMap.get(c);
            if (count > maxCount) {
                maxChars.clear();
                maxChars.add(c);
                maxCount = count;
            } else if (count == maxCount) {
                maxChars.add(c);
            }
        }
         */
        return maxChar;
    }
    public static void main(String[] args) {
        String str = "Sanjivani";
        HashMap<Character, Integer> map = count(str);
        for (char c : map.keySet()) {
            System.out.println(c + ": " + map.get(c));
        }
        System.out.println(maximum(map));
    }
}
