import java.util.HashSet;

public class Solution {
    public static void main(String[] args) {
    }
    public boolean isValidSudoku(char[][] board) {
        for(char[] row:board){
            if(isContainsSameValue(row)) return false;
        }
        for(int i =0;i<9;++i){
            char[] column=new char[9];
            for(int j=0;j<9;++j){
                column[j]=board[j][i];
            }
            if(isContainsSameValue(column)) return false;
        }
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                char[] group=new char[9];
                for(int k=3*i;k<3*i+3;k++){
                    for(int l=3*j;l<3*j+3;l++){
                        group[3*(k-3*i)+(l-3*j)]=board[k][j];
                    }
                }
                if(isContainsSameValue(group)) return false;
            }
        }
        return true;
    }

    private boolean isContainsSameValue(char[] chs) {
        HashSet<Character> hashSet=new HashSet<>();
        for(char ch:chs){
            if(ch=='.') continue;
            if(hashSet.contains(ch)) return true;
            else {
                hashSet.add(ch);
            }
        }
        return false;
    }
}
