package AmazonGoogle;
// leetcode 494
import java.util.HashSet;
//import java.util.Set;

public class NoOfDistinct_Island {
    public static int numDistinctIsland(int[][] grid){
        if (grid==null || grid.length==0) return 0;
//        Set<String> set=new HashSet<>();
        HashSet<String> set=new HashSet<>();
        int m=grid.length;
        int n=grid[0].length;
        if(grid.length<0 || grid[0].length<0){
            return 0;
        }
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (grid[i][j]==1){
                    String path=computepath(grid,i,j,m,n,"X");
                    set.add(path);
                }
            }
        }

    return set.size();
    }

    private static String computepath(int[][] grid, int i, int j, int m, int n,String direction) {
        if(i<0 || j<0 || i>=m ||j>=n ||grid[i][j]==0) return "O";
        grid[i][j]=0;
        String  left=computepath(grid,i,j-1,m,n,"L");
        String  right=computepath(grid,i,j+1,m,n,"R");
        String  up=computepath(grid,i-1,j,m,n,"U");
        String  down=computepath(grid,i+1,j,m,n,"D");
        return direction+left+right+up+down;
    }

    public static void main(String[] args) {

        int[][] grid={{1,1,0,0,0},{1,1,0,0,0},{0,0,0,1,1},{0,0,0,1,1}};
        int[][] grid2={{1,1,0,1,1},{1,0,0,0,0},{0,0,0,0,1},{1,1,0,1,1}};
        int ans=numDistinctIsland(grid);
        System.out.println(ans);
        System.out.println(numDistinctIsland(grid2));

    }
}
