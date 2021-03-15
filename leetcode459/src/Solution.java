public class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int length = s.length();
        if (length == 0) return true;
        char first = s.charAt(0);
        for (int i = 1; i <= length / 2; i++) {
            if (s.charAt(i) == first) {
                if (Verify(i, s)) return true;
            }
        }
        return false;
    }

    private boolean Verify(int i, String s) {
        if (s.length() % i != 0) return false;
        String model = s.substring(0, i);
        int times = s.length() / (i);
        for (int j = 1; j < times; j++) {
            if (!model.equals(s.substring(j * i, j * i + 1))) return false;
        }
        return true;
    }


    public boolean repeatedSubstringPattern2(String s) {
        //把两个s拼在一起，并移除第一个和最后一个字符，如果s是该字符串的子串，那么s满足题目要求
        return (s + s).indexOf(s, 1) != s.length();
    }

}
