package Accenture;
import java.util.Scanner;

public class Find1stKwordOfString {
    public static String findstring(String s,int k){
        int n=s.length();
        int end=0;
        int count=0;
        for (int i=0;i<n;i++){
            if (s.charAt(i)==' '){
                count++;
                if (count==k){
                    return s.substring(0,i);
                }
            }
        }
        return "";
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String s= sc.nextLine();
        System.out.println("end string input");
        int k=sc.nextInt();
        System.out.println(findstring(s,k));
    }
}
