public class Solution {
    public int lengthOfLastWord(String s) {
        int n=s.length();
        int j=n-1;
        while(j>=0&&s.charAt(j)==' '){
            j--;
        }
        int i;
        for(i=j;i>=0;i--){
            if(s.charAt(i)==' ')
                return j-i;
        }
        return j-i;
    }
}
