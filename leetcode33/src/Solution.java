public class Solution {
    //有史以来写得心态最崩的一道题
    public static void main(String[] args) {
        int nums[]=new int[]{3,5,1};

        int a=search(nums,5);
        System.out.println(a);
    }
    public static int search(int[] nums, int target){
        int point=findReverse(nums);
        if(nums.length==2){
            if(nums[0]==target) return 0;
            else if(nums[1]==target) return 1;
            else return -1;
        }
        int left = 0, right = nums.length - 1;
        if (point != -1) {
            if (target == nums[point]) return point;
            else if (target < nums[0]) {
                left = point + 1;
            } else {
                right = point - 1;
            }
        }
        while (left <= right) {
            point = (left + right) / 2;
            if (nums[point] < target) left = point + 1;
            else if (nums[point] > target) right = point - 1;
            else return point;
        }
        return -1;
    }

    private static int findReverse(int[] nums) {//二分法查找转折点的位置
        int left=0; int right=nums.length-1;
        int point=-1;
        while(left<right-1){
            point=(left+right)/2;
            if(nums[point]>nums[left]) left=point;
            else if (nums[point]<nums[left]) right=point;
        }
        point= nums[left]<nums[right]? left:right;
        if(point!=nums.length-1&&nums[point]>nums[point-1]) point=-1;
        return point;
    }
}
