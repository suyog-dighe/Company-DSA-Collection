package AmazonGoogle;

public class LongestPathInMatrix {
    private static int[][] directions={{1,0},{-1,0},{0,1},{0,-1}};
    public static int longestPath(int[][] matrix){
        if(matrix==null || matrix.length==0){
            return 0;
        }

        int m=matrix.length;
        int n=matrix[0].length;
        int max=0;
        int[][] cache= new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int path=getPath(matrix,cache,i,j,m,n);
                max=Math.max(max,path);
            }
        }
        return max;
    }
    private static int getPath(int[][] matrix, int[][] cache, int i,int j,int m,int n){
        if (cache[i][j]>0){
            return cache[i][j];
        }
        int max=0;
        for (int[]  direction:directions){
            int x=direction[0]+i;
            int y=direction[1]+j;
            if (x >-1 && x<m && y>-1 && y<n && matrix[x][y] > matrix[i][j]){
                int path=getPath(matrix,cache,x,y,m,n);
                max=Math.max(max,path);
            }
        }
        cache[i][j]=max+1;
        return cache[i][j];
    }
    public static void main(String[] args) {
        int grid[][]={{9,9,4},{6,6,8},{2,1,1}};
        System.out.println(longestPath(grid));

    }
}
