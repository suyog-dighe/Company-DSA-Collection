package Juspay.Backtraking;
import java.util.*;
public class Unique_Path {
    private static final int MOD = 1000000007;

    private static int getCount(ArrayList<ArrayList<Integer>> grid, int i, int j, int m, int n) {
        if (i < 0 || j < 0 || i >= m || j >= n || grid.get(i).get(j) == -1) {
            return 0;
        }
        if (i == m - 1 && j == n - 1) {
            return 1;
        }

        grid.get(i).set(j, -1);
        int paths = (getCount(grid, i + 1, j, m, n) + getCount(grid, i, j + 1, m, n)) % MOD;
        grid.get(i).set(j, 0);

        return paths;
    }

    static int mazeObstacles(int n, int m, ArrayList<ArrayList<Integer>> mat) {
        return getCount(mat, 0, 0, n, m);
    }

    /*
     static int mazeObstacles(int n, int m, ArrayList<ArrayList<Integer>> mat) {
        int mod = 1000000007;
        int[][] dp = new int[n][m];

        if (mat.get(0).get(0) == -1 || mat.get(n - 1).get(m - 1) == -1) {
            return 0;
        }

        dp[0][0] = 1; // Starting point

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat.get(i).get(j) == -1) {
                    dp[i][j] = 0;
                } else {
                    if (i > 0) {
                        dp[i][j] = (dp[i][j] + dp[i - 1][j]) % mod; // From above
                    }
                    if (j > 0) {
                        dp[i][j] = (dp[i][j] + dp[i][j - 1]) % mod; // From left
                    }
                }
            }
        }

        return dp[n - 1][m - 1];
    }
     */
}
