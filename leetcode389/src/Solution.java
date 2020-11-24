import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public char findTheDifference(String s, String t) {
        Map<Character, Integer> hashmap = new HashMap<Character, Integer>();
        for (char s1 : s.toCharArray()) {
            hashmap.put(s1, hashmap.getOrDefault(s1, 0) + 1);
        }
        for (char t1 : t.toCharArray()) {
            if (hashmap.containsKey(t1)) {
                hashmap.put(t1, hashmap.get(t1) - 1);
                if (hashmap.get(t1) == 0) hashmap.remove(t1);
            } else return t1;
        }
        return '1';
    }

    public char findTheDifference1(String s, String t) {//参考答案，用的是异或法
        char ans = t.charAt(t.length() - 1);
        for (int i = 0; i < s.length(); i++) {
            ans ^= s.charAt(i);
            ans ^= t.charAt(i);
        }
        return ans;
    }

}
