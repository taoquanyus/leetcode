import java.util.ArrayList;
import java.util.List;

public class Solution {//代码写得漂亮多了，使用ret作为暂存数组，可以更好地节省空间
    public List<List<Integer>> generate(int numRows){
        List<List<Integer>> ret = new ArrayList<>();
        for(int numRow=1;numRow<numRows;numRow++){
            List<Integer> row=new ArrayList<>();//实例化还有清空的作用，学到了
            for(int j=0;j<=numRow;j++){
                if(j==0||j==numRow) row.add(1);
                else {
                    row.add(ret.get(numRow-1).get(j-1)+ret.get(numRow-1).get(j));
                }
            }
            ret.add(row);
        }
        return ret;
    }
}
