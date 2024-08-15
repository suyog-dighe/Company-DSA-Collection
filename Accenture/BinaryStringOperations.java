package Accenture;

/*
The Binary number system only uses two digits, 0 and 1 and the number
system can be called binary string. You are required to implement the
following function:
int OperationsBinaryString(char* str);
The function accepts a string str as its argument. The string str consists of
binary digits separated with an alphabet as follows:
– A denotes AND operation
– B denotes OR operation
– C denotes XOR Operation
You are required to calculate the result of the string str, scanning the string
to right taking one operation at a time, and return the same.
Note
: No order of priorities of operations is required.
Length of str is odd.
If str is NULL or None (in case of Python), return -1.
Input:  1C0C1C1A0B1
Output : 1
 */
public class BinaryStringOperations {
    public static int operation(String s){
        if (s==null || s.length()%2==0){
            return -1;
        }
        int res=s.charAt(0)-'0';
        for (int i=1;i<s.length();i+=2){
            char op=s.charAt(i);
            int next=s.charAt(i+1)-'0';

            if(op=='A'){
                res &=next;
            }else if(op=='B'){

                res |=next;
            }
            else if (op=='C'){
                res ^=next;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        String input = "1C0C1C1A0B2";
        System.out.println(operation(input));
    }

}
