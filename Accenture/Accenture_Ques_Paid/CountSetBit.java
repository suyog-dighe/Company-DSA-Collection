package Accenture_Ques_Paid;

public class CountSetBit {
    public static int countBit(int n){
        // Convert the number to its binary representation
        String s = Integer.toBinaryString(n);
//        int p=Integer.parseInt(s);
        int count = 0;

        // Traverse the binary string and count the '1's
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int n=15;
        System.out.println(countBit(n));

    }
}
