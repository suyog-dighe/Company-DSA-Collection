package Accenture;

//level :- Easy
//Question :- SUm of All the odd Integer

public class SumOddInteger {
    public static int sumodd(int[] arr){
        int n=arr.length;
        int sum=0;
        for(int i=0;i<n;i++){
            if(arr[i] %2!=0){
                sum+=arr[i];
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        int arr[]={1,5,2,4,8,6,9,7};
        System.out.println(sumodd(arr));

    }
}
