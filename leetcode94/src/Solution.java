import java.util.ArrayList;
import java.util.List;

public class Solution {
    //中序遍历
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

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        if(root==null) return ans;
        //左右都为空
        if(root.left==null&&root.right==null){
            ans.add(root.val);
            return ans;
        }
        //左边为空
        if(root.left==null){
            ans.add(root.val);
            ans.addAll(inorderTraversal(root.right));
            return ans;
        }
        //右边为空
        if(root.right==null){
            ans.addAll(inorderTraversal(root.left));
            ans.add(root.val);
            return ans;
        }
        //其它（两边都不为空）
        ans.addAll(inorderTraversal(root.left));
        ans.add(root.val);
        ans.addAll(inorderTraversal(root.right));
        return ans;
    }

    //参考答案
    public List<Integer> inorderTraversal2(TreeNode root) {
        //完全不给你多bb
        List<Integer> res = new ArrayList<Integer>();
        inorder(root, res);
        return res;
    }

    public void inorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }
}
