public class Solution {
    public void rotate(int[][] matrix) {//一圈一圈地变换，layer表示圈数
        int n=matrix[0].length;
        for(int layer=0;layer<n/2;layer++){
            for(int column=layer;column<n-1-layer;++column){
                int temp=matrix[layer][column];
                matrix[layer][column]=matrix[n-1-column][layer];
                matrix[n-1-column][layer]=matrix[n-1-layer][n-1-column];
                matrix[n-1-layer][n-1-column]=matrix[column][n-1-layer];
                matrix[column][n-1-layer]=temp;
            }
        }
    }
}
