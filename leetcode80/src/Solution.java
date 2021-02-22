public class Solution {
    public int removeDuplicates(int[] nums) {
        //1.find duplicate value
        int count = 0;
        for (int i = 0; i < nums.length - count; i++) {
            int cur = i;
            while (cur < nums.length - count && nums[cur] == nums[i]) {
                cur++;
            }
            //i~cur-1都是一样的数字
            if (cur > i + 2) {
                int temp = cur - i - 2;//向左移动的步数
                count += temp;
                for (int j = i + 2; j < nums.length - temp; j++) {
                    nums[j] = nums[j + temp];
                }
                i++;
            } else {
                i = cur - 1;
            }
        }
        return nums.length - count;
    }

    public int[] remElement(int[] arr, int index) {

        //
        // Overwrite the element at the given index by
        // moving all the elements to the right of the
        // index, one position to the left.
        //
        for (int i = index + 1; i < arr.length; i++) {
            arr[i - 1] = arr[i];
        }

        return arr;
    }

    //参考答案，和我的思路相似
    public int removeDuplicates2(int[] nums) {

        int i = 1, count = 1, length = nums.length;
        while (i < length) {
            if (nums[i] == nums[i - 1]) {
                count++;
                if (count > 2) {
                    this.remElement(nums, i);
                    i--;
                    length--;
                }
            } else {
                count = 1;
            }
            i++;
        }
        return length;
    }

    //参考答案2
    //快慢指针法，漂亮！
    public int removeDuplicates3(int[] nums) {
        int j = 1, count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                count++;
            } else {
                count = 1;
            }
            if (count <= 2) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }

    //最nb的答案
    public int removeDuplicates4(int[] nums) {
        int i = 0;
        for (int n : nums)
            if (i < 2 || n > nums[i - 2])
                nums[i++] = n;
        return i;
    }
}
