public class Solution {
    public static void main(String[] args) {
        String a="11";String b="1";
        System.out.println(addBinary(a,b));
    }
    public static String addBinary(String a,String b){
        //自己一开始写得非常麻烦的转换代码，先把string转换成int，再把int用来计算
        // 但是如果string过于大的时候，会导致int溢出
        int Dec_a=0;
        int Dec_b=0;
        int length_a=a.length();
        int length_b=b.length();
        for(int i=0;i<length_a;i++){
            Dec_a+=Character.getNumericValue(a.charAt(i))*Math.pow(2,(length_a-i-1));
        }
        for(int i=0;i<length_b;i++){
            Dec_b+=Character.getNumericValue(b.charAt(i))*Math.pow(2,(length_b-i-1));
        }
        Dec_a=Dec_a+Dec_b;
        int i=Math.max(length_a,length_b)+1;
        if(Dec_a<Math.pow(2,i-1)) i--;
        StringBuilder sb=new StringBuilder();
        while(i>0){
            if((Dec_a)>=Math.pow(2,i-1)){
                Dec_a-=Math.pow(2,i-1);
                sb.append(1);
                i--;
            }
            else {
                sb.append(0);
                i--;
            }
        }
        return sb.toString();
    }
    public String addBinary2(String a, String b) {//和上述方法相同，写法更简洁，但是同样会失败
        return Integer.toBinaryString(
                Integer.parseInt(a, 2) + Integer.parseInt(b, 2)
        );
    }


    public String addBinary3(String a, String b) {//模拟法
        //学到了 stringbuffer有reverse的用法，还有carry/=2中，1/2=0，2/2=1来判断是否有进位
        StringBuffer ans = new StringBuffer();

        int n = Math.max(a.length(), b.length()), carry = 0;
        for (int i = 0; i < n; ++i) {
            carry += i < a.length() ? (a.charAt(a.length() - 1 - i) - '0') : 0;//后面这个'0'是借助了隐式类型转换
            carry += i < b.length() ? (b.charAt(b.length() - 1 - i) - '0') : 0;
            ans.append((char) (carry % 2 + '0'));
            carry /= 2;//判断是否有进位.
        }

        if (carry > 0) {
            ans.append('1');
        }
        return ans.reverse().toString();//字符串反转,前提是stringbuffer；
    }

}
