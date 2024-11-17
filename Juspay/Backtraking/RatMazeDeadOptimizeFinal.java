package Juspay.Backtraking;

public class RatMazeDeadOptimizeFinal {
    public static void printpath(int sr,int sc,int er,int ec ,String s,int[][]maze){
        if (sr<0 || sc<0) return;
        if (sr>er || sc>ec) return;

        if (sr==er && sc==ec) {
            System.out.println(s);
            return;
        }
        if (maze[sr][sc]==0)return;
        maze[sr][sc]=0;
        printpath(sr,sc+1,er,ec,s+"R",maze);
        printpath(sr+1,sc,er,ec,s+"D",maze);
        printpath(sr,sc-1,er,ec,s+"L",maze);
        printpath(sr-1,sc,er,ec,s+"U",maze);
        maze[sr][sc]=1;

    }
    public static void main(String[] args) {
        int row = 3;
        int col=4;
        boolean[][] visited= new boolean[row][col];
        int[][] maze={{1,0,1,1},{1,1,1,1},{1,1,0,1}};
        printpath(0,0,row-1,col-1,"",maze);
    }
}
