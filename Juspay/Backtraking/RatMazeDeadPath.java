package Juspay.Backtraking;

public class RatMazeDeadPath {
    public static void printpath(int sr,int sc,int er,int ec ,String s,int [][]maze){
        if (sr>er || sc>ec) return;
        if (sr==er && sc==ec) {
            System.out.println(s);
            return;
        }
        if (maze[sr][sc]==0)return;
        printpath(sr,sc+1,er,ec,s+"R",maze);
        printpath(sr+1,sc,er,ec,s+"D",maze);
    }
    public static void main(String[] args) {
        int row=4;
        int col=6;
        int[][] maze={{1,0,1,1,1,1},{1,1,1,1,0,1},{0,1,1,1,1,1},{0,0,1,0,1,1}};
        printpath(0,0,row-1,col-1,"",maze);
    }
}
