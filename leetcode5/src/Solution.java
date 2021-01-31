public class Solution {
    public String longestPalindrome(String s) {
        int length=s.length();
        String ans="";
        Boolean bp[][]=new Boolean[length][length];
        for(int l=0;l<length;l++){
            for(int i=0;i+l<length;i++){
                int j=i+l;
                if(l<2){
                    bp[i][j]=(s.charAt(i)==s.charAt(j));
                }
                else{
                    bp[i][j] = (s.charAt(i) == s.charAt(j) && bp[i + 1][j - 1]);
                }
                if(bp[i][j]&&l+1>ans.length()){
                    ans=s.substring(i,i+l+1);
                }
            }
        }
        return ans;
    }
}
