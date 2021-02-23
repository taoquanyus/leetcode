public class Solution {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode partition(ListNode head, int x) {
        ListNode point=new ListNode();
        ListNode pre=new ListNode(0,head);
        if(head==null||head.next==null) return head;
        if(head.val>=x){
            point=pre;
        }
        else {
            while (head.next!=null){
                if(head.next.val>=x){
                    point=head;
                    break;
                }
                head=head.next;
            }
        }
        while(head.next!=null){
            if(head.next.val<x){
                ListNode temp=point.next;
                point.next=head.next;
                head.next=head.next.next;
                point.next.next=temp;
                point=point.next;
                continue;
            }
            head=head.next;
        }
        return pre.next;
    }
//参考答案
    //链表的虽然是引用类型，但是small和smallHead都表示链表的指针
    //如果small=small.next，表示名为small的指针指向了下一个，而无关smallHead的事
    public ListNode partition2(ListNode head, int x) {
        ListNode small = new ListNode(0);
        ListNode smallHead = small;
        ListNode large = new ListNode(0);
        ListNode largeHead = large;
        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                large.next = head;
                large = large.next;
            }
            head = head.next;
        }
        large.next = null;
        small.next = largeHead.next;
        return smallHead.next;
    }
}
