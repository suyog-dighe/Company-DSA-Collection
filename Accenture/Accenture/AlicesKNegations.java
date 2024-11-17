package Accenture;
import java.util.*;

// Question :- Alice’s K Negations
// unstop :- https://unstop.com/courses/unstop-practice-interview-pep/accenture/accenture-coding-assessment-29619/question-29638

public class AlicesKNegations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        Arrays.sort(arr);
        // Apply the K operations
        for (int i = 0; i < n && k > 0; i++) {
            if (arr[i] < 0) {
                arr[i] = -arr[i];
                k--;
            }
        }
        // If there are remaining operations and k is odd, apply one more inversion
        if (k % 2 == 1) {
            Arrays.sort(arr); // Re-sort to get the smallest value
            arr[0] = -arr[0];
        }
        // Calculate the sum of the array
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        System.out.println(sum);
    }
}
