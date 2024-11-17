package Accenture;

// LCM     :-  Least Common Multiple
// HCF/GCD :-  Highest Common Factor / Greatest Common Divisor

public class LCM_HCF {

    //******** GCD/ HCF ****************
    public static int findGCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return findGCD(b, a % b);
    }
    public static int GCD2(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    //***********  LCM   *********
    public static int findGCDforLCM(int a, int b) {
        if (b == 0) {
            return a;
        }
        return findGCDforLCM(b, a % b);
    }

    public static int LCM(int a, int b) {
        return Math.abs(a * b) / findGCDforLCM(a, b);  // taking above reference
    }
    public static int findLCM(int a, int b) {
        int max = Math.max(a, b);
        int lcm = max;
        while (lcm % a != 0 || lcm % b != 0) {
            lcm += max;
        }
        return lcm;
    }
    public static void main(String[] args){
        int d=9;
        int v=66;
        System.out.println(findGCD(v,d));
        System.out.println(GCD2(v,d));
        System.out.println(findLCM(v,d));
        System.out.println(LCM(v,d));

    }
}
