public class Solution {
    public void reverseString(char[] s){//双指针我的代码
        int i=0,j=s.length-1;
        while(i<j){
            char temp;
            temp=s[i];
            s[i]=s[j];
            s[j]=temp;
            ++i;--j;
        }
    }

    public void reverseString1(char[] s) {//参考答案，更加简洁
        int n = s.length;
        for (int left = 0, right = n - 1; left < right; ++left, --right) {
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
        }
    }

}
