import java.util.LinkedList;

public class Solution {
    public ListNode reverseList(ListNode head) {//看了答案后写的代码
        ListNode pre=null;
        ListNode con=head;
        return helper(con,pre);
    }

    private ListNode helper(ListNode con, ListNode pre) {
        if(con==null) return pre;
        ListNode temp=helper(con.next,con);
        con.next=pre;
        return temp;
    }


    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x){val=x;}
    }
}

