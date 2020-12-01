public class Solution {
    public static void main(String[] args) {
        int s = 15;
        int[] nums = {1, 2, 3, 4, 5};
        System.out.println(minSubArrayLen(s, nums));
    }

    public static int minSubArrayLen(int s, int[] nums) {//我的方法，用的是滑动窗口，但效率极低
        for (int i = 1; i <= nums.length; i++) {//窗口大小
            int sum = 0;
            for (int k = 0; k <= i - 1; k++) {
                sum = sum + nums[k];
            }
            if (sum >= s) return i;
            for (int j = 0; j <= nums.length - i - 1; j++) {//遍历
                sum = sum - nums[j] + nums[j + i];
                if (sum >= s) return i;
            }
        }
        return 0;
    }

    public int minSubArrayLen1(int s, int[] nums) {//参考答案，使用双指针
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int start = 0, end = 0;
        int sum = 0;
        while (end < n) {
            sum += nums[end];
            while (sum >= s) {
                ans = Math.min(ans, end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

}
