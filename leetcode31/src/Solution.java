import java.util.Arrays;

public class Solution {//终于AC了，真是不容易
    //和答案的算法相同，但是答案是分模块写的，swap和reverse都应该写成函数;
    public static void main(String[] args) {
        int[] nums=new int[]{1,3,2};
        nextPermutation(nums);
    }
    public static void nextPermutation(int[] nums) {
        int flag=100;
        for(int i=nums.length-2;i>=0;--i){
            for(int j=nums.length-1;j>i;j--){
                if(nums[j]>nums[i]){
                    int temp=nums[j];
                    nums[j]=nums[i];
                    nums[i]=temp;
                    //交换完后，后面的数字应该是最小的数,这里要写一个排序算法，在i+1到j中
                    //重新写一下排序，应该就没问题了

                    for(int k=i+1;i<(nums.length+i)/2;k++){
                        temp=nums[k];
                        nums[k]=nums[nums.length-k+i];
                        nums[nums.length-k+1]=temp;
                    }
                    return;
                }
            }
        }
        for(int i=0;i<nums.length/2;i++){
            int temp=nums[i];
            nums[i]=nums[nums.length-1-i];
            nums[nums.length-1-i]=temp;
        }
        return;
    }
}
