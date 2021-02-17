import java.util.Arrays;

class Solution {
    //我一开始的算法，也是最简单的方法
    //但是递归会超出时间限制
    public int uniquePaths(int m, int n) {
        if (m == 1 && n == 1) return 1;
        if (m == 1 && n > 1) return uniquePaths(m, n - 1);
        if (n == 1 && m > 1) return uniquePaths(m - 1, n);
        return uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
    }

    public int uniquePaths2(int m, int n) {
        int[][] dp = new int[m - 1][n - 1];
        return coutPath(dp, m - 1, n - 1);
    }

    private int coutPath(int[][] dp, int m, int n) {
        if (dp[m][n] != 0) return dp[m][n];
        if (n < dp.length && m < dp[0].length && dp[n][m] != 0) return dp[n][m];
        if (m == 0 & n == 0) {
            dp[m][n] = 1;
            return 1;
        }
        if (m == 0) {
            dp[m][n] = coutPath(dp, m, n - 1);
            return dp[m][n];
        }
        if (n == 0) {
            dp[m][n] = coutPath(dp, m - 1, n);
            return dp[m][n];
        }
        dp[m][n] = coutPath(dp, m - 1, n) + coutPath(dp, m, n - 1);
        return dp[m][n];
    }

    //参考答案
    //机器人一定会走m+n-2步，即从m+n-2中挑出m-1步向下走
    //即C（（m+n-2），（m-1））。
    public int uniquePaths3(int m, int n) {
        long ans = 1;
        for (int x = n, y = 1; y < m; ++x, ++y) {
            ans = ans * x / y;
        }
        return (int) ans;
    }

}