class Solution {//根据答案改写的代码，但是超出了时间限制，递归入门题

    public int tribonacci(int n) {
        return helper(n);
    }

    int helper(int k) {

        if (k == 0) return 0;
        if (k == 1) return 1;
        if (k == 2) return 1;

        return helper(k - 1) + helper(k - 2) + helper(k - 3);
    }

    //////////////////答案给的解法
    public int tribonacci2(int n) {
        Tri t = new Tri();
        return t.nums[n];
    }

    class Tri {
        private int n = 38;
        public int[] nums = new int[n];

        Tri() {
            nums[1] = 1;
            nums[2] = 1;
            for (int i = 3; i < n; ++i)
                nums[i] = nums[i - 1] + nums[i - 2] + nums[i - 3];
        }
    }
}
