package Juspay;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class LargestSumCycle {
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
    /*

    //For to return the Unique Cycle count answer is : 6

     public static int solution(int[] Edge){
        int cycleCount = 0;
        boolean[] visited = new boolean[Edge.length];
        boolean[] inStack = new boolean[Edge.length];

        for (int i = 0; i < Edge.length; i++) {
            if (!visited[i]) {
                if (detectCycle(Edge, i, visited, inStack)) {
                    cycleCount++;
                }
            }
        }
        return cycleCount == 0 ? -1 : cycleCount;
    }

    private static boolean detectCycle(int[] Edge, int start, boolean[] visited, boolean[] inStack) {
        int current = start;
        ArrayList<Integer> path = new ArrayList<>();

        while (current != -1 && current < Edge.length) {
            if (inStack[current]) {
                return true;
            }
            if (visited[current]) {
                return false;
            }
            visited[current] = true;
            inStack[current] = true;
            path.add(current);
            current = Edge[current];
        }

        for (int node : path) {
            inStack[node] = false;
        }

        return false;
    }

     */


    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int test=sc.nextInt();
        for (int i=0;i<test;i++){
            int numofBlocks=sc.nextInt();
            int Edge[]=new int[numofBlocks];
            for (int j=0;j<numofBlocks;j++){
                Edge[j]=sc.nextInt();
            }
            System.out.println(largestSum(Edge));
        }
    }
}

/*
Input :
    1
    23
    4 4 1 4 13 8 8 8 0 8 14 9 15 11 -1 10 15 22 22 22 22 22 21

Output:  45

 */
