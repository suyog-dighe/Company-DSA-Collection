package Accenture_Ques_Paid;

public class HalloweenCandy {
    // Function to find the maximum element in an array
    public static int findMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    public static int solve(int n, int[] candy, int h) {
        int low = 1;
        int high = findMax(candy);
        int c = 0;

        while (low <= high) {
            int mid = low+(high-low)/2;
            int rh = 0;

            for (int i = 0; i < n; i++) {
                rh += candy[i] / mid + (candy[i] % mid != 0 ? 1 : 0);
            }

            if (rh > h) {
                low = mid + 1;
            } else {
                c = mid;
                high = mid - 1;
            }
        }
        return c;
    }
    public static void main(String[] args) {
        int[] arr={4,9,11,17};
        int h=8;
        System.out.println(solve(arr.length,arr,h));

    }
}
