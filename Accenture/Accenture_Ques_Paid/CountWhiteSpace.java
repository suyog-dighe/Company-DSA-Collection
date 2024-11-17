package Accenture_Ques_Paid;
import java.util.Scanner;

public class CountWhiteSpace {
    public static int countSpace(String s){
        int count=0;
        for (char ch:s.toCharArray()) {
            if (Character.isWhitespace(ch)) {
                count++;
            }
        }
        return count;
    }
    public static void space(String s,String v){
        int s1=countSpace(s);
        int s2=countSpace(v);
        System.out.println(s1);
        System.out.println(s2);
        int dff=Math.abs(s1-s2);
        if (dff%2==0){
            System.out.println("Even");
        }
        else {
            System.out.println("Odd");
        }
    }
    public static String removeWhiteSpaces(String s) {
        // Using replaceAll() to replace all whitespaces with an empty string
        return s.replaceAll("\\s+", "");
    }
    public static void main(String[] args) {
//        String s="suyog dighe it is in accenture";
//        String v="also he take the another opportunity to grow up";
        Scanner sc= new Scanner(System.in);
        String s=sc.nextLine();
        System.out.println("Enter 2nd string :");
        String v=sc.nextLine();
        space(s,v);
        System.out.println(removeWhiteSpaces(s));
    }
}
