package Accenture_Ques_Paid;

public class ReverseArraySum {
    public static void sumAray(int[] arr){
        int n=arr.length;
        int sum=0;
        int sum2=0;
        for (int i=0;i<n;i++){
            int rdx=n-i-1;
            if (i%2!=0){
                sum2+=arr[i];
            }
            if (rdx%2==0){
                sum+=arr[i];
            }
        }
        System.out.println(sum);
        System.out.println(sum2);
    }
    public static void main(String[] args) {
        int[] arr={1,4,2,5,6,3,8,3};
        sumAray(arr);
    }
}
