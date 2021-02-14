public class Solution {
    public int minOperations(String s) {
        int n=s.length();
        int count=0;
        for(int i=0;i<n;++i){
            if(i%2==0&&s.charAt(i)!='1'){
                count++;
            }
            if(i%2==1&&s.charAt(i)!='0'){
                count++;
            }
        }
        return count<n-count?count:n-count;
    }
}
