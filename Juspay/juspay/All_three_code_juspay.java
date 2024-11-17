package Juspay.juspay;

import java.util.Arrays;
import java.util.Scanner;

public class All_three_code_juspay {

    // 1st code
    static long res=0;
    public static long largestSum(int Edge[]){

        boolean[] visited=new boolean[Edge.length];
        boolean[] pathvisited=new boolean[Edge.length];
        for(int i=0;i<Edge.length;i++)
        {
            if(!visited[i])
            {
                dfs2(i,Edge,visited,pathvisited);
            }
        }
        return res;
    }
    public  static void dfs2(int i,int[] Edge,boolean[] vis,boolean[] pathvisited)
    {
        vis[i]=true;
        pathvisited[i]=true;
        if(Edge[i]!=-1)
        {
            int adj=Edge[i];
            if(!vis[adj])
            {
                dfs2(adj,Edge,vis,pathvisited);
            }
            else if(pathvisited[adj])
            {
                int curr=adj;
                long s=0;
                do{
                    s+=curr;
                    curr=Edge[curr];
                }while(curr!=adj);
                res=Math.max(res,s);
            }
        }
        pathvisited[i]=false;
    }

    //2nd code
    public static int maxWeightCell(int N, int Edge[]) {
        int[] weights = new int[N];
        calcWeights(Edge, weights);

        int maxWeight = -1;
        int maxIndex = -1;

        for (int i = 0; i < N; i++) {
            if (weights[i] > maxWeight || (weights[i] == maxWeight && i > maxIndex)) {
                maxWeight = weights[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public static void calcWeights(int[] Edge, int[] weights) {
        for (int i = 0; i < Edge.length; i++) {
            int v = Edge[i];
            if (v != -1) {
                weights[v] += i; // Accumulate the weight
            }
        }
    }

    //3rd code

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


}
