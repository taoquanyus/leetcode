public class Solution {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode swapPairs(ListNode head) {
        ListNode starter=new ListNode(0,head);
        ListNode temp=starter;

        while(temp.next!=null&&temp.next.next!=null){//保证了后面两个都不是空
            swap(temp);
            temp=temp.next.next;
        }
        return starter.next;
    }

    private void swap(ListNode head) {
        ListNode temp=head.next;
        head.next=head.next.next;
        temp.next=head.next.next;
        head.next.next=temp;
    }
//这是我写的递归
    public ListNode swapPairs2(ListNode head){
        if(head==null||head.next==null) return head;
        ListNode con=swapPairs2(head.next.next);
        ListNode starter=new ListNode(0,head);
        ListNode temp=starter.next;
        starter.next=starter.next.next;
        starter.next.next=temp;
        starter.next.next.next=con;
        return starter.next;
    }
    //争取答案的递归
    public ListNode swapPairs3(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //这样写的话更简练，不用再建立头节点
        ListNode newHead = head.next;
        head.next = swapPairs(newHead.next);
        newHead.next = head;
        return newHead;
    }
}
