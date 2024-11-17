package Juspay.Divide_Conquer;
public class QuickSort {
    public static void main(String[] args) {
        int[] arr={6,3,8,1,2,7,9,10,4,5};
        int n=arr.length;

        quicksort(arr,0,n-1);
        for (int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
    }
    private static void quicksort(int[] arr, int low, int high) {
        if (low<high){
            int pdx=partition(arr,low,high);

            quicksort(arr,low,pdx-1);
            quicksort(arr,pdx+1,high);
        }
    }
    private static int partition(int[] arr, int low, int high) {
//        int pi=arr[low];
//        int i=low;
//        int j=high;
//        while (i<j){
//            while (pi>=arr[i] && i< high){
//                i++;
//            }
//            while (pi< arr[j] ){
//                j--;
//            }
//
//            if (i < j) {
//                int temp=arr[i];
//                arr[i]=arr[j];
//                arr[j]=temp;
//            }
//        }
//        int temp=arr[low];
//        arr[low]=arr[j];
//        arr[j]=temp;
//        return j;


        int pivot=arr[high];
        int i=low-1;
        for (int j=low;j<high;j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        i++;
        int temp=arr[i];
        arr[i]=arr[high];
        arr[high]=temp;

        return i;

    }
}
