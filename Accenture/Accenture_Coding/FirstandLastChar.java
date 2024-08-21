package Accenture_Coding;
import java.util.Scanner;

public class FirstandLastChar {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
//        String s=sc.nextLine();

        String first= sc.next();
        String last=sc.next();
        System.out.println(first.toLowerCase()+" "+last.toUpperCase());

//        System.out.println(s);
//        char ch=s.charAt(0);
//        char ch2=s.charAt(s.length()-1);
//        System.out.println(ch+" "+ch2);
    }
}
