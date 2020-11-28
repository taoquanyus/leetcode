public class Solution {
    int ans;
    //这道题值得思考边界：子节点和父节点的值是相等的
    public int rangeSumBST(TreeNode root, int L, int R){//我写的答案
        ans=0;
        dfs(root,L,R);
        return ans;
    }
    public void dfs(TreeNode node, int L, int R) {
        if (node != null) {
            if (L <= node.val && node.val <= R){    //因此在这里加=
                ans += node.val;
                dfs(node.left, L, R);
                dfs(node.right, L, R);
            }
            if (L > node.val)   //这里不加
                dfs(node.right, L, R);
            if (node.val > R)
                dfs(node.left, L, R);
        }
    }


    public int rangeSumBST1(TreeNode root, int L, int R){//官方给的参考答案
        ans=0;
        dfs1(root,L,R);
        return ans;
    }
    public void dfs1(TreeNode node, int L, int R) {
        if (node != null) {
            if (L <= node.val && node.val <= R)
                ans += node.val;
            if (L < node.val)
                dfs(node.left, L, R);
            if (node.val < R)
                dfs(node.right, L, R);
        }
    }



}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}