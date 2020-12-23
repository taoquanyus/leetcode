import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean wordPattern(String pattern, String s){//我写的代码，复杂度过高
        String[] a=s.split("\\s+");
        HashMap<String,Character> hashmap =new HashMap<>();
        if(pattern.length()!=a.length) return false;
        for(int i=0;i<a.length;i++){
            if(hashmap.containsKey(a[i])){
                if(hashmap.get(a[i])!=pattern.charAt(i)) return false;
            }
            else{
                if(hashmap.containsValue(pattern.charAt(i))) return false;
                hashmap.put(a[i],pattern.charAt(i));
            }
        }
        return true;
    }

    public boolean wordPattern2(String pattern, String str) {
        Map<String, Character> str2ch = new HashMap<String, Character>();
        Map<Character, String> ch2str = new HashMap<Character, String>();
        int m = str.length();//右指针
        int i = 0;//左指针
        for (int p = 0; p < pattern.length(); ++p) {
            char ch = pattern.charAt(p);//第p个字符
            if (i >= m) {
                return false;
            }
            int j = i;
            while (j < m && str.charAt(j) != ' ') {
                j++;
            }
            String tmp = str.substring(i, j);//左边包括，右边不包括
            if (str2ch.containsKey(tmp) && str2ch.get(tmp) != ch) {
                return false;
            }
            if (ch2str.containsKey(ch) && !tmp.equals(ch2str.get(ch))) {
                return false;
            }
            str2ch.put(tmp, ch);
            ch2str.put(ch, tmp);
            i = j + 1;
        }
        return i >= m;//双指针用法中，为什么这里写return i>=m；
    }
}
