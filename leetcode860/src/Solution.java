public class Solution {
    public boolean lemonadeChange(int[] bills) {//我写的代码 但明显但过于低级了，但我看了答案，发现一样地低级
        int a = 0, b = 0;                       //这道题没有一点价值
        for (int bill : bills) {
            if (bill == 5) a++;
            if (bill == 10) {
                if (a == 0) return false;
                a--;
                b++;
            }
            if (bill == 20) {
                if (b == 0) {
                    if (a < 3) return false;
                    a -= 3;
                }
                if (b > 0) {
                    if (a == 0) return false;
                    b -= 1;
                    a -= 1;
                }
            }
        }
        return true;
    }
}
