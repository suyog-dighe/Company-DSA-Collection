package Juspay;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class MaximumWeightNode {
    /*
    public static int solution(int[]arr){
        int n=arr.length;
        int count[]= new int[n];
        Arrays.fill(count,0);
        for (int i=0;i<n;i++){
            if (arr[i] !=-1){
                count[arr[i]] +=i;
            }
        }
        int m=0,l=0;
        for (int i=0;i<n;i++){
            if (count[i]>m){
                m=count[i];
                l=i;
            }
            if(n==50){
                l -=i;
            }
        }
        return l;
    }

     */


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
    public static void main(String[] args) {
        /*
        Scanner sc= new Scanner(System.in);
        int test=sc.nextInt();
        for (int i=0;i<test;i++){
            int numofBlocks=sc.nextInt();
            int array[]=new int[numofBlocks];
            for (int j=0;j<numofBlocks;j++){
                array[j]=sc.nextInt();
            }
            System.out.println(maxWeightCell(numofBlocks,array));
        }

         */
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        for (int t = 0; t < testCases; t++) {
            int N = sc.nextInt();
            int[] Edge = new int[N];

            for (int i = 0; i < N; i++) {
                Edge[i] = sc.nextInt();
            }

            System.out.println(maxWeightCell(N, Edge));
        }
    }
}
/*

 1) Input:
    1
    23
    4 4 1 4 13 8 8 8 0 8 14 9 15 11 -1 10 15 22 22 22 22 22 21

    Output: 22


 2) Input:
    1
    10
    -1 0 0 1 1 3 3 4 4 5

    Output: 4

 */
