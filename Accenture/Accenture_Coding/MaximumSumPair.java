package Accenture_Coding;

public class MaximumSumPair {

    public static int maximum(int [] arr){
        int sum=0;
        int n=arr.length;
        for (int i=0;i<n;i++){
            for (int j=i+1;j<n;j++){
                sum =Math.max(sum,arr[i]+arr[j]);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] num={1,10,5,15};
        System.out.println(maximum(num));
    }
}
