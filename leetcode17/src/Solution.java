import java.util.*;

public class Solution {
    public static void main(String[] args) {
        String digits="";
        List<String> string1=letterCombinations(digits);
    }
    public static List<String> letterCombinations(String digits) {
        Queue<String> letters=new LinkedList<>();
        Queue<String> letters2=new LinkedList<>();
        letters.offer("");
        List<String> ans=new ArrayList<>();
        if(digits.length()==0) return ans;
        for(int i=0;i<digits.length();++i){
            String[] strs=Generate(digits.charAt(i));
            while(!letters.isEmpty()){
                String letter=letters.poll();
                for(String str:strs){
                    str=letter+str;
                    letters2.offer(str);
                }
            }
            while(!letters2.isEmpty()){
                letters.add(letters2.poll());
            }
        }
        while(!letters.isEmpty()){
            ans.add(letters.poll());
        }
        return ans;
    }

    private static String[] Generate(char ch) {
        String[] chs;
        switch (ch){
            case '2':chs= new String[]{"a", "b", "c"};break;
            case '3':chs= new String[]{"d", "e", "f"};break;
            case '4':chs= new String[]{"g", "h", "i"};break;
            case '5':chs= new String[]{"j", "k", "l"};break;
            case '6':chs= new String[]{"m", "n", "o"};break;
            case '7':chs= new String[]{"p", "q", "r","s"};break;
            case '8':chs= new String[]{"t", "u", "v"};break;
            case '9':chs= new String[]{"w", "x", "y","z"};break;
            default:chs=new String[]{""};
        }
        return chs;
    }
//答案用的是回溯法
    //写得非常漂亮，具有高维护性
    public List<String> letterCombinations2(String digits) {
        List<String> combinations = new ArrayList<String>();
        if (digits.length() == 0) {
            return combinations;
        }
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        backtrack(combinations, phoneMap, digits, 0, new StringBuffer());
        return combinations;
    }

    public void backtrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuffer combination) {
        if (index == digits.length()) {
            combinations.add(combination.toString());
        } else {
            char digit = digits.charAt(index);
            String letters = phoneMap.get(digit);
            int lettersCount = letters.length();
            for (int i = 0; i < lettersCount; i++) {
                combination.append(letters.charAt(i));
                backtrack(combinations, phoneMap, digits, index + 1, combination);
                combination.deleteCharAt(index);
            }
        }
    }

}
