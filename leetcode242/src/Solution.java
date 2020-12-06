import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {//我的第一反应却是用优先序列，而不是用数组，这是因为我对Arrays的不熟悉啊
    public static void main(String[] args) {
        String s="anagram";
        String t="naagram";
        System.out.println(isAnagram(s,t));
    }
    public static boolean isAnagram(String s, String t) {
        char[] str1=s.toCharArray();
        char[] str2=s.toCharArray();
        if(str2.length!=str1.length) return false;
        Arrays.sort(str1);Arrays.sort(str2);
        return Arrays.equals(str1,str2);
    }
}
