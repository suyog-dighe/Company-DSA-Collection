package Accenture;

public class MultipleOfThree {
    public static int countmnultiple(int[]arr){
        int n=arr.length;
        int count=0;
        for (int i=0;i<n;i++){
            if (arr[i] %3==0){
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[]arr={12,14,15,16,6,8,5,3,0};
        System.out.println(countmnultiple(arr));

    }
}
