import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val=val;
        }
    }

    public boolean isSubtree(TreeNode s, TreeNode t){//这里用bfs
        Queue<TreeNode> queue=new LinkedList<>();
        if(s==null&&t==null) return true;
        queue.offer(s);
        while(!queue.isEmpty()){
            TreeNode node=queue.poll();
            if(node.val==t.val){
                if(verify(node,t)) return true;
            }
            if(node.left!=null) queue.offer(node.left);
            if(node.right!=null) queue.offer(node.right);

        }
        return false;
    }

    private boolean verify(TreeNode node, TreeNode t) {//这里用dfs
        if(t==null&&node==null) return true;
        if(node==null^t==null) return false;
        if(node.val!=t.val) return false;
        else{
            return verify(node.left, t.left)&&verify(node.right, t.right);
        }
    }
}
