package Accenture;

/*
Problem statement :-
        In an array a superior element is one which is greater than
        all elements to its right. The rightmost element will
        always be considered as a superior element.
        You are given a function,
        Int FindNumberOfSuperior Elements(int* arr, int n);
        The function accepts an integer array 'arr' and
        its length 'n'. Implement the function to find and
        return the number of superior elements in array 'arr'.
Assumptions:
1. N > 0.
2. Array index starts from 0.
 */
public class SuperiArrayElement {
    public static int superiro(int[]num){
        int count=0;
        int n=num.length;
        int sup=Integer.MIN_VALUE;
        for(int i=n-1;i>=0;i--){
            if(num[i]>sup){
                count++;
                sup=num[i];
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int num[]={9,8,7};
        System.out.println(superiro(num));

    }
}
