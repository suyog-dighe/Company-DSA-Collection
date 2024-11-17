package Accenture_New_One;
import java.util.Locale;
public class SurroundByConsonent {
    public static boolean isVowel(char  s){
        s= Character.toLowerCase(s);
       return s=='a' ||s=='e'|| s=='i' ||s=='o' ||s=='u';
    }
    public static boolean isConsonent(char ch){
        return Character.isLetter(ch) && !isVowel(ch);
    }
    public static void surroundConsonent(String s){
        StringBuilder sb= new StringBuilder();
        for (int i=0;i<s.length();i++){
            char ch=s.charAt(i);

            if ( i > 0 && i < s.length() - 1 && isVowel(ch)){
                char bef=s.charAt(i-1);
                char af=s.charAt(i+1);

                if (isConsonent(bef) && isConsonent(af)){
//                    System.out.println(ch);
                    continue;
                }

//                sb.append(ch);
            }
            sb.append(ch);
        }
        System.out.println(sb.toString());
    }
    public static void main(String[] args) {
        String s="banana";
        surroundConsonent(s);
    }
}
