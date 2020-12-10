import java.util.List;

public class Solution {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList(ListNode head) {//我写的答案；
        ListNode pre=null,con=head;
        while(con!=null){
            ListNode tmp=con.next;
            con.next=pre;
            pre=con;
            con=tmp;
        }
        return pre;
    }

    public ListNode reverseList2(ListNode head) {//参考答案，递归,回溯法，值得学习
        return recur(head, null);
    }
    private ListNode recur(ListNode con,ListNode pre){
        if(con==null) return pre;
        ListNode res=recur(con.next,con);//如果是先递归再返回，用倒数第二层来思考solve的操作
        con.next=pre;
        return res;
    }
}
