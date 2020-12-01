public class Solution {
//二分法虽然道理简单，但是边界条件等一些细节还是需要花时间进行思考的。
public static void main(String[] args) {
    int[] nums={-1,0,3,5,9,12};
    int target=0;
    System.out.println(Solution.search(nums,target));
}
    public static int search(int[] nums, int target) {//我的代码，很多冗余的部分，边界条件处理得不到位
        int left = 0, right = nums.length - 1;
        int i;
        if (nums[left] == target) return left;
        if (nums[right] == target) return right;
        while(left<=right){     //这个判断条件值得反思，为什么要加=
            i = (left + right) / 2;
            if (nums[i] == target) return i;
            if (nums[i] < target) {
                left = i+1;
            }
            if (nums[i] > target) {
                right = i-1;
            }
        }
        return -1;
    }

    public static int search1(int[] nums, int target) {//官方给的代码
        int pivot, left = 0, right = nums.length - 1;
        while (left <= right) {
            pivot = left + (right - left) / 2;//这里这样写的意义
            if (nums[pivot] == target) return pivot;
            if (target < nums[pivot]) right = pivot - 1;//注意这里的-1
            else left = pivot + 1;
        }
        return -1;
    }

}
