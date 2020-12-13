import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){this.val=val;}
    }
    //没写出来，这道题应该是比较基础的才是
    int ans;
    public int sumOfLeftLeaves(TreeNode root){//看答案写的，深度优先搜索
        return root!=null? dfs(root):0;
    }

    private int dfs(TreeNode node) {
        int ans=0;
        if(node.left!=null){
            ans+= isLeafNode(node.left)?node.left.val:dfs(node.left);
        }
        if(node.right!=null){
            ans+= dfs(node.right);
        }
        return ans;
    }

    public boolean isLeafNode(TreeNode node){
        return node.left==null&&node.right==null;
    }

//广度优先搜索一般会用到队列
    public int sumOfLeftLeaves2(TreeNode root){//看答案写的，广度优先搜索
        if(root==null) return 0;
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        queue.offer(root);
        int ans=0;
        while(!queue.isEmpty()){
            TreeNode node=queue.poll();
            if(node.left!=null) {
                if (isLeafNode(node.left)) {
                    ans += node.left.val;
                } else {
                    queue.offer(node.left);
                }
            }
            if(node.right!=null){
                if(!isLeafNode(node.right)) queue.offer(node.right);
            }
        }
        return ans;
    }
}
