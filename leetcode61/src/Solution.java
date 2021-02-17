public class Solution {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null||k==0||head.next==null)return head;
        int length=1;
        ListNode pre=new ListNode(0,head);
        while(head.next!=null){
            head=head.next;
            length++;
        }
        head.next=pre.next;
        for(int i=0;i<length-k%length;++i){
            pre=pre.next;
        }
        head=pre.next;
        pre.next=null;
        return head;
    }
    //答案的思路，和我的完全一样，只是我维护的是pre链表，它维护的是head链表
    public ListNode rotateRight2(ListNode head, int k) {
        // base cases
        if (head == null) return null;
        if (head.next == null) return head;

        // close the linked list into the ring
        ListNode old_tail = head;
        int n;
        for(n = 1; old_tail.next != null; n++)
            old_tail = old_tail.next;
        old_tail.next = head;

        // find new tail : (n - k % n - 1)th node
        // and new head : (n - k % n)th node
        ListNode new_tail = head;
        for (int i = 0; i < n - k % n - 1; i++)
            new_tail = new_tail.next;
        ListNode new_head = new_tail.next;

        // break the ring
        new_tail.next = null;

        return new_head;
    }
}
