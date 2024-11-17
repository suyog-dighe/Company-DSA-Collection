package Accenture_Coding;
/*
A googly prime number is defined as a number that is derived from
the sum of its individual digits. For example, if N = 43,
the sum of its individual digits is 4+3 = 7,
which is prime making it a googly prime number.
Your task is to find whether the current number is googly prime number or not.

Input: 43
Output: Yes

 */
public class SumIsprime {
    public static String sumOfNoisPrime(int n){
        int sum=0;
        if (n<=1){
            return "NO";
        }
        while (n>0){
            int d=n%10;
            sum+=d;
            n /=10;
        }
        if (isPrime(sum)){
            return "YES";
        }
        return "NO";
    }
    public static boolean isPrime(int n){
        if (n<=1){
            return false;
        }
        for (int i=2;i<=Math.sqrt(n);i++){
            if (n%i==0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int a=66;
        System.out.println(sumOfNoisPrime(a));

    }

}
