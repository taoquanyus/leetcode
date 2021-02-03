import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] nums={-1,2,1,-4};
        int target=1;
        System.out.println(threeSumClosest(nums,target));
    }
    public static int threeSumClosest(int[] nums, int target){
        //先排序，再处理吗？
        Arrays.sort(nums);
        int n=nums.length;
        int difference=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(i>1&&nums[i]==nums[i-1])continue;
            int target1=target-nums[i];
            for(int j=i+1;j<n;++j){
                if(j>i+1&&nums[j]==nums[j-1]) continue;
                int target2=target1-nums[j];
                for(int k=j+1;k<n;k++){
                    if(k>j+1&&nums[k]==nums[k-1])continue;
                    if(Math.abs(nums[k]-target2)<Math.abs(difference)) difference=target2-nums[k];
                    if(difference==0) return target;
                }
            }
        }
        return target-difference;
    }

    //方法和我的相似，但是移动双指针的做法非常巧妙
    //一开始我认为不能轻易移动指针，但是它可以限制在while(j<k)语句中
    public int threeSumClosest2(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int best = 10000000;

        // 枚举 a
        for (int i = 0; i < n; ++i) {
            // 保证和上一次枚举的元素不相等
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 使用双指针枚举 b 和 c
            int j = i + 1, k = n - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                // 如果和为 target 直接返回答案
                if (sum == target) {
                    return target;
                }
                // 根据差值的绝对值来更新答案
                if (Math.abs(sum - target) < Math.abs(best - target)) {
                    best = sum;
                }
                if (sum > target) {
                    // 如果和大于 target，移动 c 对应的指针
                    int k0 = k - 1;
                    // 移动到下一个不相等的元素
                    while (j < k0 && nums[k0] == nums[k]) {
                        --k0;
                    }
                    k = k0;
                } else {
                    // 如果和小于 target，移动 b 对应的指针
                    int j0 = j + 1;
                    // 移动到下一个不相等的元素
                    while (j0 < k && nums[j0] == nums[j]) {
                        ++j0;
                    }
                    j = j0;
                }
            }
        }
        return best;
    }

}
