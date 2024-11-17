package Accenture_Ques_Paid;

public class SecondMin {
    public static int minimum(int[]arr){
        int n=arr.length;
        int min=Integer.MAX_VALUE;
        int min1=Integer.MAX_VALUE;
        for (int i=0;i<n;i++){
            if (arr[i]<min) {
                min1 = min;
                min = arr[i];

            } else if(arr[i]<min1){
                min1=arr[i];
            }
        }
        return min1;
    }
    public static void main(String[] args) {
        int[] arr={5,2,6,7,8,3,9,1};
        System.out.println(minimum(arr));
    }
}
