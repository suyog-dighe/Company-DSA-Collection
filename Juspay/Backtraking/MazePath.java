package Juspay.Backtraking;

public class MazePath {
    public static void main(String[] args) {
        int row=3;
        int col=3;
        boolean[][] visited=new boolean[row][col];
        int count=maze(0,0,row-1,col-1,visited);
        System.out.println(count);
    }

    public static int maze(int sr,int sc,int er,int ec,boolean[][] visited){
        if (sr>er || sc>ec) return 0;
        if (sc<0 || sr<0 || visited[sr][sc])return 0;
        if (sr==er || sc==ec) return 1;

        visited[sr][sc]=true;
//        int leftways= maze(sr,sc-1,er,ec,visited);
//        int upperways=maze(sr-1,sc,er,ec,visited);
        int downways=maze(sr+1,sc,er,ec,visited);
        int rightways= maze(sr,sc+1,er,ec,visited);
        int total=rightways+downways;
        visited[sr][sc]=false;
        return  total;
    }
}
