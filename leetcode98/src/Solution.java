import java.util.Deque;
import java.util.LinkedList;

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
//我的答案写错了，BST的右子树的左叶也不能小于根节点
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        return dfs(root.val, root.left, 0) && dfs(root.val, root.right, 1);
    }

    private boolean dfs(int lastVal, TreeNode root, int leftOrRight) {
        if (root == null) return true;
        if ((leftOrRight == 0 && root.val > lastVal)
                || (leftOrRight == 1 && root.val < lastVal))
            return false;
        return dfs(root.val, root.left, 0) && dfs(root.val, root.right, 1);
    }

//递归法 参考答案
//非常简单，给范围即可
    public boolean isValidBST2(TreeNode root) {
        return isValidBST2(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST2(TreeNode node, long lower, long upper) {
        if (node == null) {
            return true;
        }
        if (node.val <= lower || node.val >= upper) {
            return false;
        }
        return isValidBST2(node.left, lower, node.val) && isValidBST2(node.right, node.val, upper);
    }
    //参考答案二
    //中序遍历
    //漂亮啊
    public boolean isValidBST3(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        double inorder = -Double.MAX_VALUE;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            // 如果中序遍历得到的节点的值小于等于前一个 inorder，说明不是二叉搜索树
            if (root.val <= inorder) {
                return false;
            }
            inorder = root.val;
            root = root.right;
        }
        return true;
    }
}
