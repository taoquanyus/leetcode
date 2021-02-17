import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int count = 1;
        for (int layer = 0; layer < (n + 1) / 2; ++layer) {
            int row = layer, column = layer;
            while (column < n - layer) {
                matrix[row][column] = count;
                column++;
                count++;
            }
            row++;
            column--;
            while (row < n - layer - 1) {
                matrix[row][column] = count;
                row++;
                count++;
            }
            if (n % 2 == 1 && layer == (n - 1) / 2) {
                break;
            }
            while (column > layer - 1) {
                matrix[row][column] = count;
                count++;
                column--;
            }
            row--;
            column++;
            while (row > layer) {
                matrix[row][column] = count;
                row--;
                count++;
            }
        }
        return matrix;
    }
//参考答案，使用四个指针表示边界，更简洁明了
//比我的代码好得太多
    public int[][] generateMatrix2(int n) {
        int l = 0, r = n - 1, t = 0, b = n - 1;
        int[][] mat = new int[n][n];
        int num = 1, tar = n * n;
        while (num <= tar) {
            for (int i = l; i <= r; i++) mat[t][i] = num++; // left to right.
            t++;
            for (int i = t; i <= b; i++) mat[i][r] = num++; // top to bottom.
            r--;
            for (int i = r; i >= l; i--) mat[b][i] = num++; // right to left.
            b--;
            for (int i = b; i >= t; i--) mat[i][l] = num++; // bottom to top.
            l++;
        }
        return mat;
    }
}
