import java.util.HashMap;
import java.util.Map;

import static javax.swing.UIManager.put;

public class Solution {
    public int myAtoi(String s) {//代码臃肿 正确的解法应该用DFA，deterministic finite automation确定有限状态机
        //答案见下面
        StringBuilder sb=new StringBuilder(s);
        StringBuilder sb2=new StringBuilder();
        if(s.length()==0) return 0;
        while(sb.charAt(0)==' '){
            sb.deleteCharAt(0);
            if(sb.length()==0) return 0;
        }
        int sign=1;
        if (sb.charAt(0) == '-') {
            sign *= -1;
            sb.deleteCharAt(0);
        } else if (sb.charAt(0) == '+') {
            sb.deleteCharAt(0);
        }
        if(sb.length()==0) return 0;
        while(true){
            if(sb.length()==0||(int)sb.charAt(0)<48||(int)sb.charAt(0)>57){
                break;
            }
            sb2.append(sb.charAt(0));
            sb.deleteCharAt(0);
        }
        if(sb2.length()==0) return 0;
        while(sb2.charAt(0)=='0'){
            sb2.deleteCharAt(0);
            if(sb2.length()==0) return 0;
        }
        if(sb2.length()>=19){
            if(sign==1) return Integer.MAX_VALUE;
            if(sign==-1) return Integer.MIN_VALUE;
        }
        long ans=Long.parseLong(sb2.toString())*sign;
        if(ans>Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if(ans<Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return (int)ans;
    }

    //正确答案
    public int myAtoi2(String str) {
        Automaton automaton = new Automaton();
        int length = str.length();
        for (int i = 0; i < length; ++i) {
            automaton.get(str.charAt(i));
        }
        return (int) (automaton.sign * automaton.ans);
    }
    class Automaton {
        public int sign = 1;
        public long ans = 0;
        private String state = "start";
        private Map<String, String[]> table = new HashMap<String, String[]>() {{
            put("start", new String[]{"start", "signed", "in_number", "end"});
            put("signed", new String[]{"end", "end", "in_number", "end"});
            put("in_number", new String[]{"end", "end", "in_number", "end"});
            put("end", new String[]{"end", "end", "end", "end"});
        }};

        public void get(char c) {
            state = table.get(state)[get_col(c)];
            if ("in_number".equals(state)) {
                ans = ans * 10 + c - '0';
                ans = sign == 1 ? Math.min(ans, (long) Integer.MAX_VALUE) : Math.min(ans, -(long) Integer.MIN_VALUE);
            } else if ("signed".equals(state)) {
                sign = c == '+' ? 1 : -1;
            }
        }

        private int get_col(char c) {
            if (c == ' ') {
                return 0;
            }
            if (c == '+' || c == '-') {
                return 1;
            }
            if (Character.isDigit(c)) {
                return 2;
            }
            return 3;
        }
    }
}
