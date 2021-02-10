import java.util.*;

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> out=new ArrayList<>();
        List<Integer> duplicate=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(i>0&&nums[i]==nums[i-1]){
                duplicate.add(nums[i]);
                continue;
            }
            out.add(nums[i]);
        }
        int first=0;
        TrackBacks(nums,ans,first,out);
        AddUp(duplicate,ans);
        return ans;
    }
    //我本来的想法是把重复的数字先取出来，再逐个加到输出的数组中
    //但这样的做法有些复杂，没能完成Addup()函数
    private void AddUp(List<Integer> duplicate, List<List<Integer>> ans) {
        for(int i=0;i<duplicate.size();++i){
            for(int j=0;j<ans.size();++j){
                List<Integer> temp=ans.get(j);
                for(int k=0;k<temp.size();k++){
                    if(temp.get(k)==duplicate.get(i));
                }

            }
        }
    }
    private void TrackBacks(int[] nums, List<List<Integer>> ans, int first,List<Integer> out) {
        int n=nums.length;
        if(first==n){
            ans.add(new ArrayList<>(out));
        }
        for(int i=first;i<nums.length;++i){
            Collections.swap(out,first,i);
            TrackBacks(nums,ans,first+1,out);
            Collections.swap(out,first,i);
        }
    }

    //参考答案：
    boolean[] vis;

    public List<List<Integer>> permuteUnique2(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> perm = new ArrayList<Integer>();
        vis = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums, ans, 0, perm);
        return ans;
    }

    public void backtrack(int[] nums, List<List<Integer>> ans, int idx, List<Integer> perm) {
        if (idx == nums.length) {
            ans.add(new ArrayList<Integer>(perm));
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            //同一个索引，添加过了直接跳过
            if (vis[i] || (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1]))
            //不同一个索引，如果两个值相等，且上一个也没添加过，就跳过
            {
                continue;
            }
            perm.add(nums[i]);
            vis[i] = true;
            backtrack(nums, ans, idx + 1, perm);
            vis[i] = false;
            perm.remove(idx);
        }
    }
}
