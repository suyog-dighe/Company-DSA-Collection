package Juspay.Backtraking;
public class AllDirectionPath {
    public static void printpath(int sr,int sc,int er,int ec ,String s,boolean[][] visited){
        if (sr<0 || sc<0) return;
        if (sr>er || sc>ec) return;
        if (visited[sr][sc])return;
        if (sr==er && sc==ec) {
            System.out.println(s);
            return;
        }
        visited[sr][sc]=true;
        printpath(sr,sc+1,er,ec,s+"R",visited);
        printpath(sr+1,sc,er,ec,s+"D",visited);
        printpath(sr,sc-1,er,ec,s+"L",visited);
        printpath(sr-1,sc,er,ec,s+"U",visited);
//        int total=leftways+rightways+upperways+downways;
        visited[sr][sc]=false;
    }
    public static void main(String[] args) {
        int row=3;
        int col=3;
        boolean[][] visited=new boolean[row][col];
        printpath(0,0,row-1,col-1,"",visited);
    }
}
