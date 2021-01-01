public class Solution {
    public static void main(String[] args) {
        String s = "111111111111111111111111111111111111111111111";
        System.out.println(numDecodings(s));
    }

    public static int numDecodings(String s) {//回溯法
        if (s == null || s.charAt(0) == '0') return 0;
        if (s.length() == 1) return 1;
        if (s.length() == 2) {
            return (s.charAt(0) > '2' || s.charAt(1) == '0' || (s.charAt(0) == '2' && s.charAt(1) > '6')) ? 1 : 2;
        }
        if (s.charAt(0) > '2') return numDecodings(s.substring(1));
        if (s.charAt(1) == '0' || (s.charAt(0) == '2' && s.charAt(1) > '6')) return numDecodings(s.substring(2));
        else {
            return numDecodings(s.substring(1)) + numDecodings(s.substring(2));
        }
    }

    public static int numDecodings2(String s) {//动态规划
        // 长度+1 存储各长度字符串解码方法总数
        Integer memo[] = new Integer[s.length() + 1];
        // 长度为0的空字符串解法设为 1
        memo[0] = 1;
        // 长度为1 的字符串解码
        if (s.charAt(s.length() - 1) == '0') {
            memo[1] = 0;
        } else { // 不是0则只能为1-9，只有一种解码方法
            memo[1] = 1;
        }
        // 算2至n解码方法总数
        for (int i = 2; i < s.length() + 1; i++) {

            // 设置1位2位数字是否可解码的标志位
            int oneNum = 1;
            int twoNum = 1;
            int firstNum = Integer.parseInt(s.substring(s.length() - i, s.length() - i + 1));
            String firstTwoNumStr = s.substring(s.length() - i, s.length() - i + 2);
            int firstTwoNum = Integer.parseInt(firstTwoNumStr);
            // 一位数字不可解码的情况
            if (firstNum < 1)
                oneNum = 0;
            // 两位数字不可解码的情况
            if (firstTwoNumStr.charAt(0) == '0' || firstTwoNum > 26)
                twoNum = 0;
            // 计算memo[n]，即长度为n的字符串的解法总数
            memo[i] = oneNum * memo[i - 1] + twoNum * memo[i - 2];
        }

        // 返回memo[n],即长度为n的字符串的解码方法总数
        return memo[s.length()];
    }
}