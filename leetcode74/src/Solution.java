public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //题目看错了，不过不影响AC，后面那部分判断其实不需要
        //这里先判断行，再判断列
        int row = matrix.length;
        int column = matrix[0].length;
        int left = 0, right = row - 1;
        int mid = 0;
        boolean flag = true;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (matrix[mid][0] < target) {
                left = mid + 1;
            }
            if (matrix[mid][0] > target) {
                right = mid - 1;
            }
            if (matrix[mid][0] == target) {
                flag = false;
                break;
            }
        }
        if (flag) {
            mid = left + (right - left) / 2;
            if (mid == 0) return false;
            if (!findTargetInMatrix(matrix[mid - 1], target)) return false;
        }

        //下面这部分其实不需要，这里是矩阵的特性，而不是要求
        for (int i = 0; i < row; i++) {
            if (i > 0 && matrix[i][0] <= matrix[i - 1][column - 1]) return false;
            for (int j = 0; j < column; j++) {
                if (j > 0 && matrix[i][j] < matrix[i][j - 1]) return false;
            }
        }
        return true;

    }

    private boolean findTargetInMatrix(int[] matrix, int target) {
        int left = 0, right = matrix.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (matrix[mid] < target) {
                left = mid + 1;
            }
            if (matrix[mid] > target) {
                right = mid - 1;
            }
            if (matrix[mid] == target) {
                return true;
            }
        }
        return matrix[left + (right - left) / 2] == target;
    }

    public boolean searchMatrix2(int[][] matrix, int target) {
        //答案写的，更加简单明了
        int m = matrix.length;
        if (m == 0) return false;
        int n = matrix[0].length;

        // 二分查找
        int left = 0, right = m * n - 1;
        int pivotIdx, pivotElement;
        while (left <= right) {
            pivotIdx = (left + right) / 2;
            pivotElement = matrix[pivotIdx / n][pivotIdx % n];
            if (target == pivotElement) return true;
            else {
                if (target < pivotElement) right = pivotIdx - 1;
                else left = pivotIdx + 1;
            }
        }
        return false;
    }
}
