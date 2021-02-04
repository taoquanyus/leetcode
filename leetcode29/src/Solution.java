public class Solution {
    public static void main(String[] args) {
        int divisor=Integer.MIN_VALUE;
        int divedend=1;
//        divisor=Math.abs(divisor);
        divide(divisor,divedend);
    }
    public static int divide(int dividend, int divisor) {
        //做除法，我能想到的就只有减法，但是效率太低
        //超时
        int sign=-1;
        if(divisor==Integer.MIN_VALUE&&dividend!=divisor)return 0;
        if(divisor==Integer.MIN_VALUE&&dividend==divisor)return 1;
        int flag=0;
        if((dividend<0&&divisor<0)||(dividend>0&&divisor>0)){
            sign=1;
        }
        if(dividend==Integer.MIN_VALUE&&divisor==1)
            return dividend;
        if(dividend==Integer.MIN_VALUE){
            flag=1;
            dividend+=1;
        }
        dividend=Math.abs(dividend);
        divisor=Math.abs(divisor);
        int ans=0;
        while (dividend>=divisor){
            dividend-=divisor;
            ans++;
        }
        if(flag==1){
            if(dividend+1>=divisor&&ans!=Integer.MAX_VALUE) ans++;
        }
        if(sign<0)return -ans;
        return ans;
    }
    public int divide2(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        boolean negative;
        negative = (dividend ^ divisor) <0;//用异或来计算是否符号相异
        long t = Math.abs((long) dividend);
        long d= Math.abs((long) divisor);
        int result = 0;
        for (int i=31; i>=0;i--) {
            if ((t>>i)>=d) {//找出足够大的数2^n*divisor
                result+=1<<i;//将结果加上2^n
                t-=d<<i;//将被除数减去2^n*divisor
            }
        }
        return negative ? -result : result;//符号相异取反
    }
}
