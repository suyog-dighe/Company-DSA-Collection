package Accenture;
import java.util.Scanner;
public class ArmstrongNumber {
    public static boolean isarm(int n) {
        int ori = n;
        int sum = 0;
        int d = String.valueOf(n).length();
        while (n > 0) {
            int di = n % 10;
            sum += Math.pow(di, d);
            n /= 10;
        }
        return sum == ori;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (isarm(n)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
