import java.util.Arrays;

public class Solution {
    //方法一，维护一个数组
    public int climbStairs(int n) {
        if(n<=2) return n;
        int[] dp=new int[n];
        dp[n-1]=1;dp[n-2]=1;
        for(int i=n-3;i>=0;i++){
            dp[i]=dp[i+1]+dp[i+2];
        }
        return dp[0];
    }
    //方法二
    public int climbStairs2(int n) {
        if(n<=2) return n;
        int[] dp=new int[]{1,2};
        Arrays.fill(dp,1);
        for(int i=2;i<n;i++){
            int temp=dp[0]+dp[1];
            dp[0]=dp[1];
            dp[1]=temp;
        }
        return dp[1];
    }
}
