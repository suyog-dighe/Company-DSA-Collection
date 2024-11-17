package Accenture;

/*
level - Medium
Question Edward's Birthday

Problem statement :-
            It is Edward's birthday today. His friends have bought him a huge circular cake.
            Edward wants to find out the maximum number of pieces he can get by making exactly N straight vertical
            cuts on the cake. Your task is to write a function that returns the maximum number of pieces that
            can be obtained by making N number of cuts.
            Note: Since the answer can be quite large, modulo it by 1000000007
Input Specification:
    input1: An integer N denoting the number of cuts
    I/p N=4;
Output Specification:
    Return the maximum number of pieces that can be obtained by making N cuts on the cake
    o/p :- 11

 */

public class EdwardBirthdays {
    public static int maximumPart(int n){
        return 1+(n*(n+1))/2;
    }
    public static void main(String[] args) {
        int n=4;
        System.out.println(maximumPart(n));
    }
}
