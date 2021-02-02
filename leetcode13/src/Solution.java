public class Solution {
    public int romanToInt(String s) {
        //这道题虽然和上道题很相似，但主要难处理的点在于有时输入一个，有时输入两个
        //下面这种解法很巧妙，是我没有发现的规律
        StringBuilder sb = new StringBuilder(s);
        int prenumber = getValue(s.charAt(0));
        int sum = 0;
        for (int i = 1; i < s.length(); i++) {
            int num = getValue(s.charAt(i));
            if (prenumber < num) {
                sum -= prenumber;
            } else {
                sum += prenumber;
            }
            prenumber = num;
        }
        sum += prenumber;
        return sum;
    }

    private int getValue(char ch) {
        switch (ch) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
    //也可以利用字符替换的方式，把两个字符都替换成另外一种字符；
    public int romanToInt2(String s) {
        s = s.replace("IV","a");
        s = s.replace("IX","b");
        s = s.replace("XL","c");
        s = s.replace("XC","d");
        s = s.replace("CD","e");
        s = s.replace("CM","f");

        int result = 0;
        for (int i=0; i<s.length(); i++) {
            result += which(s.charAt(i));
        }
        return result;
    }

    public int which(char ch) {
        switch(ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            case 'a': return 4;
            case 'b': return 9;
            case 'c': return 40;
            case 'd': return 90;
            case 'e': return 400;
            case 'f': return 900;
        }
        return 0;
    }
}
