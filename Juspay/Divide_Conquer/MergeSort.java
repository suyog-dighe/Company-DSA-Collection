package Juspay.Divide_Conquer;

public class MergeSort {
    public static void divide(int arr[] ,int start,int end){
        if (start>=end){
            return;
        }
        //nlog(O)
        int mid=start+(end-start)/2;
        divide(arr,start,mid);
        divide(arr,mid+1,end);
        conquer(arr,start,mid,end);

    }

    private static void conquer(int[] arr, int start, int mid, int end) {
        int[] merge= new int[end-start+1];

        int idx1=start;
        int idx2=mid+1;
        int x=0;
        while (idx1<=mid && idx2<=end){
            if (arr[idx1] <= arr[idx2]){
                merge[x++]=arr[idx1++];
            }else{
                merge[x++]=arr[idx2++];
            }
        }
        while (idx1<=mid){
            merge[x++]=arr[idx1++];
        }
        while (idx2<=end){
            merge[x++]=arr[idx2++];
        }
        for (int i=0,j=start;i<merge.length;i++,j++){
            arr[j]=merge[i];
        }
    }
    //using 2 array
    private static void conquer1(int[] arr, int l, int mid, int r) {
        int[] left = new int[mid - l + 1];
        int[] right = new int[r - mid];

        // Copying elements into the left array
        for (int i = 0; i < left.length; i++) {
            left[i] = arr[l + i];
        }

        // Copying elements into the right array
        for (int j = 0; j < right.length; j++) {
            right[j] = arr[mid + 1 + j];
        }

        int n1 = 0;
        int n2 = 0;
        int x = l;

        // Merging the two subarrays back into arr
        while (n1 < left.length && n2 < right.length) {
            if (left[n1] <= right[n2]) {
                arr[x++] = left[n1++];
            } else {
                arr[x++] = right[n2++];
            }
        }

        // Copy remaining elements from left array
        while (n1 < left.length) {
            arr[x++] = left[n1++];
        }

        // Copy remaining elements from right array
        while (n2 < right.length) {
            arr[x++] = right[n2++];
        }
    }

    public static void main(String[] args) {
        int[] arr={6,3,8,1,2,7,9,10,4,5};
        int n=arr.length;

        divide(arr,0,n-1);
        for (int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
