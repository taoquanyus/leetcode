import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){this.val=x;}
    }
    public TreeNode mergeTrees(TreeNode t1,TreeNode t2){
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        TreeNode merged = new TreeNode(t1.val + t2.val);//很巧妙哦，巧用了变量作为递归
        merged.left = mergeTrees(t1.left, t2.left);
        merged.right = mergeTrees(t1.right, t2.right);
        return merged;
    }
}
