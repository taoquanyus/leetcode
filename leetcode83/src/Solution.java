import java.util.HashMap;

public class Solution {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public ListNode deleteDuplicates(ListNode head) {//我写的代码，有些冗余，但没有看清楚题，
        // 答案写的排过序的链表，其实不需要用hashmap；
        HashMap<Integer, Integer> hashmap = new HashMap<Integer, Integer>();
        if (head == null) return null;
        hashmap.put(head.val, 1);
        ListNode pre = head, con = head.next;
        while (con != null) {
            if (hashmap.containsKey(con.val)) pre.next = con.next;
            else {
                hashmap.put(con.val, 1);
                pre = con;
            }
            con = con.next;
        }
        return head;
    }


    public ListNode deleteDuplicate(ListNode head) {//看清楚题目后写的
        if (head == null) return null;
        ListNode pre = head, con = head.next;
        while (con != null) {
            if (con.val == pre.val) pre.next = con.next;
            else pre = con;
            con = con.next;
        }
        return head;
    }


    public ListNode deleteDuplicate3(ListNode head) {//参考答案，省了一个变量，而且不用预先判断head是否为空
        ListNode current = head;//写得确实要比我写得精炼得多
        while (current != null && current.next != null) {
            if (current.next.val == current.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }
}
