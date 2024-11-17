package Accenture_New_One;

import java.lang.reflect.Array;
import java.util.Arrays;

public class RefulingVehicles {
    public static void reful(int x,int []arr){
        int refuel=0;
            Arrays.sort(arr);
            int avail=0;
            for (int j=arr.length-1;j>=0;j--){
                avail+=arr[j];
                if (avail<x){
                    refuel++;
                    avail+=x;
                }
                avail-=x;
            }
        System.out.println(refuel);

    }
    public static void main(String[] args) {
        int n=4;
        int[]arr={80,120,90,70};
        reful(n,arr);

    }
}


