public class Solution {
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

    //代码写得很乱很冗余
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode starter = new ListNode(0, head);
        ListNode ret = starter;
        if (left == right) return head;
        for (int i = 0; i < left - 1; i++) {//到达m的前一级
            starter = starter.next;
        }
        ListNode ans = starter;

        starter = starter.next;
        ListNode pre = starter.next;
        ListNode cur = pre.next;
        for (int i = left; i < right - 1; i++) {
            pre.next = starter;
            starter = pre;
            pre = cur;
            cur = cur.next;
        }
        pre.next = starter;
        ans.next.next = cur;
        ans.next = pre;
        return ret.next;
    }

    public ListNode reverseBetween2(ListNode head, int m, int n) {
        //答案的算法，思路和我相同

        // Empty list
        if (head == null) {
            return null;
        }

        // Move the two pointers until they reach the proper starting point
        // in the list.
        ListNode cur = head, prev = null;
        while (m > 1) {
            prev = cur;
            cur = cur.next;
            m--;
            n--;
        }

        // The two pointers that will fix the final connections.
        ListNode con = prev, tail = cur;

        // Iteratively reverse the nodes until n becomes 0.
        ListNode third = null;
        while (n > 0) {
            third = cur.next;
            cur.next = prev;
            prev = cur;
            cur = third;
            n--;
        }

        // Adjust the final connections as explained in the algorithm
        if (con != null) {
            con.next = prev;
        } else {
            head = prev;
        }

        tail.next = cur;
        return head;
    }
}
