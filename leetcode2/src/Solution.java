public class Solution {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addNums(l1,l2,false);
    }

    private ListNode addNums(ListNode l1, ListNode l2, boolean plus) {
        //plus 表示是否有进位，true为进位，false表示不进位
        ListNode ans=new ListNode(0);
        boolean nextplus=false;
        if(plus)
            ans.val = ans.val + 1;
        if(l1==null&&l2!=null){
            ans.val+=l2.val;
            if(ans.val>=10){
                nextplus=true;
                ans.val-=10;
                ans.next=addNums(null,l2.next,nextplus);
            }
            else{
                ans.next=l2.next;
            }
            return ans;
        }
        if(l1!=null&&l2==null){
            ans.val+=l1.val;
            if(ans.val>=10){
                nextplus=true;
                ans.val-=10;
                ans.next=addNums(l1.next,null,nextplus);
            }
            else {
                ans.next=l1.next;
            }
            return ans;
        }
        if(l1==null&&l2==null){
            if(ans.val==0)return null;
            return ans;
        }
        ans.val+=l1.val+l2.val;
        if(ans.val>=10){
            nextplus=true;
            ans.val-=10;
        }
        ans.next=addNums(l1.next,l2.next,nextplus);
        return ans;
    }
}
