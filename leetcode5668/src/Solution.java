import java.util.HashMap;
import java.util.HashSet;

public class Solution {
    //我找到的答案，利用三重暴力法解决的
    public String longestNiceSubstring(String s) {
        char[] cs = s.toCharArray();
        String res = "";
        for (int i = 0; i < cs.length; i++) {
            for (int j = cs.length - 1; j > i; j--) {
                boolean flag = true;
                HashSet<Character> set = new HashSet<>();
                for (int k = i; k <= j; k++) {
                    set.add(cs[k]);
                }
                if(set.size()%2!=0)continue;
                for (char c : set){
                    //注意这里的用法，字符串可以直接比较asic值，也可以直接相加asic值
                    //但是相加的结果是int类型
                    if(c < 'a' && !set.contains((char)(c+32))) flag = false;
                    if(c >='a' && !set.contains((char)(c-32))) flag = false;
                }
                if(flag && j-i+1>res.length())res = s.substring(i,j+1);
            }
        }
        return res;
    }


    //读错题了，我以为美好字符串只能有一种字符
    public static String longestNiceSubstring2(String s) {
        int count=1;
        String ans="";
        String temp=s.toLowerCase();
        for(int i=1;i<s.length();i++){
            if(temp.charAt(i)==temp.charAt(i-1)){
                count++;
                if(i==s.length()-1){
                    boolean flag=false;
                    if(count>ans.length()){
                        String temp1=s.substring(i+1-count,i+1);
                        for(int j=1;j<temp1.length();j++){//判断是否都是一样的
                            if(temp1.charAt(j)!=temp1.charAt(j-1)){
                                flag=true;
                                break;
                            }
                        }
                    }
                    if(flag){
                        ans=s.substring(i+1-count,i+1);
                    }
                }
            }
            if(temp.charAt(i)!=temp.charAt(i-1)){
                boolean flag=false;
                if(count>ans.length()){
                    String temp1=s.substring(i-count,i);
                    for(int j=1;j<temp1.length();j++){//判断是否都是一样的
                        if(temp1.charAt(j)!=temp1.charAt(j-1)){
                            flag=true;
                            break;
                        }
                    }
                }
                if(flag){
                    ans=s.substring(i-count,i);
                }
                count=1;
            }

        }
        return ans;
    }
}
