public class Solution {
    public static void main(String[] args) {
        System.out.println(reverse(-2147483648));
    }
    public static int reverse(int x){//代码写得非常巧妙，我用的方法是将它转换为字符串再转换回int
        //java中int的范围为-2147483648到2147483647，这点要注意，-2147483648的*（-1）还是-2147483648
        long n=0;
        while(x!=0){
            n=n*10+x%10;
            x=x/10;
        }
        return (int)n==n? (int)n:0;
    }
}
