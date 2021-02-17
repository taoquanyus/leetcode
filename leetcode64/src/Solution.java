public class Solution {
    public int minPathSum(int[][] grid) {
        int row=grid.length;
        int column=grid[0].length;
        int[] rolling=new int[column];
        rolling[0]=grid[0][0];
        for(int j=1;j<column;j++){
            rolling[j]=rolling[j-1]+grid[0][j];
        }
        for(int i=1;i<row;i++){
            rolling[0]+=grid[i][0];
            for(int j=1;j<column;j++){
                rolling[j]=Math.min(rolling[j],rolling[j-1])+grid[i][j];
            }
        }
        return rolling[column-1];
    }
//    还是想复杂了，这道题连一个滚动数组甚至都不需要维护
//    最基础的动态规划
    public int minPathSum2(int[][] grid) {
        int width = grid[0].length, high = grid.length;
        if (high == 0 || width == 0) return 0;
        // 初始化
        for (int i = 1; i < high; i++) grid[i][0] += grid[i - 1][0];
        for (int i = 1; i < width; i++) grid[0][i] += grid[0][i - 1];
        for (int i = 1; i < high; i++)
            for (int j = 1; j < width; j++)
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
        return grid[high - 1][width - 1];
    }
}
