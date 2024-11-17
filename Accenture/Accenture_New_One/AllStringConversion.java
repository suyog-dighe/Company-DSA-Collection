package Accenture_New_One;

import java.util.Scanner;

public class AllStringConversion {
    public static void stringToAscii(String s){
        int p=s.length();
        for (int i=0;i<p;i++){
            int ch=(int)s.charAt(i);
            System.out.print(ch+" ");
        }
        System.out.println();
    }

    public static void asciiToChar(int[] ascii){
        for (int num:ascii){
            char ch=(char)num;
            System.out.print(ch+" ");
        }
        System.out.println();
    }
    public static void asciiToString(int[] arr){
        StringBuilder sb= new StringBuilder();
        for (int num:arr){
            char ch=(char)num;
            sb.append(ch);
        }
        System.out.println(sb.toString());
    }
    public static void asciiToInteger(int[] arr){
        for (int num:arr){
            int digit=num-'0';
            System.out.print(digit+" ");
        }
        System.out.println();
    }
    public static void integerToAscii(int[]arr){
        for (int num:arr){
            int digit=num+'0';
//            char as=(char)(num+'0');
            System.out.print(digit+" ");
        }
        System.out.println();
    }
    public static void convert(String  s){
        for (int i=0;i<s.length();i++){
            int num=s.charAt(i)-'0';
            System.out.print(num+" ");
        }
        System.out.println();
    }
    public static void numberToBin(int[]arr){
        for (int num:arr){
            System.out.print(Integer.toBinaryString(num)+" ");
        }
        System.out.println();
    }

    public static void bintoNum(int n){
        String s=String.valueOf(n);
        System.out.println(s);
        int num=Integer.parseInt(s,2);
        System.out.println(num);

    }
    public static void main(String[] args) {
        String s="SUYOG";
        String p="10110";
//        Scanner sc= new Scanner(System.in);
//        String v=sc.nextLine();

        int[] arr={115 ,117, 121 ,111 ,103};
        int[]num={54,55,57,58,59,60,63};
        int[] num2={6,7,9,10,11,12,15};
        int n=1001;
        bintoNum(n);
        stringToAscii(s);
        asciiToChar(arr);
        asciiToString(arr);
        asciiToInteger(num);
        integerToAscii(num2);
        numberToBin(num2);
        convert(p);
//        convert(v);
    }
}
