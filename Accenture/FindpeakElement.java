package Accenture;

public class FindpeakElement {
    public static int findpeak(int[] arr){
        int n=arr.length;
        if (n<0){
            return -1;
        }
        if (n==1){
            return arr[0];
        }
        if (arr[0]>arr[1]) {
            return arr[1];
        }
        if (arr[n-1]>arr[n-2]) {
            return arr[n - 1];
        }
        for (int i=1;i<n-1;i++){
            if (arr[i]>arr[i+1]){
                return arr[i];
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[]arr= {1,2,3,5,6,9,8,7,6,4,2};
        System.out.println(findpeak(arr));
    }
}
