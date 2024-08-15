package Accenture;

// Lecture - 5
//Question 2- Rearrangement of the Bits
/*

Alex Gives You a positive Number N and wants you to rearrange
the bits of the number in its binary representation such that
all set bits are in consecutive order. Your task is to find and
return an integer value representing the minimum possible number
that can be formed after re-arranging the bits of the number N.

Input:- 10
Output :- 3

Input:- 2
Output:- 1
 */

public class RearrangementBits {
    public static int rearrangebit(int n){
        int count=0;
        while(n>0){
            count +=n & 1;
            n >>=1;
        }
        int ans=(int)(Math.pow(2,count)-1);

        return ans;
    }
    public static void main(String[] args) {
        int a=7;
        System.out.println(rearrangebit(a));

    }
}
