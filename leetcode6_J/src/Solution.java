import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    List<Integer> list = new ArrayList<Integer>();

    public int[] reversePrint(ListNode head) {//我的代码，看到了链表就想递归
        if (head == null) return new int[0];
        ListNode pre = null;
        ListNode con = head;
        print_value(head, null);
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    private ListNode print_value(ListNode con, ListNode pre) {
        if (con == null) return pre;
        ListNode temp = print_value(con.next, con);
        list.add(con.val);
        return temp;
    }

    public int[] reversePrint2(ListNode head) {//题解，看到从后往前打印就应该想到用栈（后进先出）
        Stack<Integer> stack = new Stack<Integer>();
        ListNode temp = head;
        while (temp != null) {
            stack.push(temp.val);
            temp = temp.next;
        }
        int[] ans = new int[stack.size()];//这里必须要拿一个值等于栈的长度，因为栈的长度是会随着pop而变化的
        for(int i=0;i<stack.size();i++) {
            ans[i]=stack.pop();
        }
        return ans;
    }

    public int[] reversePrint3(ListNode head) {//第三种高效的方法，思路最简单。空间复杂度O(1);
                                                // 测试时还是最快的，大概是因为JAVA栈操作比较麻烦（费时间）吧
        //先获取链表长度，创建对应长度数组
        ListNode currNode = head;
        int len = 0;
        while(currNode != null){
            len ++;
            currNode = currNode.next;
        }
        int[] result = new int[len];

        //再次遍历链表，将值倒序填充至结果数组
        currNode = head;
        while(currNode != null){
            result[len - 1] = currNode.val;
            len --;
            currNode = currNode.next;
        }
        return result;
    }
}

