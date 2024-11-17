package Juspay.Backtraking;

public class RatMazeDeadPath2 {
    public static void printpath(int sr,int sc,int er,int ec ,String s,int [][]maze,boolean[][]visited){
        if (sr<0 || sc<0) return;
        if (sr>er || sc>ec) return;

        if (sr==er && sc==ec) {
            System.out.println(s);
            return;
        }
        if (maze[sr][sc]==0)return;
        if (visited[sr][sc])return;

        visited[sr][sc]=true;
        printpath(sr,sc+1,er,ec,s+"R",maze,visited);
        printpath(sr+1,sc,er,ec,s+"D",maze,visited);
        printpath(sr,sc-1,er,ec,s+"L",maze,visited);
        printpath(sr-1,sc,er,ec,s+"U",maze,visited);
//        int total=leftways+rightways+upperways+downways;
        visited[sr][sc]=false;
    }
    public static void main(String[] args) {
        int row = 3;
        int col=4;
        boolean[][] visited= new boolean[row][col];
        int[][] maze={{1,0,1,1},{1,1,1,1},{1,1,0,1}};
        printpath(0,0,row-1,col-1,"",maze,visited);
    }
}
