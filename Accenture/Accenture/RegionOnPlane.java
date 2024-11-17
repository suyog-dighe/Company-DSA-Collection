package Accenture;

/*
Level - Medium

Problem statement Mr. Professor is a great scientist, but he is not able to find
a solution to one problem. There are N straight lines that are not parallel,
and no three lines go through the same point. The lines divide the plane into M regions.
Write a function to find out the maximum number of such regions he can get on the plane.

Input Specification:
input1: An integer N representing the number of straight lines (0 <=N<= 100)

Output Specification:
Return the maximum number of regions
 */
public class RegionOnPlane {
    public static int regions(int n){
        return 1+(n*(n+1))/2;
    }
    public static void main(String[] args) {
    int n=5;
        System.out.println(regions(n));
    }
}
