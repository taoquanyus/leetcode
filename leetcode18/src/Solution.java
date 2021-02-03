import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int first = 0; first < nums.length-3; ++first) {
            if (first > 0 && nums[first] == nums[first - 1]) continue;
            for (int second = first + 1; second < nums.length-2; ++second) {
                if (second > first + 1 && nums[second] == nums[second - 1]) continue;
                int target1 = target - nums[first] - nums[second];
                for (int third = second + 1; third < nums.length-1; third++) {
                    if (third > second + 1 && nums[third] == nums[third - 1]) continue;
                    int forth = nums.length - 1;

                    while (third < forth && nums[third] + nums[forth] > target1) {
                        forth--;
                    }
                    if (third == forth) break;
                    if (nums[third] + nums[forth] == target1) {
                        ans.add(Arrays.asList(nums[first], nums[second], nums[third], nums[forth]));
//                        List<Integer> temp = new ArrayList<>();
//                        temp.add(nums[first]);
//                        temp.add(nums[second]);
//                        temp.add(nums[third]);
//                        temp.add(nums[forth]);
//                        ans.add(temp);
                    }
                }
            }
        }
        return ans;
    }
}
