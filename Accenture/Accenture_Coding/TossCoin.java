package Accenture_Coding;

public class TossCoin {
    public static int findscore(String s){
        int n=s.length();
        int total=0;
        int count=0;
        for (int i=0;i<n;i++){
            char ch=s.charAt(i);
            if (ch=='H'){
                count++;
                total +=2;
            }else {
                count=0;
                total -=1;
            }
            if (count ==3){
                return total;
            }
        }
        return total;
    }
    public static void main(String[] args) {
        String s="TTHHHTTTT";
        System.out.println(findscore(s));
    }
}
