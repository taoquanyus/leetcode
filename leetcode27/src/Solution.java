public class Solution {
    public int removeElement(int[] nums, int val){//利用了快慢指针
        int i=0; int j;
        for(j=0;j<nums.length;j++){
            if (nums[j]!=val){
                nums[i]=nums[j];
                i++;
            }
        }
        return i;
    }
    public int removeElement1(int[] nums,int val){//利用了收尾指针
        int i=0;int j=nums.length;
        while(i<j){
            if(nums[i]==val){
                nums[i]=nums[j-1];
                j--;
            }
            else
                i++;
        }
        return j;
    }
}
