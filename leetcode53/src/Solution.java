public class Solution {
    public int maxSubArray(int[] nums){//我写的代码，里面很明显有许多冗余
        int ans=0;
        int conans=Integer.MIN_VALUE;
        for(int i=0;i<=nums.length-1;i++){
            conans=Math.max(nums[i],conans);
        }
        if(conans<=0) return conans;
        conans=0;
        for(int i=0;i<=nums.length-1;i++){
            conans+=nums[i];
            if(conans<=0) conans=0;
            ans=Math.max(ans,conans);
        }
        return  ans;
    }

    public int maxSubArray2(int[] nums){//参考答案，这里用到了动态规划的思想
        int pre=0;
        int ans=nums[0];
        for(int num :nums){
            pre=Math.max(num,pre+num);
            ans=Math.max(ans,pre);
        }
        return ans;
    }
}
