package Accenture;

/*
Jack has an array A of length N. He wants to label whether the number
 in the arrayis even or odd. Your task is to help him find and return
  a string with labels even or odd in sequence according to which the
  numbers appear in the array.
Input 1:
[1, 2, 3, 4, 5, 6]
Output1: • OddEvenOddEvenOddEven
 */
public class EvenOddStringBuild {
    public static String makeevenodd(int[] arr){
        StringBuilder sb= new StringBuilder();
        for (int num :arr){
            if (num%2==0){
                sb.append("Even");
            }else{
                sb.append("Odd");
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
    int [] arr={1,2,3,4,5,6,9};
        System.out.println(makeevenodd(arr));
    }
}
