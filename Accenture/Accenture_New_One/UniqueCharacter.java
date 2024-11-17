package Accenture_New_One;

import java.util.HashMap;

public class UniqueCharacter {
    public static char uniqueChar(String s){
        HashMap<Character,Integer> mp= new HashMap<>();
        for (char ch:s.toCharArray()){
            mp.put(ch,mp.getOrDefault(ch,0)+1);
        }
        for (char ch:s.toCharArray()){
            if (mp.get(ch)==1){
                return ch;
            }
        }
        return '.';
    }
    public static void main(String[] args) {
        String  s="sanjivani college so";
        System.out.println(uniqueChar(s));
    }
}
