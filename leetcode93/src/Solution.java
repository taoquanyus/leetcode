import java.util.ArrayList;
import java.util.List;

public class Solution {
    static List<String> ans1 = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();


    public static List<String> restoreIpAddresses(String s) {
        dfs(s, 4);
        return ans1;
    }

    private static void dfs(String s, int remaining) {
        if (remaining == 1) {
            if (s.length() >= 1 && s.length() <= 3) {
                if (s.length() == 3 && (s.charAt(0) != '1' && s.charAt(0) != '2')) return;
                if (s.length() == 2 && s.charAt(0) == 0) return;
                sb.append(s);
                ans1.add(sb.toString());
                sb.delete(sb.length() - s.length(), sb.length());
            }
            return;
        }
        //第一位只能为1/2
        if ((s.length() < remaining) || (s.length() > 3 * remaining)) {
            return;
        }
        if ((s.length() == 3 * remaining) && (s.charAt(0) > '2')) {
            return;
        }
        //添加一位
        if (s.length() >= remaining && s.length() <= 3 * remaining - 2) {
            sb.append(s.charAt(0));
            sb.append('.');
            dfs(s.substring(1), remaining - 1);
            sb.delete(sb.length() - 2, sb.length());
        }
        //添加两位
        if (s.length() >= remaining + 1 && s.length() <= 3 * remaining - 1) {
            if (s.charAt(0) == '0') return;
            sb.append(s.charAt(0));
            sb.append(s.charAt(1));
            sb.append('.');
            dfs(s.substring(2), remaining - 1);
            sb.delete(sb.length() - 3, sb.length());
        }
        //添加3位
        if (s.length() >= remaining + 2 && s.length() <= 3 * remaining && s.charAt(0) <= '2') {
            if (s.charAt(0) == '0') return;
            sb.append(s.charAt(0));
            sb.append(s.charAt(1));
            sb.append(s.charAt(2));
            sb.append('.');
            dfs(s.substring(3), remaining - 1);
            sb.delete(sb.length() - 4, sb.length());
        }
    }

    static final int SEG_COUNT = 4;
    List<String> ans = new ArrayList<String>();
    int[] segments = new int[SEG_COUNT];

    public List<String> restoreIpAddresses2(String s) {
        segments = new int[SEG_COUNT];
        dfs(s, 0, 0);
        return ans;
    }
//参考答案的做法
    public void dfs(String s, int segId, int segStart) {
        // 如果找到了 4 段 IP 地址并且遍历完了字符串，那么就是一种答案
        if (segId == SEG_COUNT) {
            if (segStart == s.length()) {
                StringBuffer ipAddr = new StringBuffer();
                //原来stringbuffer还能append int类型
                for (int i = 0; i < SEG_COUNT; ++i) {
                    ipAddr.append(segments[i]);
                    if (i != SEG_COUNT - 1) {
                        ipAddr.append('.');
                    }
                }
                ans.add(ipAddr.toString());
            }
            return;
        }

        // 如果还没有找到 4 段 IP 地址就已经遍历完了字符串，那么提前回溯
        if (segStart == s.length()) {
            return;
        }

        // 由于不能有前导零，如果当前数字为 0，那么这一段 IP 地址只能为 0
        if (s.charAt(segStart) == '0') {
            segments[segId] = 0;
            dfs(s, segId + 1, segStart + 1);
        }

        // 一般情况，枚举每一种可能性并递归
        int addr = 0;
        for (int segEnd = segStart; segEnd < s.length(); ++segEnd) {
            addr = addr * 10 + (s.charAt(segEnd) - '0');
            if (addr > 0 && addr <= 0xFF) {
                segments[segId] = addr;
                dfs(s, segId + 1, segEnd + 1);
            } else {
                break;
            }
        }
    }

}
