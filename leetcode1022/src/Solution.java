public class Solution {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){this.val=val;}
    }
    int answer=0;
    public int sumRootToLeaf(TreeNode root){//学着参考答案写的，乍一看不好写，用的也是bfs
        sum(root,0);
        return answer;
    }

    private void sum(TreeNode node, int con) {
        if(node==null) return;
        if(node.left==null&&node.right==null){
            answer+=con*2+node.val;
        }
        sum(node.left, 2*con+node.val);
        sum(node.right, 2*con+node.val);
    }
}
