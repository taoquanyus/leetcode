import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean containsDuolicate(int[] nums){//我写的代码
        Set<Integer> hashtable= new HashSet<Integer>();
        for(int num : nums){
            if (hashtable.contains(num)) return true;
            else hashtable.add(num);
        }
        return false;
    }
    public boolean containsDuplicate(int[] nums) {//官方给的参考答案
        Set<Integer> set = new HashSet<>(nums.length);//注意定义上的差别，其他地方都一样
        for (int x: nums) {
            if (set.contains(x)) return true;
            set.add(x);
        }
        return false;
    }
}

