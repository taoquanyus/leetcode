public class Solution {//这道题和783相同
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {val=x;}//这个的意思是方法
    }
    TreeNode prev;
    int ans=Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root){
        inOrder(root);
        return ans;
    }

    private void inOrder(TreeNode node) {
        if(node==null) return;
        inOrder(node.left);
        if(prev!=null) ans=Math.min(ans,Math.abs(node.val-prev.val));
        prev=node;
        inOrder(node.right);
    }
}
