package Accenture;


public class ValidPassword {
    public static boolean checkpassword(String str){
        int n=str.length();
        int cap=0;
        int no=0;
        if (n<4){
            return false;
        }
        if(str.charAt(0)-'0'>=0 && str.charAt(0)-'0'<=9){
            return false;
        }
        for (int i=0;i<n-1;i++){
            if (str.charAt(i)==' ' || str.charAt(i)=='/'){
                return false;
            }
            if (str.charAt(i)>='A' && str.charAt(i)<='Z'){
                cap++;
            }
            if(str.charAt(i)-'0'>=0 && str.charAt(i)-'0'<=9){
                no++;
            }
        }
        if (cap>0 && no>0){
           return true;
        }
       return false;
    }
    public static void main(String[] args) {
        String s="SUYOG 125";
        System.out.println(checkpassword(s));
    }
}
