public class Solution {
    public int searchInsert(int[] nums,int target){//我的方法，和答案写得基本一致
        int left=0,right=nums.length-1;

        while (left<=right){
            int i=(left+right)/2;   //把i定义在循环体内会更加地节省内存
            if(nums[i]==target){
                return i;
            }
            if(nums[i]<target) left=i+1;
            else right=i-1;
        }
        return left;
    }

}
