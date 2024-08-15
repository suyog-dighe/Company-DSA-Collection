package Accenture;

/*
Level - Medium

Problem statement :-
    Let j and k be two indices in an array A.
    If j < K and A[j] > A[k], then the pair (j.k) is known as an "Inversion pair".
    You are required to implement the following function:
    int InversionCount(int "A, int n);
    The function accepts an array 'A' of 'n' unique integers as its argument. You are required to
    calculate the number of 'Inversion pair' in an array A, and return.
Note:
    If 'A' is NULL (None in case of python), return -1 If 'n' <2, return 0

 */
public class InvensionPair {
    public static int countpair(int[]arr){
        int count=0;
        int n=arr.length;
        if(n==1){
            return -1;
        }
//        int m=arr[0];
        for(int i=0;i<n;i++){
           for(int j=i;j<n;j++){
               if(arr[i]>arr[j]){
                   count++;
               }
           }
        }
        return count;
    }
    public static void main(String[] args) {
        int[] arr={1,20,6,4,5};
        System.out.println(countpair(arr));
    }
}
