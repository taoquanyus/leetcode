import java.util.LinkedList;
import java.util.PriorityQueue;
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

    public int findSecondMinimumValue(TreeNode root) {//应该利用bfs 找不同#这种想法其实是错误的
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) return -1;
        queue.offer(root);
        int num = root.val;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.val != num) return node.val;
            else {
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
        return -1;
    }

    //找不同的思想其实是错的,还是需要遍历
    PriorityQueue<Integer> queue = new PriorityQueue<>();
    public int findSecondMinimumValue2(TreeNode root) {//利用dfs
        dfs(root);
        int root_num=root.val;
        while(!queue.isEmpty()){
            int tar=queue.poll();
            if(tar!=root_num) return tar;
        }
        return -1;
    }

    private void dfs(TreeNode node) {
        if(node==null) return;
        else{
            queue.add(node.val);
            dfs(node.right);
            dfs(node.left);
        }
    }

    public int findSecondMinimumValue3(TreeNode root) {//利用bfs
        Queue<TreeNode> queue1=new LinkedList<>();
        queue1.offer(root);
        while(!queue1.isEmpty()){
            TreeNode node= queue1.poll();
            if(node!=null){
                queue.add(node.val);
                queue1.offer(node.left);
                queue1.offer(node.right);
            }
        }
        int root_num=root.val;
        while(!queue.isEmpty()){
            int tar=queue.poll();
            if(tar!=root_num) return tar;
        }
        return -1;
    }
}
