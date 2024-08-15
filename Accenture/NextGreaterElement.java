package Accenture;

import java.lang.reflect.Array;
import java.util.Arrays;

/*

Next Greater Element

Given an array of integers arr, for each element in the array,
find the next greater element. The next greater element for an
element x is the first greater element on the right side of x in the array.
If there is no greater element for x, then the next greater element for x is -1.

Write a function greaterelement that takes an array of integers arr and returns
an array of integers num such that num[i] contains the next greater element for arr[i].
If there is no greater element, num[i] should be -1.
 */
public class NextGreaterElement {
    public static int[] greaterelement(int[]arr){
        int n=arr.length;
        int num[]=new int[n];
        for (int i=0;i<n;i++){
            num[i] = -1;
            for (int j=i+1;j<n;j++){
                if (arr[j]>arr[i]){
                    num[i]=arr[j];
                    break;
                }
            }
        }
        return num;
    }
    /*
     public static int[] greaterelement(int[] arr) {
        int n = arr.length;
        int[] num = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }
            num[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(arr[i]);
        }
        return num;
    }
     */
    public static void main(String[] args) {
//        int[] arr= {4,5,2,25};
        int[] arr={5,7,1,7,6,0};

        System.out.println(Arrays.toString(greaterelement(arr)));

    }
}
