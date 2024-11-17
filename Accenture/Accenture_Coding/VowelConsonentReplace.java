package Accenture_Coding;

public class VowelConsonentReplace {
    public static String replace(String s,char s1, char s2){
        StringBuilder sb= new StringBuilder(s);
        for (int i=0;i<sb.length();i++){
            if (s.charAt(i)==s1){
                sb.setCharAt(i,s2);
            }else if (s.charAt(i)==s2){
               sb.setCharAt(i,s1);
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        String s="sanjivani";
        char s1='a';
        char s2='s';
        System.out.println(replace(s,s1,s2));
    }
}
