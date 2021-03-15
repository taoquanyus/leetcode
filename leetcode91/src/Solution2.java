import java.util.Arrays;

public class Solution2 {
    //这道题显然也是回溯法
    //大意了，以为回溯法就能解决，但是超出了时间限制
    int count=0;
    public int numDecodings(String s) {
        dfs(s,0);
        return count;
    }
    private void dfs(String s, int i) {
        if(i==s.length()){
            count++;
            return;
        }
        if(s.charAt(i)=='0'){
            return;
        }
        if(i<s.length()-1&&Integer.parseInt(s.substring(i,i+2))<=26){
            //可以取两位
            dfs(s,i+1);
            dfs(s,i+2);
        }
        else{
            dfs(s,i+1);
        }
    }

    public int numDecodings2(String s) {
        //尝试用动态规划来写
        int length=s.length();
        if(length==1){
            if(s.charAt(0)=='0') return 0;
            return 1;
        }
        int[] dp=new int[length];
        dp[length-1]=s.charAt(length-1)=='0'?0:1;
        if(s.charAt(length-2)=='0') dp[length-2]=0;
        else {
            int temp=Integer.parseInt(s.substring(length-2,length));
            dp[length-2]=temp<=26?dp[length-1]+1:dp[length-1];
        }
        for(int i=length-3;i>=0;--i){
            if(s.charAt(i)=='0')dp[i]=0;
            else {
                int temp=Integer.parseInt(s.substring(i,i+2));
                dp[i]=temp<=26?dp[i+1]+dp[i+2]:dp[i+1];
            }
        }
        return dp[0];
    }
}
