public class Solution {
    public boolean isPalindrome(String s) {//我的代码，超出时间限制,是因为
        // toCharArray需要花时间每次给数组赋值，应该学会用toCharAt()
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (!Character.isLetterOrDigit(s.toCharArray()[i])) {
                i++;
                continue;
            }
            if (!Character.isLetterOrDigit(s.toCharArray()[j])) {
                j--;
                continue;
            }
            if (Character.toLowerCase(s.toCharArray()[i]) == Character.toLowerCase(s.toCharArray()[j])) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;

    }
    public boolean isPalindrome1(String s) {//官方的代码，就不会有这个毛病，而且看答案基本不喜欢用continue，而是双循环
        int n = s.length();
        int left = 0, right = n - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                ++left;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                --right;
            }
            if (left < right) {
                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                    return false;
                }
                ++left;
                --right;
            }
        }
        return true;
    }
}


