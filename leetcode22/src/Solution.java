import java.util.ArrayList;
import java.util.List;

public class Solution {
    //方法一：最朴素的方法，先生成个2^(2n)个不同的排列组合，再逐个判断是否满足条件
    //这里比较难理解的是如何生成所有的不同的排列组合：
    //使用到了递归的思想：
    //所有长度为n的序列是所有长度为n-1的字符串前面加0/1的集合（这个思想很重要！！！）
    public static void main(String[] args) {
        int n=3;
        List<String> a=generateParenthesis(n);
        for(String b:a){
            System.out.println(b);
        }
    }
    public static List<String> generateParenthesis(int n) {
        List<String> list=new ArrayList<>();
        GenerateSequence(list,0,new char[2*n]);
        return list;
    }
    public static void GenerateSequence(List<String> list, int pos, char[] current){
        if(pos!=current.length){
            current[pos]='(';
            GenerateSequence(list,pos+1,current);
            current[pos]=')';
            GenerateSequence(list,pos+1,current);
        }
        if(pos==current.length){
            if(vaild(current)){
                list.add(new String(current));
            }
        }
    }

    private static boolean vaild(char[] current) {
        int balance=0;
        for(char i:current){
            if (i=='(')
                ++balance;
            if(i==')')
                --balance;
            if(balance<0) return false;
        }
        return balance==0;
    }

    //方法二：回溯法
    // 可以只在序列仍然保持有效时才添加 '(' 和 ')'，
    // 而不是像 方法一 那样每次添加 可以通过跟踪到目前为止放置的左括号和右括号的数目来做到这一点，
    //如果左括号数量不大于 n，我们可以放一个左括号。
    // 如果右括号数量小于左括号的数量，我们可以放一个右括号。

    public static List<String> generateParenthesis2(int n) {
        List<String> ans = new ArrayList<String>();
        backtrack(ans, new StringBuilder(), 0, 0, n);
        return ans;

    }

    public static void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max) {
        if (cur.length() == max * 2) {
            ans.add(cur.toString());
            return;
        }
        if (open < max) {
            cur.append('(');
            backtrack(ans, cur, open + 1, close, max);
            cur.deleteCharAt(cur.length() - 1);//回溯法的精髓在这里
        }
        if (close < open) {
            cur.append(')');
            backtrack(ans, cur, open, close + 1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}
