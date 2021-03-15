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
        String a="abcde";
        String b=a.substring(0,2);
        System.out.println(b);
    }

//    private static void change(String[] a) {
//        a[0]="hello2";
//    }

}
