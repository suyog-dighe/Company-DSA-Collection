package AmazonGoogle;
// https://leetcode.com/problems/number-of-islands/
//leetcode :200. Number of Islands

import java.util.LinkedList;
import java.util.Queue;

public class NumOfIsland {
    private static int[][] directions={{1,0},{-1,0},{0,1},{0,-1}};
    public static int numIslands(char[][] grid){
        int count=0;
        int m=grid.length;
        int n=grid[0].length;
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (grid[i][j]=='1'){
                    getCount1(grid,i,j,m,n);
                    count++;
                }
            }
        }
        return count;
    }

    //Using BFS
    private static void getCount1(char[][] grid, int i,int j, int m,int n){
        Queue<Integer> q= new LinkedList<>();
        // 2D -> 1D == R * # n + C;
        // 1D -> 2D == index/#n =R, index% n= C
        q.add(i*m+j);
        grid[i][j]='0';
        while (!q.isEmpty()){
            int index= q.poll();
            int row= index/n;
            int col=index%n;
            for(int [] direction : directions){
                int x= direction[0]+row;
                int y=direction[1]+col;
                if (x >-1 && x< m && y>-1 && y<n && grid[x][y]=='1'){
                    grid[x][y]='0';
                    q.add(x*n+y);
                }
            }

        }
    }

    //Using DFS
    private static int getCount(char[][] grid, int i,int j, int m,int n){
        //base case
        if (i<0 || j< 0 || i>=m ||j>=n|| grid[i][j]=='0'){
            return 0;
        }
        grid[i][j]='0';//when visited to 1 make it zero
        int left=getCount(grid,i,j-1,m,n);
        int right=getCount(grid,i,j+1,m,n);
        int up=getCount(grid,i-1,j,m,n);
        int down=getCount(grid,i+1,j,m,n);
        return left+right+up+down;
    }

    public static void main(String[] args) {
       char[][] grid = {  {'1','1','1','1','0'},
                          {'1','1','0','1','0'},
                          {'1','1','0','0','0'},
                          {'0','0','0','0','0'}};

       char[][] grid2= {   {'1','1','0','0','1'},
                           {'1','1','0','0','0'},
                           {'0','0','1','0','0'},
                           {'1','0','0','1','1'}};

        System.out.println("Number of Island is: "+ numIslands(grid));
    }
}
