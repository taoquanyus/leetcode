public class Solution {
    public int[] plusOne(int[] digits) {
        int n=digits.length;
        for(int digit:digits){
            if(digit!=9){
                for(int i=0;i<n;i++){
                    if(digits[n-1-i]+1==10){
                        digits[n-1-i]=0;
                        continue;
                    }
                    else {
                        digits[n-1-i]++;
                        return digits;
                    }
                }
            }
        }
        int[] ans=new int[n+1];
        ans[0]=1;
        return ans;
    }
}
