public class Solution {
    //2.7周赛
    public static void main(String[] args) {
        int[] nums=new int[]{2,2,3};
        System.out.println(check(nums));
    }
    public static boolean check(int[] nums) {
        int min=Integer.MAX_VALUE;
        int point=0;
        for(int i=0;i<nums.length;++i){
            if(nums[i]<=nums[point]){
                min=nums[i];
                point=i;
            }
        }

        for(int i=point-1;i>0;--i){//全部大于前者
            if(nums[i]==nums[point]) continue;
            if(nums[i]<nums[i-1]) return false;
        }

        for(int i=point+1;i<nums.length;++i){
            if(nums[i]<nums[i-1])return false;
        }

        if(nums[0]!=nums[point]&&nums[nums.length-1]>nums[0]) return false;
        return true;
    }
}
