package Accenture_Ques_Paid;

import java.util.Arrays;

public class RotateArrayNTime {
    public static void rotate(int[] arr, int v){
        int len=arr.length;
        v=v%len;
        reverse(arr,0,len-1);
        reverse(arr,0,v-1);
        reverse(arr,v,len-1);
    }
    public static void reverse(int[]arr,int start,int end){
        while (start < end){
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5}; // Example array
        int n = 2;                  // Number of rotations

        rotate(arr, n);        // Rotate the array n times
        System.out.println(Arrays.toString(arr));

    }
}
