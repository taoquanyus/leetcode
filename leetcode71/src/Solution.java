import java.util.Stack;

public class Solution {
    public String simplifyPath(String path) {
        Stack<String> ans=new Stack<>();
        for(int i=0;i<path.length();++i){
            while(i<path.length()-1&&path.charAt(i)=='/'){
                ++i;
            }
            int j=i;
            while(j<path.length()-1&&path.charAt(j)!='/'){
                ++j;
            }
            if("..".equals(path.substring(i,j))){//目录
                if(!ans.isEmpty()){
                    ans.pop();
                }
            }
            else if(".".equals(path.substring(i,j))){
                i=j;
                continue;
            }
            else if(j>i){
                ans.push(path.substring(i,j));
            }
            i=j;
        }
        String output="";
        if(!ans.isEmpty()) {
            output = ans.pop();
        }
        while (!ans.isEmpty()){
            output=ans.pop()+"/"+output;
        }
        return "/"+output;
    }
    //但其实用split会更简单
    public String simplifyPath2(String path) {
        Stack<String> stack = new Stack<>();
        String[] items = path.split("/");
        for (String item : items) {
            if (item.isEmpty() || item.equals(".")) continue;
            if (item.equals("..")) {
                if (!stack.empty()) stack.pop();
            } else {
                stack.push(item);
            }
        }
        return "/" + String.join("/", stack);
    }

}
