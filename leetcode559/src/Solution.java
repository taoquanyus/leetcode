import java.util.List;

public class Solution {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
    public int maxDepth(Node root){//这题太基础了
        if(root==null) return 0;
        return max(root.children)+1;
    }

    private int max(List<Node> nodes) {
        int a=0;
        for(Node node : nodes){
            a=Math.max(a,maxDepth(node));
        }
        return a;
    }
}
