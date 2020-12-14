import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    Set<Integer> hashset = new HashSet<>();

    public boolean hasPathSum(TreeNode root, int sum) {//把所有的叶子节点都求出来，放入hash表中即可
        if (root == null) return false;
        dfs(root, 0);
        return hashset.contains(sum);
    }

    private void dfs(TreeNode node, int cur) {
        cur += node.val;
        if (node.left == null && node.right == null) {
            hashset.add(cur);
            return;
        }
        if (node.left != null) dfs(node.left, cur);
        if (node.right != null) dfs(node.right, cur);
    }
    //上面的答案想得太简单了，出现了重复计算

    //以下为答案的思路，从上往下不断地计算，利用队列存储根节点到当前节点的和，并判断。
    public boolean hasPathSum2(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> queNode = new LinkedList<TreeNode>();
        Queue<Integer> queVal = new LinkedList<Integer>();
        queNode.offer(root);
        queVal.offer(root.val);
        while (!queNode.isEmpty()) {
            TreeNode now = queNode.poll();
            int temp = queVal.poll();
            if (now.left == null && now.right == null) {
                if (temp == sum) {
                    return true;
                }
                continue;
            }
            if (now.left != null) {
                queNode.offer(now.left);
                queVal.offer(now.left.val + temp);
            }
            if (now.right != null) {
                queNode.offer(now.right);
                queVal.offer(now.right.val + temp);
            }
        }
        return false;
    }
    //递归法，其实更应该能够想到,很漂亮
    public boolean hasPathSum3(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return sum == root.val;
        }
        return hasPathSum3(root.left, sum - root.val) || hasPathSum3(root.right, sum - root.val);
    }

}
