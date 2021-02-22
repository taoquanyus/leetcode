class Solution {
    //这道题每次写都会崩溃
    //记下来
    public boolean search(int[] nums, int target) {
        //左右指针
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left+((right-left)>>1);//表示处以2
            if (nums[mid] == target) {
                return true;
            }
            //落在同一数组的情况，同时落在数组1 或 数组2
            if(nums[mid]==nums[left]){
                left++;
                continue;
            }
            if (nums[mid] > nums[left]) {
                //target 落在 left 和 mid 之间，则移动我们的right，完全有序的一个区间内查找
                if (nums[mid] > target && target >= nums[left]) {
                    right = mid - 1;
                    // target 落在right和 mid 之间，有可能在数组1， 也有可能在数组2
                } else if (target > nums[mid] || target < nums[left]) {
                    left = mid + 1;
                }
                //不落在同一数组的情况，left 在数组1， mid 落在 数组2
            }else if (nums[mid] < nums[left]) {
                //有序的一段区间，target 在 mid 和 right 之间
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                    // 两种情况，target 在left 和 mid 之间
                } else if (target < nums[mid] || target > nums[right]) {
                    right = mid - 1;
                }
            }
        }
        //没有查找到
        return false;
    }
}