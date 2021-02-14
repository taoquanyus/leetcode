public class Solution {
    public boolean canJump(int[] nums) {
        int n=nums.length-1;
        int cur=0;
        while(true){
            int step=nums[cur];//当前点跳跃的最大长度
            int diff=n-cur;//当前和终点的距离
            //向前走step，看看有没有合适的点
            if(diff<=step) break;
            if(step==0) return false;
            int best_next=0;
            int best_next_value=0;
            for(int i=1;i<=step;++i){//选择最佳路径进行跳跃
                if(nums[cur+i]+i>=best_next_value){
                    best_next=cur+i;
                    best_next_value=nums[cur+i]+i;
                }
            }
            cur=best_next;
        }
        return true;
    }
//答案的算法，比我的更简洁方便，贪心算法
    public boolean canJump2(int[] nums) {
        int n = nums.length;
        int rightmost = 0;
        for (int i = 0; i < n; ++i) {
            //它这里的代码写得很有意思，外面先套一个大循环，里面再用if判断
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }
    //是我我会改成这样
    public boolean canJump3(int[] nums) {
        int n = nums.length;
        int rightmost = 0;
        int i=0;
        while (i <= rightmost&&i<n) {
            rightmost = Math.max(rightmost, i + nums[i]);
            if (rightmost >= n - 1) {
                return true;
            }
            ++i;
        }
        return false;
    }

}
