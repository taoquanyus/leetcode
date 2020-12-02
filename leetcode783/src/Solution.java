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
    public int minDiffInBST(TreeNode root){//我的代码，思路完全混乱，参考下面代码
        if(root!=null){
            int diff=100 ;//操作树的时候最重要就是要分析节点是否为空
            int left=100,right=100;
            if(root.left!=null)left=Math.abs(root.val-root.left.val);
            if(root.right!=null) right=Math.abs(root.val-root.right.val);
            if(root.left==null &&root.right!=null) diff=right;
            if(root.left!=null &&root.right==null) diff=left;
            if(root.left!=null &&root.right!=null) diff=Math.min(left,right);
            if(root.left==null &&root.right!=null) return diff;
            return Math.min(diff,Math.min(minDiffInBST(root.left),minDiffInBST(root.right)));
        }
        return 0;
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
