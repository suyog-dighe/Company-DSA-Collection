package Accenture_Coding;

public class ReverseString {
    public static String reverse(String s){
        return new StringBuilder(s).reverse().toString();
    }
    public static String reverseSentence(String s){
        return new StringBuilder(s).reverse().toString();
    }
    public static void main(String[] args) {
        String s="suyog";
        String d="Suyog Dighe";
        System.out.println(reverse(s));
        System.out.println(reverseSentence(d));
    }
}
