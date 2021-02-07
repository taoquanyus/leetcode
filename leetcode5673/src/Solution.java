public class Solution {
    //2.7周赛
    public static void main(String[] args) {
        int a=4,b=4,c=7;
        System.out.println(maximumScore(a, b, c));
    }
    public static int maximumScore(int a, int b, int c) {
        if(a*b+b*c+c*a==0) return 0;
        if(a*b*c==0){
            return a+b+c-Math.max(a,Math.max(b,c));
        }
        if(a<=b&&a<=c){//a为最小
            if(Math.abs(c-b)>=a) return maximumScore(0,Math.min(b,c),Math.max(b,c)-a)+a;
            else {
                int d=a-Math.abs(b-c);
                if(d%2==0)return maximumScore(0,Math.min(b,c)-d/2,Math.min(b,c)-d/2)+a;
                else return maximumScore(0,Math.min(b,c)-d/2-1,Math.min(b,c)-d/2)+a;
            }
        }
        if(b<=a&&b<=c){
            if(Math.abs(c-a)>=b) return maximumScore(0,Math.min(a,c),Math.max(a,c)-b)+b;
            else {
                int d=b-Math.abs(a-c);
                if(d%2==0)return maximumScore(0,Math.min(a,c)-d/2,Math.min(a,c)-d/2)+b;
                else return maximumScore(0,Math.min(a,c)-d/2-1,Math.min(a,c)-d/2)+b;
            }
        }
        if(c<=a&&c<=b){
            if(Math.abs(a-b)>=c) return maximumScore(0,Math.min(b,a),Math.max(b,a)-c)+c;
            else {
                int d=c-Math.abs(b-a);
                if(d%2==0)return maximumScore(0,Math.min(b,a)-d/2,Math.min(b,a)-d/2)+c;
                else return maximumScore(0,Math.min(b,a)-d/2-1,Math.min(b,a)-d/2)+c;
            }
        }
        return 0;
    }
    //简单的方法，这么浅显易懂的道理
    public static int maximumScore2(int a, int b, int c) {
        if(a*b+b*c+c*a==0) return 0;
        int max=Math.max(a,Math.max(b,c));
        if(2*max>a+b+c)return a+b+c-max;
        else return ((a+b+c)/2);
    }
}
