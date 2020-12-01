import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;


public class Solution {
    public static void main(String[] args) {
        String s = "dvdf";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {//我的答案一，就是速度很慢
        Set<Character> hashset = new HashSet<Character>();
        int left = 0, right = 0, answer = 0;
        if(s.length()==1) return 1;
        while (right + 1 < s.length()) {
            hashset.add(s.charAt(left));
            right = left;
            while (right + 1 < s.length() && !hashset.contains(s.charAt(right + 1))) {
                hashset.add(s.charAt(right + 1));
                right++;
            }
            answer = Math.max(answer, right - left + 1);
            left++;
            hashset.clear();
        }
        return answer;
    }
    public static int lengthOfLongestSubstring2(String s) {//我的答案2,但因为hashset存储的顺序不同，
        // 似乎是按照字母表顺序排列的
        Set<Character> hashset = new HashSet<Character>();
        int left = 0, right = 0, answer = 0;
        if(s.length()==1)
        return 1;
        while (right + 1 < s.length()) {
            hashset.add(s.charAt(left));
            right = left;
            while (right + 1 < s.length() && !hashset.contains(s.charAt(right + 1))) {
                hashset.add(s.charAt(right + 1));
                right++;
            }
            answer = Math.max(answer, right - left + 1);
            if(right + 1 >= s.length()) return answer;
            int i;
            Character[] k= new Character[1];
            k=hashset.toArray(k);
            for(i=0;i<=hashset.size()-1;i++){
                if(k[i]==s.charAt(right + 1)){
//                    i=hashset.size()-1-i;
                    break;
                }
            }
            left = left+i+1;
            hashset.clear();
        }
        return answer;
    }


    public int lengthOfLongestSubstring1(String s) {//这道题复杂度较大，以下是参考答案
        // 哈希集合，记录每个字符是否出现过
        Set<Character> hashSet = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {//左指针
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                hashSet.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !hashSet.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                hashSet.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }
}
