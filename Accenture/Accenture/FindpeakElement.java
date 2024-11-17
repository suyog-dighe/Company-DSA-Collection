package Accenture;
public class FindpeakElement {
    public static int findpeak(int[] arr){
        int n=arr.length;
        if (n<0){
            return -1; // ex :- {}
        }
        if (n==1){
            return arr[0]; // ex :- {2}==2
        }
        if (arr[0]>arr[1]) {
            return arr[0];  //ex:- {4,3,2,1}==4
        }
        if (arr[n-1]>arr[n-2]) {
            return arr[n - 1];  // ex:- {2,4,6,8}==8
        }
        for (int i=1;i<n-1;i++){
            if (arr[i]>arr[i+1]){
                return arr[i];   //ex :- {1,2,3,5,7,4,3,2,1}==7
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[]arr= {1,2,3,5,6,9,8,7,6};
        int[] num={4,5};
        System.out.println(findpeak(num));
        System.out.println(findpeak(arr));
    }
}
