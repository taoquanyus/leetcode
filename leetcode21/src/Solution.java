/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {        //我写的答案，没有跑过
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode curr1 = null;
        ListNode p1 = l1;
        ListNode p2 = l2;

        if (p1 == null && p2 == null) return p1;

        ListNode curr = curr1;
        while (true) {
            if (p1.val <= p2.val) {
                curr.next = p1;
                p1 = p1.next;
                curr = curr.next;
            } else {
                curr.next = p2;
                p2 = p2.next;
                curr = curr.next;
            }
            if (p1 == null) {
                curr.next = p2;
                return curr1.next;
            }
            if (p2 == null) {
                curr.next = p1;
                return curr1.next;
            }
        }
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }



    class Solution2 {           //参考答案
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode prehead = new ListNode(-1);

            ListNode prev = prehead;
            while (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    prev.next = l1;
                    l1 = l1.next;
                    prev = prev.next;
                } else {
                    prev.next = l2;
                    l2 = l2.next;
                    prev = prev.next;
                }
            }

            // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
            prev.next = l1 == null ? l2 : l1;

            return prehead.next;
        }
    }
}
