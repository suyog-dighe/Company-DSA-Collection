package Accenture;

//   changes needed
import java.util.Scanner;
public class FindRevenue {
    public static int findRevenueRecievd(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int num : arr) {
            if (max < num) {
                max = num;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < m; i++) {
            int max = findRevenueRecievd(arr[i]);
            System.out.print(max + " ");
        }
    }
}
