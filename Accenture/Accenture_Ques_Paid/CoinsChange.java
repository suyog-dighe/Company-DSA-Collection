package Accenture_Ques_Paid;

import java.util.Arrays;

public class CoinsChange {
    public static void sort(int[] arr,int start,int end){
        while (start<end){
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
    }
    public static int countCoins(int[] arr,int amount){
        int n=arr.length;
        int count=0;
        Arrays.sort(arr);
        sort(arr,0,n-1);
        for (int i=0;i<n;i++){
            if (arr[i]<=amount){
                while (arr[i]<=amount){
                    count++;
                    amount-=arr[i];
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[] arr={1,5,2};
        int a=11;
        System.out.println(countCoins(arr,a));
    }
}
