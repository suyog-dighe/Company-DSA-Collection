package AmazonGoogle;
 // Difficulty : Hard
import java.util.HashMap;
import java.util.*;
// Question : Maximum Connected group
// GFG : https://www.geeksforgeeks.org/problems/maximum-connected-group/1

//Question : 827. Making A Large Island
// LeetCode : https://leetcode.com/problems/making-a-large-island/description/

public class MakeLargeIsland {
    private static int [][] direction={{1,0},{-1,0},{0,1},{0,-1}};
    public  static int largestIsland(int[][] grid) {
        if(grid==null || grid.length==0){
            return 0;
        }
        Map<Integer,Integer> map=new HashMap<>();
        int max=0,island=2;
        int m= grid.length;
        int n=grid[0].length;
        for(int i=0;i<m;i++){
            for (int j = 0; j < n; j++) {
                if(grid[i][j]==1){
                    int size=getSizeofIsland(grid,i,j,m,n,island);
                    max=Math.max(max,size);
                    map.put(island++,size);
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j]==0){
                    Set<Integer>set= new HashSet<>();
                    for (int[] direct:direction){
                        int x=direct[0]+i;
                        int y=direct[1]+j;
                        if (x >-1 && y >-1 && x <m && y<n && grid[x][y] !=0){
                          set.add(grid[x][y]);
                        }
                    }
                    int sum=1;
                    for (int num:set){
                        if (map.containsKey(num)){
                            int values=map.get(num);
                            sum+=values;
                        }
                    }
                    max=Math.max(max,sum);
                }
            }
        }
        return max;
    }
    private static int getSizeofIsland(int[][] grid,int i,int j,int m,int n,int island){
        if (i<0 || j<0|| i>=m || j>=n || grid[i][j]!=1){
            return 0;
        }
        grid[i][j]=island;
        int left=getSizeofIsland(grid,i,j-1,m,n,island);
        int right=getSizeofIsland(grid,i,j+1,m,n,island);
        int up=getSizeofIsland(grid,i-1,j,m,n,island);
        int down=getSizeofIsland(grid,i+1,j,m,n,island);
        return left+right+up+down+1;
    }
    public static void main(String[] args) {
        int [][] grid={ {0,1,0,1,0},
                        {1,1,0,0,1},
                        {0,0,1,1,0}};
        System.out.println(largestIsland(grid));
    }
}