package Accenture;
import java.util.Arrays;

public class AllZerosPlaceAtLast {
    // All zeros are place at last
    public static int[] placelast(int[] arr){
        int n=arr.length;
        int i=0,j=0,count=0;
        while(i<n) {
            if (arr[i] != 0) {
                arr[j] = arr[i];
                j++;
            } else {
                count++;
            }
            i++;
        }

           while(count>0){
               arr[j]=0;
               j++;
               count--;
           }
           return arr;
    }
     public static int[] placelast1(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        int j = 0;
        // Traverse the array and move non-zero elements to the front
        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                result[j++] = arr[i];
            }
        }
        // The rest of the array will be zeros (already initialized to zero)
        return result;
    }

    // All Negative Number are place to first    TC:- O(n)   &   SC :- O(n);
    public static int[] allNegativeFirst(int[]  arr){
        int n=arr.length;
        int num[]= new int[n];
        int idx=0;
        for (int i=0;i<n;i++){
            if (arr[i]<0){
                num[idx]=arr[i];
                idx++;
            }
        }
        for (int i=0;i<n;i++){
            if (arr[i]>=0){
                num[idx]=arr[i];
                idx++;
            }
        }
        return num;
    }

    // using swap and  TC:- O(n)   &   SC :- O(1);
    public static void negativeFirst(int[] arr) {
        int n = arr.length;
        int idx = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] < 0) {
                // Swap arr[i] with arr[idx]
                int temp = arr[i];
                arr[i] = arr[idx];
                arr[idx] = temp;
                idx++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr={1,2,0,4,3,0,5,0};
        int[] num={1,0,5,-8,-9,4,5,-7,6};
        System.out.println(Arrays.toString(placelast1(arr)));
        System.out.println(Arrays.toString(allNegativeFirst(num)));

    }
}
