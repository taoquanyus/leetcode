import java.util.Stack;

public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack=new Stack<>();
        for(String token:tokens){
            if(token.equals("+")){
                int num1=stack.pop();
                int num2=stack.pop();
                stack.add(num1+num2);
            }
            else if(token.equals("-")){
                int num1=stack.pop();
                int num2=stack.pop();
                stack.add(num2-num1);
            }
            else if(token.equals("*")){
                int num1=stack.pop();
                int num2=stack.pop();
                stack.add(num2*num1);
            }
            else if(token.equals("/")){
                int num1=stack.pop();
                int num2=stack.pop();
                stack.add(num2/num1);
            }
            else {
                int value=Integer.parseInt(token);
                stack.add(value);
            }
        }
        return stack.pop();
    }
}
