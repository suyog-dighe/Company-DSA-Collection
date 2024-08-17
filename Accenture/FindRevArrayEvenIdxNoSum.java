package Accenture;

public class FindRevArrayEvenIdxNoSum {
    public static void reverseArray(int[] arr){
        int left=0;
        int right=arr.length-1;
        while (left<right){
            int temp=arr[left];
            arr[left]=arr[right];
            arr[right]=temp;
            left++;
            right--;
        }
    }
    public static int findEvenIndexNumberSum(int[] arr){
        reverseArray(arr);
        int n=arr.length;
        int sum=0;
        for (int i=0;i<n;i++){
            if (i%2==0){
                sum +=arr[i];
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        int arr[]= {6,5,4,3,2,1};
        System.out.println(findEvenIndexNumberSum(arr));
    }
}
