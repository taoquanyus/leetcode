public class Solution {
    public int longestUnivaluePath(TreeNode root) {
        if (root != null) {
            int answer = 0;
            if (root.val != root.left.val && root.val != root.right.val) {
                answer = Math.max(longestUnivaluePath(root.left), longestUnivaluePath((root.right)));
            }
            if (root.val == root.left.val && root.val == root.right.val) {
                answer = longestUnivaluePath(root.left) + longestUnivaluePath((root.right)) + 1;
            }
            if (root.val != root.left.val && root.val == root.right.val) {
                answer = longestUnivaluePath((root.right)) + 1;
            }
            if (root.val == root.left.val && root.val != root.right.val) {
                answer = longestUnivaluePath((root.left)) + 1;
            }
            return answer;
        }
        return 0;
    }
    int ans;
    public int longestUnivaluePath1(TreeNode root) {//参考答案
        ans = 0;
        arrowLength(root);//尽管这里的arrowLength是int型，但主函数没有接受它的值，int型存在的意义
                            // 就在于递归能够用到
        return ans;
    }

    public int arrowLength(TreeNode node) {
        if (node == null) return 0;
        int left = arrowLength(node.left);
        int right = arrowLength(node.right);
        int arrowLeft = 0, arrowRight = 0;
        if (node.left != null && node.left.val == node.val) {
            arrowLeft += left + 1;
        }
        if (node.right != null && node.right.val == node.val) {
            arrowRight += right + 1;
        }
        ans = Math.max(ans, arrowLeft + arrowRight);
        return Math.max(arrowLeft, arrowRight);//这里设计递归的时候的，返回值和ans是分开的
    }

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

}
