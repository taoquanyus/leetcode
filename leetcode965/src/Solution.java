import java.util.ArrayList;
import java.util.List;

public class Solution {
    public class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(int x){
            val=x;
        }
    }

    public boolean isUnivalTree(TreeNode root){//递归法
        boolean left_correct=(root.left==null||root.val==root.left.val&&isUnivalTree(root.left));
        boolean right_correct=(root.right==null||root.val==root.right.val&&isUnivalTree(root.left));
        return left_correct&&right_correct;
    }
    List<Integer> vals;
    public boolean isUnivalTree2(TreeNode root){//深度优先搜索
        vals=new ArrayList<>();
        dfs(root);
        for(int val :vals ){
            if(val!= vals.get(0)) return false;
        }
        return true;
    }

    private void dfs(TreeNode node) {
        if(node!=null){
            vals.add(node.val);
            dfs(node.left);
            dfs(node.right);
        }
    }
}
