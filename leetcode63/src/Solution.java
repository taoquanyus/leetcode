public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int[][] dp=new int[m][n];
        dp[1][1]=1;
        return CountPath(obstacleGrid,dp,m,n);
    }

    private int CountPath(int[][] obstacleGrid,int[][] dp, int m, int n) {
        if(obstacleGrid[m][n]==1)return 0;
        if(dp[m][n]!=0)return dp[m][n];
        if(m==1){
            dp[m][n]=CountPath(obstacleGrid,dp,m,n-1);
            return dp[m][n];
        }
        if(n==1){
            dp[m][n]=CountPath(obstacleGrid,dp,m-1,n);
            return dp[m][n];
        }
        dp[m][n]=CountPath(obstacleGrid,dp,m-1,n)+CountPath(obstacleGrid,dp,m,n-1);
        return dp[m][n];
    }

//利用滚动数组，大大节省了空间复杂度
// 非常地巧妙！
    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        int n = obstacleGrid.length, m = obstacleGrid[0].length;
        int[] f = new int[m];
        f[0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (obstacleGrid[i][j] == 1) {
                    f[j] = 0;
                    continue;
                }
                if (j - 1 >= 0 && obstacleGrid[i][j - 1] == 0) {
                    f[j] += f[j - 1];
                }
            }
        }
        return f[m - 1];
    }
}
