package Juspay.juspay;

import java.util.*;
public class NearestMeetingCell {
    /*
    //***********  Using BFS     **********

    public static int solution(int[] arr, int cell1, int cell2) {
        int n = arr.length;
        int[] dist1 = bfs(arr, cell1, n);
        int[] dist2 = bfs(arr, cell2, n);

        int minDist = Integer.MAX_VALUE;
        int meetingCell = -1;

        for (int i = 0; i < n; i++) {
            if (dist1[i] != -1 && dist2[i] != -1) {
                int maxDist = Math.max(dist1[i], dist2[i]);
                if (maxDist < minDist) {
                    minDist = maxDist;
                    meetingCell = i;
                }
            }
        }

        return meetingCell;
    }

    private static int[] bfs(int[] arr, int start, int n) {
        int[] dist = new int[n];
        Arrays.fill(dist, -1);
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        dist[start] = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            int nextNode = arr[node];
            if (nextNode != -1 && dist[nextNode] == -1) {
                dist[nextNode] = dist[node] + 1;
                queue.add(nextNode);
            }
        }

        return dist;
    }
    */


    // ************    Using DFS   ***************
    public static int nearestMeetingCell(int[] arr, int cell1, int cell2) {
    int n = arr.length;
    int[] dist1 = new int[n];
    int[] dist2 = new int[n];
    Arrays.fill(dist1, -1);
    Arrays.fill(dist2, -1);
// tc O(n) sc O(n)
    dfs(arr, cell1, dist1, 0);
    dfs(arr, cell2, dist2, 0);

    int minDist = Integer.MAX_VALUE;
    int meetingCell = -1;

    for (int i = 0; i < n; i++) {
        if (dist1[i] != -1 && dist2[i] != -1) {
            int maxDist = Math.max(dist1[i], dist2[i]);
            if (maxDist < minDist) {
                minDist = maxDist;
                meetingCell = i;
            }
        }
    }

    return meetingCell;
    }
    private static void dfs(int[] arr, int start, int[] dist, int currentDist) {
        if (dist[start] != -1) {
            return;
        }
        dist[start] = currentDist;
        int nextNode = arr[start];
        if (nextNode != -1) {
            dfs(arr, nextNode, dist, currentDist + 1);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for (int i = 0; i < test; i++) {
            int numofBlocks = sc.nextInt();
            int[] array = new int[numofBlocks];
            for (int j = 0; j < numofBlocks; j++) {
                array[j] = sc.nextInt();
            }
            int cell1 = sc.nextInt();
            int cell2 = sc.nextInt();
            System.out.println(nearestMeetingCell(array, cell1, cell2));
        }
        sc.close();
    }
}
/*
Input:
    1
    10
    -1 0 0 1 1 3 3 4 4 5
    3
    4

Output:  1


 */