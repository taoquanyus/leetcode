import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean isIsomorphic(String s, String t) {//我的答案，时间复杂度高
        Map<Character, Integer> hashmap1 = new HashMap<>();
        Map<Character, Integer> hashmap2 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!hashmap1.containsKey(s.charAt(i)))
                hashmap1.put(s.charAt(i), i);
            if (!hashmap2.containsKey(t.charAt(i)))
                hashmap2.put(t.charAt(i), i);
            if (hashmap1.get(s.charAt(i)) != hashmap2.get(t.charAt(i)))
                return false;
        }
        return true;
    }
    public boolean isIsomorphic2(String s, String t) {//参考答案，利用双射的关系，时间复杂度低。
        Map<Character, Character> s2t = new HashMap<Character, Character>();
        Map<Character, Character> t2s = new HashMap<Character, Character>();
        int len = s.length();
        for (int i = 0; i < len; ++i) {
            char x = s.charAt(i), y = t.charAt(i);
            if ((s2t.containsKey(x) && s2t.get(x) != y) || (t2s.containsKey(y) && t2s.get(y) != x)) {
                return false;
            }
            s2t.put(x, y);//这个双射想得很巧妙
            t2s.put(y, x);
        }
        return true;
    }
}
