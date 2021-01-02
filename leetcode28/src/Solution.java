public class Solution {
    public int strStr(String haystack,String needle){//超出了时间限制
        if(needle==null||needle.length()==0) return 0;
        int n=haystack.length();
        int k=0;
        for(int i=0;i<n;i++){
            while(i<n&&haystack.charAt(i)==needle.charAt(k)){
                if(k==needle.length()-1){
                    return i-k;
                }
                ++k;
                ++i;
            }
            i-=k;
            k=0;
        }
        return -1;
    }
    public int strStr2(String haystack, String needle) {
        int L = needle.length(), n = haystack.length();
        for(int start=0;start<n-L+1;start++){
            if(haystack.substring(start,start+L).equals(needle))
                return start;
        }
        return -1;
    }
}
