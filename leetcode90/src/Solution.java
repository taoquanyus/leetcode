import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    //很明显的回溯法
    List<List<Integer>> ans=new ArrayList<>();
    List<Integer> temp=new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(nums,0);
        return ans;
    }
    public void dfs(int nums[],int index){
        if(index==nums.length){
            ans.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[index]);
        dfs(nums,index+1);
        temp.remove(temp.size()-1);//什么都不添加
        int i=1;
        while (index+i< nums.length&&nums[index]==nums[index+i]){
            //如果下一个元素相等就直接跳过
            ++i;
        }
        dfs(nums,index+i);
    }
}
