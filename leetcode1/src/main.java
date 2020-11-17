import java.util.Arrays;

public class main {

    public static void main(String[] args) {
        Solution solution=new Solution();
        int[] nums = {3, 2, 4};
        int target = 6;

//        System.out.println(twoSum(nums, target));
        System.out.println(Arrays.toString(solution.twoSum(nums, target)));
    }

}

