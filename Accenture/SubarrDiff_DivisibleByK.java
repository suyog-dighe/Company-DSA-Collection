package Accenture;

public class SubarrDiff_DivisibleByK {
   static  int subarraysDivByK(int[] nums, int k) {
        int arr[] = new int[k];
        int sum = 0;
        int count = 0;
        arr[0] = 1;
        for(int i : nums) {
            sum = Math.abs((i-sum))%k;
            if(sum < 0) {
                sum -= Math.abs(k);
            }
            count += arr[sum];
            arr[sum]++;
        }
        return count;
    }
    static  int tripleSubsequence(int[] nums, int k) {
        int arr[] = new int[k];
        int sum = 0;
        int count = 0;
        arr[0] = 1;
        for(int i : nums) {
            sum = Math.abs((i-sum))*3;
            if(sum < 0) {
                sum -= Math.abs(k);
            }
            count += arr[sum];
            arr[sum]++;
        }
        return count;
    }
    public static void main(String[] args) {
        int num[]={1,1,2};
        int k=3;
        System.out.println(tripleSubsequence(num,k));
    }
}
