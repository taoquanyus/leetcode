import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;


public class Solution {//利用stack写的代码

    public boolean isValid(String s) {
        if (s.isEmpty())
            return true;
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (c != stack.pop())
                return false;
        }
        return stack.empty();

    }
    //利用map和链表来实现
    private static final Map<Character, Character> map = new HashMap<Character, Character>() {{
        put('{', '}');
        put('[', ']');
        put('(', ')');
        put('?', '?');// hashmap可以在初始化时直接put
    }};

    public boolean isValid2(String s) {
        if (s.length() > 0 && !map.containsKey(s.charAt(0)))
            return false;
        LinkedList<Character> stack = new LinkedList<Character>() {{
            add('?');
        }};//为什么两个括号
        for (char c : s.toCharArray()) {
            if (map.containsKey(c))
                stack.addLast(c);
            else if (map.get(stack.removeLast()) != c)
                return false;
        }
        return stack.size() == 1;
    }
}
