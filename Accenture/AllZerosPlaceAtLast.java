package Accenture;
import java.util.Arrays;

public class AllZerosPlaceAtLast {
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

    public static void main(String[] args) {
        int[] arr={1,2,0,4,3,0,5,0};
        System.out.println(Arrays.toString(placelast1(arr)));

    }
}
