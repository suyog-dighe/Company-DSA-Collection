package Accenture_Ques_Paid;
import java.util.Arrays;
public class Rearrange_Array {
    public static int[] rearrange(int[] arr){
        int n=arr.length;
        int left=0;
        int right=n-1;
        while (left<=right){
            if (arr[left]<0){
                left++;
            }
            else if (arr[right] >0){
                right--;
            }
            else {
                int temp=arr[left];
                arr[left]=arr[right];
                arr[right]=temp;
                left++;
                right--;
            }
        }
        return arr;
    }

    //using for loop
    public static int[] reverse(int num[]) {
        int n = num.length;
        int[] arr = new int[n];

        int left=0;
        for (int i=0;i<n;i++){
            if (num[i]<0){
                arr[left++]=num[i];
//                left++;
            }
        }
        for (int i=0;i<n;i++){
            if (num[i]>=0){
                arr[left++]=num[i];
            }
        }
        return arr;
    }


    public static void main(String[] args) {
        int[] arr={1,7,-5,9,-1,2,15};
        System.out.println(Arrays.toString(reverse(arr)));
//        System.out.println(Arrays.toString(rearrange(arr)));


    }
}
