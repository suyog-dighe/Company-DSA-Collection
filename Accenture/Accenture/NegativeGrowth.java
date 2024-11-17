package Accenture;

public class NegativeGrowth {
    public static int countnegative(int[] arr){
        int n=arr.length;
        if (n<=1){
            return 0;
        }
        int count=0;
        for (int i=0;i<n-1;i++){
            if (arr[i]>arr[i+1]){
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[] arr={1,2,4,3,5,2};
        System.out.println(countnegative(arr));

    }
}
