package Accenture_Ques_Paid;

public class ClimbingStairs {
    public static int climb(int n){
        int prev=1;
        int prev1=1;
        for (int i=2;i<=n;i++){
            int temp=prev+prev1;
            prev1=prev;
            prev=temp;
        }
        return prev;
    }
    public static void main(String[] args) {
        int n=5;
        System.out.println(climb(n));
    }
}
