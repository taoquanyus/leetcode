import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){this.val=x;}
    }
    public boolean findTarget(TreeNode root, int k){//利用hashset，重复元素不会被添加
        //但是这里其实没有用到二叉搜索树的特性
        Set<Integer> hashset=new HashSet<>();
        return find(hashset,root,k);
    }

    private boolean find(Set<Integer> hashset, TreeNode root, int k) {
        if(root==null) return false;
        if(hashset.contains(k-root.val)) return true;
        hashset.add(root.val);
        return find(hashset,root.left,k)||find(hashset,root.right,k);
    }

        public boolean findTarget2(TreeNode root, int k) {//广度优先算法遍历二叉树
            Set < Integer > hashset = new HashSet();
            Queue< TreeNode > queue = new LinkedList();
            queue.add(root);
            while(!queue.isEmpty()){
                if(queue.peek()!=null){
                    TreeNode node=queue.remove();
                    if(hashset.contains(k-node.val)) return true;
                    hashset.add(node.val);
                    queue.add(node.left);
                    queue.add(node.right);
                }
                else queue.remove();
            }
            return false;
        }
}
