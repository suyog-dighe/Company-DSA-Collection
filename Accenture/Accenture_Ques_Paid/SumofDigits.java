package Accenture_Ques_Paid;

public class SumofDigits {
    public static int sumofdigit(int n){
        int sum=0;
        while (n>0){
            sum +=n%10;
            n /=10;
        }
        return sum;
    }
    public static int digitsum(int arr[],int m){
        int n=arr.length;
        int sum=0;
        int sumele=0;
//        for (int i=0;i<n;i++){
//            sumele+=arr[i];
//            int b=sumofdigit(arr[i]);
//            sum +=b;
//        }
//
//        int f1=sum%m;
//        int f2=sumele%m;
//        return f1-f2;

        for (int num:arr){
            sumele +=num;
            while (num>0){
                sum +=num%10;
                num /=10;
            }
        }
        return (sum%m)-(sumele%m);
    }
    public static void main(String[] args) {
    int [] arr= {11,14,16,10,9,8,24,5,4,3};
    int n=10;
        System.out.println(digitsum(arr,n));
    }
}
