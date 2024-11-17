package Accenture_Ques_Paid;

public class LongestWordWithoutdot {
    public static  void longestword(String s){
        int n=s.length();
        String curr="";
        String longest="";
        for (int i=0;i<n;i++){
            char ch=s.charAt(i);
            if (ch !='.'){
                curr+=ch;
            }else{
                if (curr.length() > longest.length()){
                    longest=curr;

                }
                curr="";
            }

        }
        if (curr.length() > longest.length()){
            longest=curr;

        }
        System.out.println(longest);
        System.out.println(longest.length());
    }
    public static void findlongest(String s){
//        int n=s.length();
        String[] str=s.split("\\.");
        String  longest="";

        for (String ch:str){
            if (ch.length()>longest.length()){
                longest=ch;
            }
        }
        System.out.println(longest+"  "+longest.length());
    }
    public static void main(String[] args) {
        String s="suyog.dighe.college.sanjivani";
        longestword(s);
        findlongest(s);
    }
}
