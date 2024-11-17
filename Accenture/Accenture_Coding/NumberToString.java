package Accenture_Coding;
public class NumberToString {
    public static String binaryToString(String  str){
        int n=str.length();
        int count=0;
        StringBuilder sb= new StringBuilder();
        for (int i=0;i<n;i++){
            if (str.charAt(i)=='1'){
                count++;
            }
            else {
                if (count>0){
                    sb.append((char)(64+count));
                    count=0;
                }
            }
        }
        if (count>0){
            sb.append((char)(64+count));
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        String s="110111111111111111111101111011111111111";
        System.out.println(binaryToString(s));

    }
}
