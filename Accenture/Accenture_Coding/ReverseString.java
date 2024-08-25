package Accenture_Coding;

public class ReverseString {
    public static String reverse(String s){
        return new StringBuilder(s).reverse().toString();
    }
    public static String reverseSentence(String s){
        return new StringBuilder(s).reverse().toString();
    }
    public static String reverseSent(String s){
        StringBuilder sb= new StringBuilder();
        String str[]= s.split(" ");
        for (int i=str.length-1;i>=0;i--){
            sb.append(str[i]+" ");
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        String s="suyog";
        String d="Suyog Dighe";
        String a="sanjivani college of engineering kopargaon";
        System.out.println(reverse(s));
        System.out.println(reverseSentence(d));
        System.out.println(reverseSent(a));
        System.out.println(reverseSentence(a));
    }
}
