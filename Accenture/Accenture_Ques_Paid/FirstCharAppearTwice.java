package Accenture_Ques_Paid;
import java.util.*;
public class FirstCharAppearTwice {
    public static void appearchar(String s){
        HashSet<Character>set=new HashSet<>();
       for (char ch:s.toCharArray()){
           if (set.contains(ch)){
               System.out.println(ch);
               return;
           }
           set.add(ch);
       }
    }
    public static void main(String[] args) {
        String  s="abcdefghklmnd";
        appearchar(s);
    }
}
