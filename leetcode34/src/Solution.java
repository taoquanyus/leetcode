public class Solution {
    public int[] searchRange(int[] nums, int target) {
        //很简单，先二分法找数，然后双指针取范围
        if(nums.length==0) return new int[]{-1,-1};
        int left=0,right=nums.length-1;
        int point=0;
        while(left<=right){
            point=(left+right)/2;
            if(nums[point]>target)right=point-1;
            if(nums[point]<target)left=point+1;
            if(nums[point]==target)break;
        }
        if(nums[point]!=target) return new int[]{-1,-1};
        left=point;
        right=point;
        while(left!=0&&nums[left-1]==target){
            left--;
        }
        while(right!=nums.length-1&&nums[right+1]==target){
            right++;
        }
        return new int[]{left,right};
    }
}
