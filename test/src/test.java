import java.util.*;

public class test {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static void main(String[] args) {
        ListNode a=new ListNode(0);
        ListNode b=a;
        a.next=new ListNode(2);
        a.val=10;
        System.out.println(a.val);
        System.out.println(a);
        System.out.println(b.val);
        System.out.println(b);
        a=a.next;
        System.out.println(a.val);
        System.out.println(a);
        System.out.println(b.val);
        System.out.println(b);
    }

//    private static void change(String[] a) {
//        a[0]="hello2";
//    }

}
