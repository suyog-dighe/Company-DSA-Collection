package Accenture_Coding;

import java.util.Arrays;

public class FindAbsoluteDiff {
    public static int[] findabs(int[]arr){
        int n=arr.length;
        int num[]= new int[n-1];
        for (int i=0;i<n-1;i++){
                num[i]=arr[i+1]-arr[i];
        }
        return num;
    }
    public static void main(String[] args) {
        int arr[]={5,3,8,6};
        System.out.println(Arrays.toString(findabs(arr)));

    }
}
