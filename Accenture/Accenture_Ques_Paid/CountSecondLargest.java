package Accenture_Ques_Paid;

public class CountSecondLargest {
    public static void countsecond(int[]arr){
        int n=arr.length;
        int first=Integer.MIN_VALUE;
        int second=Integer.MIN_VALUE;
        int count=0;

        for (int i=0;i<n;i++){
            if (arr[i]>first){
                second=first;
                first=arr[i];
            }else if (arr[i]>second && arr[i] <first){
                second=arr[i];
            }
        }
//        if (second == Integer.MIN_VALUE) {
//            // No second-largest element found
//            return 0;
//        }
        for (int num:arr){
            if (num==second){
                count++;
            }
        }
//        return count;
        System.out.println("Largest :"+first);
        System.out.println("second  :"+second +" Count is :"+count);
//        System.out.println(count);
    }
    public static void main(String[] args) {
        int[] arr = {4, 2, 6, 8, 6, 6, 8, 5};
        countsecond(arr);
    }
}
