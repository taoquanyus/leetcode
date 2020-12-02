import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    int parent_value=Integer.MAX_VALUE;
    public int minDiffInBST(TreeNode root){//我的代码，但结果不能实现，因为子二叉树不能调用父二叉树的值
            if(root==null) return Integer.MAX_VALUE;
            int diff=Math.abs(parent_value-root.val);
            parent_value=root.val;
            return Math.min(diff,Math.min(minDiffInBST(root.right),minDiffInBST(root.left)));

    }
    //下面为参考答案，思路清晰，对于两个递归之间的节点就用一个外部变量来传参数
    //差值的最小值
    int min = Integer.MAX_VALUE;
    //前一个节点
    TreeNode prev;
    public int minDiffInBST2(TreeNode root) {
        inorder(root);
        return min;
    }
    public void inorder(TreeNode root) {
        //边界条件判断
        if (root == null)
            return;
        //左子树
        inorder(root.left);
        //对当前节点的操作
        if (prev != null)
            min = Math.min(min, root.val - prev.val);
        prev = root;
        //右子树
        inorder(root.right);
    }

}
