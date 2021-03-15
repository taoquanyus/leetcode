import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2 {
    List<Integer> temp=new ArrayList<>();
    List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates,0,target);
        return ans;
    }
    //i表示到第几个字符     target表示剩余的和
    private void dfs(int[] candidates, int i, int target) {
        if(target==0){
            List<Integer> subAns=new ArrayList<>(temp);
            ans.add(subAns);
            return;
        }
        if(i==candidates.length||target<candidates[i]){
            return;
        }
        temp.add(candidates[i]);
        dfs(candidates,i,target-candidates[i]);
        temp.remove(temp.size()-1);
        dfs(candidates,i+1,target);
    }
}
