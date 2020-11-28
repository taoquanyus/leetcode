public class Solution {
    public TreeNode SearchBST(TreeNode root, int val){//我写的代码，但是这里是有问题的，递归函数的return不能直接return到外面去
        return bfs(root,val);
    }
    public TreeNode bfs(TreeNode node,int val){
        if(val>node.val) {
            bfs(node.right,val);
        }
        if(val<node.val) {
            bfs(node.right,val);
        }
        if(val==node.val) {
            return node;
        }
        return null;
    }

    public TreeNode searchBST_1(TreeNode root, int val) {   //别人的代码 简洁明了
        if (root == null || root.val == val) return root;
        return root.val > val ? searchBST_1(root.left, val) : searchBST_1(root.right, val);
    }

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }
}
