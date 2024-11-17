package Juspay.juspay;
import java.util.*;

public class New_Maximum_Weight_Node {
    public static int maxWeightCell(int N, List<Integer> Edge) {
        if (N == 0 || Edge == null || Edge.isEmpty()) {
            return -1; // Handle empty input
        }

        int maxIndex = -1;
        int maxIndegree = 0; // Start with 0 since indegrees can't be negative

        // Create an array to count in-degrees
        int[] indegree = new int[N];

        // Count in-degrees
        for (int i = 0; i < N; i++) {
            int v = Edge.get(i);
            if (v != -1 && v < N) {
                indegree[v]++; // Increment in-degree
            }
        }

        // Find the node with the highest in-degree
        for (int i = 0; i < N; i++) {
            if (indegree[i] > maxIndegree || (indegree[i] == maxIndegree && i > maxIndex)) {
                maxIndegree = indegree[i];
                maxIndex = i;
            }
        }

        // If no valid in-degree nodes were found, return -1
        return maxIndegree == 0 ? -1 : maxIndex;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int N = sc.nextInt();

        List<Integer> Edge = new ArrayList<>();
        System.out.println("Enter the elements of the list:");
        for (int i = 0; i < N; i++) {
            Edge.add(sc.nextInt());
        }

        int result = maxWeightCell(N, Edge);
        System.out.println(result);
    }
}
