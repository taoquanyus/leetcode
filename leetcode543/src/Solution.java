public class Solution {
    public class TreeNode {
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

    //我写的答案，超出了时间限制
    public int diameterOfBinaryTree(TreeNode root) {
        //左边的深度加上右边的深度
        if (root == null) return 0;
        int cur = Depth(root.left) + Depth(root.right);
        if (cur < diameterOfBinaryTree(root.left) || cur < diameterOfBinaryTree(root.right))
            return Math.max(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right));
        return cur;
    }

    private int Depth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(Depth(root.right), Depth(root.left));
    }

    //参考答案，深度优先搜索
    //巧妙就巧妙在这个全局变量ans
    int ans;
    public int diameterOfBinaryTree2(TreeNode root) {
        ans = 1;
        depth(root);
        return ans - 1;
    }

    public int depth(TreeNode node) {
        if (node == null) {
            return 0; // 访问到空节点了，返回0
        }
        int L = depth(node.left); // 左儿子为根的子树的深度
        int R = depth(node.right); // 右儿子为根的子树的深度
        ans = Math.max(ans, L + R + 1); // 计算d_node即L+R+1 并更新ans
        return Math.max(L, R) + 1; // 返回该节点为根的子树的深度
    }
}
