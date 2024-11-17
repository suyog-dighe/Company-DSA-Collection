package Accenture_Coding;

import java.util.Arrays;

public class Max_Candies_Buy {
    public static int maxcandies(int [] arr,int m){
        int count=0;
        for (int i=0;i<arr.length;i++){
            if (arr[i]%5==0){
                count++;
            }else {
                if (arr[i]<=m){
                    count++;
                    m=m-arr[i];
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int arr[]={5,10,6,8,4,3,2,20};
        Arrays.sort(arr);
        int m=10;
        System.out.println(maxcandies(arr,m));

    }
}
