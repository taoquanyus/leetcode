import java.util.LinkedList;
import java.util.List;

public class Solution {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x){val=x;}
    }
    public ListNode reverseList(ListNode head) {
        //迭代法
        if(head==null) return null;
        ListNode pre=new ListNode(0);
        pre.next=head;
        ListNode first=head.next;
        while(first.next!=null){
            ListNode second=first.next;
            first.next=head;
            head=first;
            first=second;
        }
        pre.next.next=null;
        return head;
    }
    public ListNode reverseList1(ListNode head) {
        //迭代法参考答案
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }


    public ListNode reverseList2(ListNode head) {
        //参考答案的递归法
        if(head==null||head.next==null) return head;
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }


    ListNode temp;
    ListNode ans;
    public ListNode reverseList3(ListNode head) {
        //我写的递归法，想的是穿针引线
        if(head==null) return null;
        reverse(head);
        temp.next=null;
        return ans;
    }

    private void reverse(ListNode head) {
        if(head.next==null){
            temp=head;
            ans=head;
            return;
        }
        reverse(head.next);
        temp.next=head;
        temp=temp.next;
    }
}

