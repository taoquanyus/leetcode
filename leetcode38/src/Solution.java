public class Solution {
    public String countAndSay(int n) {
        if (n == 1) return "1";
        String str = countAndSay(n - 1);
        StringBuilder sb=new StringBuilder();
        int length=str.length();
        for (int i = 0; i < length; ++i) {
            char temp=str.charAt(i);
            int k=1;
            while(i < length-1&&temp==str.charAt(i+1)){
                k++;
                i++;
            }
            sb.append(k);
            sb.append(temp);
        }
        return sb.toString();
    }
}
