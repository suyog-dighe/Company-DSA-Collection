package AmazonGoogle;
//leetcode : 495
public class maxAreaOfIsland {
    public static int maxAreaIsland(int[][] grid){
        int max=0,m= grid.length,n=grid[0].length;
        for (int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    int maxi=getMaxArea(grid,i,j,m,n);
                    max=Math.max(max,maxi);

                }
            }
        }
        return max;
    }
    private static int getMaxArea(int[][] grid,int i,int j,int m,int n){
        //base case
        if(i<0 || j<0 || i>=m || j>= n || grid[i][j]==0){
            return 0;
        }
        grid[i][j]=0;  // replace 1 by 0
        int left=getMaxArea(grid,i,j-1,m,n);
        int right=getMaxArea(grid,i,j+1,m,n);
        int up=getMaxArea(grid,i-1,j,m,n);
        int down=getMaxArea(grid,i+1,j,m,n);

        return left+right+up+down+1;
    }
    public static void main(String[] args) {
        int[][] grid={{0,0,1,0,0,0,0,1,0,0,0,0,0},
                      {0,0,0,0,0,0,0,1,1,1,0,0,0},
                      {0,1,1,0,1,0,0,0,0,0,0,0,0},
                      {0,1,0,0,1,1,0,0,1,0,1,0,0},
                      {0,1,0,0,1,1,0,0,1,1,1,0,0},
                      {0,0,0,0,0,0,0,0,0,0,1,0,0},
                      {0,0,0,0,0,0,0,1,1,1,0,0,0},
                      {0,0,0,0,0,0,0,1,1,0,0,0,0}};

        int grid2[][]={{0,0,0,0,0,0,0,0,0}};
        System.out.println("Maximum Area Of Island is : "+maxAreaIsland(grid));

    }
}
