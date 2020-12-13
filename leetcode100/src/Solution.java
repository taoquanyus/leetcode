import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {//广度优先搜索
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.add(p);
        queue2.add(q);
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            TreeNode node1 = queue1.poll();
            TreeNode node2 = queue2.poll();
            TreeNode left1 = node1.left, left2 = node2.left;
            TreeNode right1 = node2.left, right2 = node2.right;
            if (node1.val != node2.val) return false;
            if (left1 == null ^ left2 == null) return false;
            if (right1 == null ^ right2 == null) return false;
            if (left1 != null) queue1.add(left1);
            if (left2 != null) queue2.add(left2);
            if (right1 != null) queue1.add(right1);
            if (right2 != null) queue2.add(right2);
        }
        return queue1.isEmpty() && queue2.isEmpty();
    }

    public boolean isSameTree2(TreeNode p, TreeNode q) {//深度优先搜索
        if(p==null^q==null) return false;
        if(p==null&&q==null) return true;
        if(p.val== q.val){
            return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
        }
        else return false;
    }
}
