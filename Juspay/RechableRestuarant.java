package Juspay;
import java.util.*;

public class RechableRestuarant {
    public static void main(String[] args) {
        int x = 4;
        int y = 1;
        int[] costs = {0, 1, 0, 2};
        int[][] edges = {{1, 2}, {1, 3}, {1, 4}};

        // make the list
        List<Integer>[] list = new ArrayList[x + 1];
        for (int i = 0; i <= x; i++) {
            list[i] = new ArrayList<>();
        }
        //store the pair of integer to in list
        for (int[] edge : edges) {
            list[edge[0]].add(edge[1]);
//            list[edge[1]].add(edge[0]);
        }

        boolean[] visited = new boolean[x + 1];
        int count = countrestaurant(1, 0, y, costs, list, visited);

        System.out.println(count);
    }

    static int countrestaurant(int node, int currCost, int maxCost, int[] costs, List<Integer>[] list, boolean[] visited) {
        visited[node] = true;
        currCost += costs[node - 1];

        if (currCost > maxCost) return 0;
        boolean isLeaf = true;
        int count = 0;

        for (int child : list[node]) {
            if (!visited[child]) {
                isLeaf = false;
                count += countrestaurant(child, currCost, maxCost, costs, list, visited);
            }
        }

        if (isLeaf) {
            return 1;
        } else {
            return count;
        }
    }
}
