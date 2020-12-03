public class Solution {//斐波那契数列
    public int fib(int n){//最简单最单纯的递归思想，但是时间复杂度太高，肯定是不合格的
        if(n==0) return 0;
        if(n==1) return 1;
        return fib(n-1)+fib(n-2);
    }

    static int[]nums=new int[101];//使用一个数组来存储返回值,后面直接调用它就可以
    public int fib2(int n){
        return helper(n);
    }

    private int helper(int k) {
        if(k==0) return nums[k]=0;
        if(k==1) return nums[k]=1;
        if(nums[k]!=0) return nums[k]%1000000007;
        nums[k]=helper(k-1)+helper(k-2);
        nums[k]=nums[k]%1000000007;
        return nums[k];
    }
}
