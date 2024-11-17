package Accenture_Ques_Paid;

public class AddBinaryString {
    public static void addbinary(String s, String b){
        int i=s.length()-1;
        int j=b.length()-1;
        int carry=0;
        StringBuilder sb= new StringBuilder();
        while (i>=0 || j>=0 || carry>0){
            int bit1=(i>=0)?s.charAt(i)-'0':0;
            int bit2=(j>=0)?b.charAt(i)-'0':0;

            int sum=bit1+bit2+carry;
            sb.append(sum%2);
            carry=sum/2;
            i--;
            j--;
        }
        System.out.println(sb.reverse().toString());
    }
    public static void main(String[] args) {
        String s="1010";
        String b="1101";
        addbinary(s,b);
    }
}
