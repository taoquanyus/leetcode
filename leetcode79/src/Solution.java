class Solution {
    boolean[][] flag;
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    //回溯法，和答案很接近
    //边界条件没弄清楚，出现了很多失误

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        flag = new boolean[m][n];
        if(board.length==1&&board[0].length==1){
            return board[0][0]==word.charAt(0)&&word.length()==1;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {//开始找
                    flag[i][j]=true;
                    if (isValid(board, i, j, word)) return true;
                    flag[i][j]=false;
                }
            }
        }
        //如果没有，就返回false
        return false;
    }

    //给你起始点，和单词找字母
    private boolean isValid(char[][] board, int i, int j, String word) {
        if(word.length()<=1) return true;
        for (int[] dir : dirs) {
            int x = i + dir[0];
            if(x>=board.length||x<0) continue;
            int y = j + dir[1];
            if(y>=board[0].length||y<0) continue;
            if (flag[x][y] == true)
                continue;
            if (board[x][y] == word.charAt(1)) {
                flag[x][y] = true;
                if (word.length()==2||isValid(board, x, y, word.substring(1, word.length())))
                    return true;
                flag[x][y]= false;
            }
            //进入下一层迭代
        }
        return false;
    }
}