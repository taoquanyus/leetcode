import java.util.*;

public class Solution {
    //筚路蓝缕
    List<List<Integer>> ans = new ArrayList<>();
    HashSet<Integer> hashSet = new HashSet<>();

    public List<List<Integer>> threeSum(int[] nums) {
        int length = nums.length;
        if(nums.length==3&&nums[0]+nums[1]==-nums[2]){
            List<Integer> temp=new ArrayList<>(Arrays.asList(nums[0],nums[1],nums[2]));
            ans.add(temp);
        }
        for (int i = 0; i < length - 3; ++i) {
            if(!hashSet.contains(nums[i])){
                twoSum(Arrays.copyOfRange(nums, i + 1, length), -nums[i]);
                hashSet.add(nums[i]);
            }
        }
        return ans;
    }

    private void twoSum(int[] nums, int target) {
        HashMap<Integer, Boolean> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            if(hashSet.contains(nums[i])) continue;
            if (hashMap.containsKey(target - nums[i])) {
                if (hashMap.get(target - nums[i]) == true) {//判断是否用过，如果没有用过
                    List<Integer> temp = new ArrayList<>(Arrays.asList(-target, target - nums[i], nums[i]));//添加数组
                    ans.add(temp);
                    hashMap.put(target - nums[i], false);
                    hashMap.put(nums[i], false);
                }
            } else {
                hashMap.put(nums[i], true);
            }
        }
    }
    //参考答案，先排了序
    //没有想到这种做法
    public List<List<Integer>> threeSum2(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // 枚举 a
        for (int first = 0; first < n; ++first) {
            // 需要和上一次枚举的数不相同
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            // c 对应的指针初始指向数组的最右端
            int third = n - 1;
            int target = -nums[first];
            // 枚举 b
            for (int second = first + 1; second < n; ++second) {
                // 需要和上一次枚举的数不相同
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                // 需要保证 b 的指针在 c 的指针的左侧
                while (second < third && nums[second] + nums[third] > target) {
                    --third;
                }
                // 如果指针重合，随着 b 后续的增加
                // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }
}
