package Accenture_Ques_Paid;
public class FindMinK_InMatrix {
    public static int findmin(int[][] num){
        int n=num.length;

        for (int i=0;i<n;i++){
            boolean row=true,col=true;
            //for row
            for (int j=0;j<n;j++){
                if (j!=i && num[i][j]!=0){
                    row=false;
                    break;
                }
            }
            //for col
            for (int k=0;k<n;k++){
                if (k!=i && num[k][i]!=0){
                    col=false;
                    break;
                }
            }
            if (row && col){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[][] num = {
                {1, 0, 0, 0},
                {0, 2, 0, 0},
                {9, 0, 3, 0},
                {0, 0, 0, 4}
        };
        System.out.println("ans is "+findmin(num));
    }
}
