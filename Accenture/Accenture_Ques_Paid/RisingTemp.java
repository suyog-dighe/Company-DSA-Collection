package Accenture_Ques_Paid;

public class RisingTemp {
    public static int totalcount(int[] arr){
        int n=arr.length;
        int count=0;
        int max=0;
        for (int i=1;i<n;i++){
            if (arr[i]<arr[i-1]){
                count++;
            }else {
                max=Math.max(count,max);
                count=0;
            }
        }
        max=Math.max(count,max);
        return max;
    }
    public static void main(String[] args) {
        int[] arr={0,6,0,-1,-2,-3,4,5,9};
        int[] arr1={2,3,2,1,0,-1,-2};
        System.out.println(totalcount(arr));
        System.out.println(totalcount(arr1));
    }
}
