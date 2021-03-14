public class Solution {
    //这题我没有写出来
    //目前遇到最难的一道题 2021.03.14
    //虽然难，但是很经典！
    //以下是参考答案，动态规划
    //我看的是这个答案，比较好理解
    //https://leetcode-cn.com/problems/regular-expression-matching/solution/dong-tai-gui-hua-zen-yao-cong-0kai-shi-si-kao-da-b/
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;//dp[i][j] 表示 s 的前 i 个是否能被 p 的前 j 个匹配
        //初始化
        for (int j = 0; j < p.length(); j++) { // here's the p's length, not s's
            if (p.charAt(j) == '*' && dp[0][j - 1]) {
                dp[0][j + 1] = true; // here's y axis should be j+1
            }
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) == '.' || p.charAt(j) == s.charAt(i)) {//如果是任意元素 或者是对于元素匹配
                    dp[i + 1][j + 1] = dp[i][j];
                }
                if (p.charAt(j) == '*') {
                    if (p.charAt(j - 1) != s.charAt(i) && p.charAt(j - 1) != '.') {//如果前一个元素不匹配 且不为任意元素
                        dp[i + 1][j + 1] = dp[i + 1][j - 1];
                    } else {
                        dp[i + 1][j + 1] = (dp[i + 1][j] || dp[i][j + 1] || dp[i + 1][j - 1]);
                            /*
                            dp[i+1][j+1] = dp[i][j+1] // 多个字符匹配的情况
                            s里面可能有多个p.charAt(j-1),如果是这种情况，直接为true
                            or dp[i+1][j+1] = dp[i+1][j] // 单个字符匹配的情况
                            就是去掉*，刚好直接匹配
                            or dp[i+1][j+1] = dp[i+1][j-1] // 没有匹配的情况
                            原本就匹配，要不要p.charAt(j-1)+*都无所谓
                            至于dp[i][j-1]，其本身就是dp[i+1][j]的子问题
                             */
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}
