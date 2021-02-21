import java.util.ArrayList;
import java.util.List;

class Solution {
    List<Integer> t = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    //这个思路利用的是位操作，漂亮！
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        //1 << n表示的是2的n次方
        for (int mask = 0; mask < (1 << n); ++mask) {
            t.clear();
            for (int i = 0; i < n; ++i) {
                //mask表示0101的序列，对每一个mask进行添加，下面是添加的过程：
                //对mask的每一位进行判断，如果为
                if ((mask & (1 << i)) == 1 << i) {
                    t.add(nums[i]);
                }
            }
            ans.add(new ArrayList<Integer>(t));
        }
        return ans;
    }

    //但这道题一看就知道标准解法是回溯法：
    //回溯法是由dfs实现的，而dfs则是由递归实现的
    List<Integer> t1 = new ArrayList<Integer>();
    List<List<Integer>> ans1 = new ArrayList<List<Integer>>();

    public List<List<Integer>> subsets2(int[] nums) {
        dfs(0, nums);
        return ans1;
    }
//回溯法真的很重要！
    public void dfs(int cur, int[] nums) {
        if (cur == nums.length) {
            ans1.add(new ArrayList<Integer>(t1));
            return;
        }
        t.add(nums[cur]);
        dfs(cur + 1, nums);
        t.remove(t1.size() - 1);
        dfs(cur + 1, nums);
    }
}
