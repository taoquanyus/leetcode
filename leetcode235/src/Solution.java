import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    Stack<TreeNode> stack1 = new Stack<>();
    Stack<TreeNode> stack2 = new Stack<>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {//使用栈的想法是错误的
        dfs1(root, p);
        dfs2(root, q);
        while (true) {
            TreeNode a = stack1.pop();
            stack2.pop();
            if (stack2.isEmpty() || stack1.isEmpty()) return a;
        }
    }

    //自己写的代码，想利用栈来解决问题，但是是错误的
    private boolean dfs1(TreeNode node, TreeNode p) {//利用递归函数找到子树的位置
        stack1.push(node);
        if (p == null) return true;
        Stack stack1_Dub = stack1;
        if (node != null) {
            if (node.val == p.val) {
                if (dfs1(node.left, p.left) && dfs1(node.right, p.right)) return true;
            }
            stack1 = stack1_Dub;
            dfs1(node.left, p);
            dfs1(node.right, p);
        } else return false;
        return false;
    }

    private boolean dfs2(TreeNode node, TreeNode q) {
        stack2.push(node);
        if (q == null) return true;
        Stack stack2_Dub = stack2;
        if (node != null) {
            if (node.val == q.val) {
                if (dfs2(node.left, q.left) && dfs2(node.right, q.right)) return true;
            }
            stack2 = stack2_Dub;
            dfs2(node.left, q);
            dfs2(node.right, q);
        } else return false;
        return false;

    }

    //答案的代码，其实用不用栈都一样，太想当然了，而且判断树是否相等可以直接通过=来判断，不用再用值到更底层来判断（简直愚蠢！！！）。
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> path_p = getPath(root, p);
        List<TreeNode> path_q = getPath(root, q);
        TreeNode ancestor = null;
        for (int i = 0; i < path_p.size() && i < path_q.size(); ++i) {
            if (path_p.get(i) == path_q.get(i)) {
                ancestor = path_p.get(i);
            } else {
                break;
            }
        }
        return ancestor;
    }

    public List<TreeNode> getPath(TreeNode root, TreeNode target) {
        List<TreeNode> path = new ArrayList<TreeNode>();
        TreeNode node = root;
        while (node != target) {
            path.add(node);
            if (target.val < node.val) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        path.add(node);
        return path;
    }
}
