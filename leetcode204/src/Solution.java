import java.util.Arrays;

public class Solution {
    public int countPrimes(int n) {//看了答案，了解了质数的特性，利用埃氏筛写的
        int[] primes = new int[n];
        Arrays.fill(primes, 1);
        int ans = 0;
        for (int i = 2; i < n; i++) {
            if (primes[i] == 1) {
                ans += 1;
                if (i * i < n) {
                    for (int j = i * i; j < n; j = j + i) {
                        primes[j] = 0;
                    }
                }
            }
        }
        return ans;
    }
}
