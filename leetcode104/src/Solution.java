import javax.swing.tree.TreeNode;

public class Solution {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){this.val=val;}
    }

    public int maxDepth(TreeNode root){//基础递归
        if(root==null) return 0;
        else return Math.max(maxDepth(root.left), maxDepth(root.right))+1;
    }
}
