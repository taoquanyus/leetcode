import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public Solution() {
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
        //关于这里方法的static的解释，如果没有static，必须要经过实例化才能调用
        //如果加上了static，可以不实例化，直接用类名.方法调用
    }
}