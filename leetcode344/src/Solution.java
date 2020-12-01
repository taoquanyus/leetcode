public class Solution {
    public void reverseString(char[] s){//双指针
        int i=0,j=s.length-1;
        while(i<j){
            char temp;
            temp=s[i];
            s[i]=s[j];
            s[j]=temp;
            ++i;--j;
        }
    }
}
