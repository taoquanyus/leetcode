public class Solution {
    public int countHomogenous(String s) {
        //只需要讨论连续的字符即可
        //因为越界，花费了很多时间，所以在此需要使用long
        int n=s.length();
        long count=0l;
        long sum=0l;
        int mod=(int)(1e9+7);
        for(int i=0;i<n;i++){
            if(i>0&&s.charAt(i)==s.charAt(i-1)){
                count++;
            }
            else {
                sum+=(count+1)*count/2;//阶和
                count=0;
            }
        }
        sum+=(count+1)*count/2;//最后一项没有处理
        return (int)((sum+n)%mod);
    }
}
