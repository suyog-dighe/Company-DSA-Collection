package Accenture_New_One;

public class FindLongestWord {
    public static String findword(String s){
        String[] word=s.split(" ");
        String longest="";
        for (String w:word){
            if (w.length()>longest.length()){
                longest=w;
            }
        }
        return longest;
    }
    public static void main(String[] args) {
        String s="this is amazing !";
        System.out.println(findword(s));
    }
}
