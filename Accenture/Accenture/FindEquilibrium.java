package Accenture;

/*
    The function accepts an integer array 'arr' of size 'n' as its argument.
    The function needs to return the index of an equilibrium point in the array,
    where the sum of elements on the left of the index is equal to the sum of
    elements on the right of the index. If no equilibrium point exists return -1
 */
public class FindEquilibrium {
    public static int findequi(int[] arr){
        int n=arr.length;
        int[] prefix=new int[n];
        prefix[0]=arr[0];

        int suffix[]= new int[n];
        suffix[n-1]=arr[n-1];

        for (int i=1;i<n;i++){
            prefix[i] =prefix[i-1]+arr[i];
            suffix[n-i-1] =arr[n-i-1]+suffix[n-i];
        }

        for (int i=0;i<n;i++){
            if (prefix[i]==suffix[i]){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int arr[]={-7,1,5,2,-4,3,0};
        System.out.println(findequi(arr));

    }
}
