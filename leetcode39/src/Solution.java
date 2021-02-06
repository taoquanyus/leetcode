import java.util.*;

public class Solution {
    //这种题一看就应该使用回溯法，但是我不会用
    //我使用的是暴力求解法
    public static void main(String[] args) {
        int[] candidates = new int[]{2, 3, 5};
        int target = 8;
        combinationSum(candidates, target);
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        ans = allSum(candidates, target, 0);
        for (int i = 0; i < ans.size(); i++) {
            List<Integer> temp = ans.get(i);
            if (temp.contains(-1)) {
                ans.remove(temp);
                i--;
            }
        }
        return ans;
    }

    private static List<List<Integer>> allSum(int[] candidates, int target, int i) {
        List<List<Integer>> ans = new ArrayList<>();
        int length = candidates.length - i;
        if (length == 1) {//递归的终点
            List<Integer> temp = new ArrayList<>();
            if (target % candidates[0] == 0) {
                while (target >= candidates[0]) {
                    temp.add(candidates[0]);
                    target -= candidates[0];
                }
                ans.add(temp);
            } else {
                temp.add(-1);
                ans.add(temp);
            }
            return ans;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(target);
        int target1 = target, target2 = target;
        while (target1 > candidates[length - 1]) {
            target1 -= candidates[length - 1];
            queue.add(target1);
        }
        if (target1 == candidates[length - 1]) {
            List<Integer> temp = new ArrayList<>();
            while (target >= candidates[length - 1]) {
                temp.add(candidates[length - 1]);
                target -= candidates[length - 1];
            }
            ans.add(temp);
        }
        while (!queue.isEmpty()) {
            target = queue.poll();
            List<List<Integer>> subAns = allSum(candidates, target, i + 1);
            for (int j = 0; j < subAns.size(); j++) {
                List<Integer> temp2 = subAns.get(j);
                if (!temp2.contains(-1)) {
                    int target3 = target2 - target;
                    while (target3 >= candidates[length - 1]) {
                        temp2.add(candidates[length - 1]);
                        target3 -= candidates[length - 1];
                    }
                }
                ans.add(temp2);
            }
        }
        return ans;
    }

    //回溯法
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> combine = new ArrayList<Integer>();
        dfs(candidates, target, ans, combine, 0);
        return ans;
    }

    public void dfs(int[] candidates, int target, List<List<Integer>> ans, List<Integer> combine, int idx) {
        if (idx == candidates.length) {
            return;
        }
        if (target == 0) {
            ans.add(new ArrayList<Integer>(combine));
            return;
        }
        // 直接跳过
        dfs(candidates, target, ans, combine, idx + 1);
        // 选择当前数
        if (target - candidates[idx] >= 0) {
            combine.add(candidates[idx]);
            dfs(candidates, target - candidates[idx], ans, combine, idx);
            combine.remove(combine.size() - 1);
        }
    }

}
