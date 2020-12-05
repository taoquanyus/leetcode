import java.util.LinkedList;
import java.util.Queue;

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

    public int minDepth(TreeNode root) {   //深度优先搜索
        if(root==null)return 0;//已经是底部了
        if(root.left==null&&root.right==null) return 1;//下一层就到底了
        int min_depth =Integer.MAX_VALUE;//看代码的时候一直在纠结这里为什么新建一个max_value，
                                        // 但其实它不重要，因为它必被取代
        if(root.left!=null) min_depth =Math.min(min_depth,minDepth(root.left));//求下一层的最小深度
        if(root.right!=null) min_depth =Math.min(min_depth,minDepth(root.right));
        return min_depth +1;
    }
///////////////////////////////////////////////////////////////////////////////////////////
    class QueueNode {//广度优先搜索
        TreeNode node;
        int depth;

        public QueueNode(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    public int minDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<QueueNode> queue = new LinkedList<QueueNode>();
        queue.offer(new QueueNode(root, 1));
        while (!queue.isEmpty()) {
            QueueNode nodeDepth = queue.poll();
            TreeNode node = nodeDepth.node;
            int depth = nodeDepth.depth;
            if (node.left == null && node.right == null) {//判断是否为叶子节点
                return depth;
            }
            if (node.left != null) {
                queue.offer(new QueueNode(node.left, depth + 1));
            }
            if (node.right != null) {
                queue.offer(new QueueNode(node.right, depth + 1));
            }
        }
        return 0;
    }
}
