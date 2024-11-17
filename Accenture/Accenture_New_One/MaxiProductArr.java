package Accenture_New_One;

import java.util.Arrays;

public class MaxiProductArr {
    public static void maxi(int[]arr){
        int n=arr.length;
        int ans=0;
        int res=0;
        Arrays.sort(arr);
       for (int num:arr){
           System.out.print(num+" ");
       }
        System.out.println();
        ans=arr[n-1]*arr[n-2]*arr[n-3];
       res=arr[0]*arr[1]*arr[n-1];
       if (ans>res){
           System.out.println(ans);
       }
       else{
           System.out.println(res);
       }

    }
    public static void main(String[] args) {
        int [] arr={-10,10,3,1,-10,-10,3,2,-1,};
        maxi(arr);
    }
}
