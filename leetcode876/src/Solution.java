public class Solution {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode middleNode(ListNode head) {//我的代码，单指针法
        ListNode con=head;
        int length=0;
        while(con!=null){
            length++;
            con=con.next;
        }
        con=head;
        for(int i=0;i<=length/2;i++) con=con.next;
        return con;
    }
    public ListNode middleNode2(ListNode head) {//答案的快慢指针做法，但其实复杂度一样
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
