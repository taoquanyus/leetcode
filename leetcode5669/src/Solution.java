public class Solution {
    public boolean canChoose(int[][] groups, int[] nums) {
        int nums_index=0;
        for(int[] group:groups){//找到每个数字匹配的数组
            if(contains(group,nums,nums_index)==-1)return false;
            nums_index=contains(group,nums,nums_index);
        }
        return true;
    }

    private int contains(int[] group, int[] nums, int nums_index) {
        if(nums_index>=nums.length-group.length) return -1;
        for(int i=nums_index;i<nums.length-group.length+1;++i){
            boolean flag=true;
            if(group[0]==nums[i]){//进入比对模式
                for(int j=0;j<group.length;j++){
                    if(group[j]!=nums[i+j]){
                        flag=false;
                        break;
                    }
                }
                if(flag)
                    return i+ group.length;
            }
        }
        return -1;
    }
}
