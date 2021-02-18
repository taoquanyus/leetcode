public class Solution {
    //简单题，也可以使用双指针
    public void sortColors(int[] nums) {
        int count1=0;
        int count2=0;
        for(int num:nums){
            if(num==0)count1++;
            if(num==1)count2++;
        }
        count2+=count1;
        for(int i=0;i<count1;i++){
            nums[i]=0;
        }
        for(int i=count1;i<count2;i++){
            nums[i]=1;
        }
        for(int i=count2;i< nums.length;i++){
            nums[i]=2;
        }
    }
    //答案给的双指针法
    public void sortColors2(int[] nums) {
        int n = nums.length;
        int p0 = 0, p2 = n - 1;
        for (int i = 0; i <= p2; ++i) {
            while (i <= p2 && nums[i] == 2) {
                int temp = nums[i];
                nums[i] = nums[p2];
                nums[p2] = temp;
                --p2;
            }
            if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[p0];
                nums[p0] = temp;
                ++p0;
            }
        }
    }

}
