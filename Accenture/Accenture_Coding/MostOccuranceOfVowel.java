package Accenture_Coding;
import java.util.*;
public class MostOccuranceOfVowel {
    public static Map<Character,Integer> mostoccurVowel(String s){
        Map<Character,Integer> map= new HashMap<>();
        s=s.toLowerCase();
        for (char ch:s.toCharArray()){
            if (ch=='a'|| ch=='e'|| ch=='i'||ch=='o'||ch=='u'){
                map.put(ch,map.getOrDefault(ch,0)+1);
            }
        }
        return map;
    }
    public static char findVowel(Map<Character,Integer> map){
        int count=0;
        char ans='\0';
        for (char v:map.keySet()){
            if (map.get(v)>count){
                count=map.get(v);
                ans=v;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        String s="aniketdighe";
        Map<Character, Integer> vowelCount = mostoccurVowel(s);
        char count=findVowel(vowelCount);
        System.out.println(count);

    }
}
