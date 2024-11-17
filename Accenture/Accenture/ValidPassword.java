package Accenture;


public class ValidPassword {
    public static boolean checkpassword(String str){
        int n=str.length();
        int cap=0;
        int no=0;
        if (n<4){
            return false;
        }
        if(Character.isDigit(str.charAt(0))){
            return false;
        }
        for (int i=0;i<n-1;i++){
            char ch=str.charAt(i);
            if (ch==' ' || ch=='/'){
                return false;
            }
            if (Character.isUpperCase(ch)){
                cap++;
            }
            if(Character.isDigit(ch)){
                no++;
            }
        }
        if (cap>0 && no>0){
           return true;
        }
       return false;
    }
    public static void main(String[] args) {
        String s="Suyog125";
        System.out.println(checkpassword(s));
    }
}
