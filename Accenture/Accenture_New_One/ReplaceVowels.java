package Accenture_New_One;

public class ReplaceVowels {
    public static String replaceVowels(String s,char p){
        String sp="";
        for (int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if (isVowels(ch)){
                sp+=p;
            }else{
                sp+=ch;
            }
        }
        return sp.toString();
    }
    //Replace specific character
    public static String replaceCharacter(String s, char c, char v){
        return s.replace(c,v);
    }
    public static boolean isVowels(char ch){
        ch=Character.toLowerCase(ch);

        return ch=='a' ||ch=='e'||ch=='i'||ch=='o'||ch=='u';
    }
    public static void main(String[] args) {
        String s="Suyog";
        char v='v';
        char d='u';
        System.out.println(replaceVowels(s,v));
        System.out.println(replaceCharacter(s,d,v));
    }
}
