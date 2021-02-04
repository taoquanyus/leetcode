

public class Solution {
    public class ListNode {
        //题目比较简单，但代码写得很冗余
        //代码冗余的原因是我对head进行操作，而范围starter.next，这样头链表就无法删除了
        //应该用starter进行操作删除
        //这道题还可以用栈
        //如果只能遍历一次的话可以使用双指针法
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode starter=new ListNode(0,head);
        if(head==null) return head;
        if(head.next==null) return null;
        int length=1;
        while(head.next!=null){//链表的长度
            length++;
            head=head.next;
        }
        head=starter.next;
        length=length-n+1;
        if(length==1){
            starter.next=starter.next.next;
            return starter.next;
        }
        for(int i=1;i<length-1;i++){
            head=head.next;
        }
        head.next=head.next.next;
        return starter.next;
    }
//使用双指针法，右指针总会比左指针大n，当右指针到头时，左指针就是目的地了
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode first = head;
        ListNode second = dummy;
        for (int i = 0; i < n; ++i) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        ListNode ans = dummy.next;
        return ans;
    }

}
