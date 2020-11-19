import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public Solution(){
    }
    public boolean hasGroupSizeX(int[] deck){
        Map<Integer,Integer> hashtable=new HashMap<Integer,Integer>();
        for(int n:deck){
            if(hashtable.containsKey(n))
                hashtable.put(n,hashtable.getOrDefault(n,0)+1);
            else
                hashtable.put(n,1);
        }

        for(int n=2;n<=deck.length/2+1;n++){
            if(deck.length%n!=0)
                continue;
            boolean flag = false;
            for(int k:hashtable.values()){
                if(k%n==0){
                    flag=true;
                    continue;
                }
                else{
                    flag=false;
                    break;
                }
            }
            if(flag==true)
                return true;
        }
        return false;
    }
}

class Solution1 {//别人的代码
    public boolean hasGroupsSizeX(int[] deck) {
        int N = deck.length;
        int[] count = new int[10000];
        for (int c: deck) {
            count[c]++;
        }

        List<Integer> values = new ArrayList<Integer>();
        for (int i = 0; i < 10000; ++i) {
            if (count[i] > 0) {
                values.add(count[i]);
            }
        }

        for (int X = 2; X <= N; ++X) {
            if (N % X == 0) {
                boolean flag = true;
                for (int v: values) {
                    if (v % X != 0) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    return true;
                }
            }
        }

        return false;
    }
}

class Solution2 {//最大公约数代码
    public boolean hasGroupsSizeX(int[] deck) {
        int[] count = new int[10000];
        for (int c: deck) {
            count[c]++;
        }

        int g = -1;
        for (int i = 0; i < 10000; ++i) {
            if (count[i] > 0) {
                if (g == -1) {
                    g = count[i];
                } else {
                    g = gcd(g, count[i]);
                }
            }
        }
        return g >= 2;
    }

    public int gcd(int x, int y) {//递归的思想太漂亮了，辗转相除法
        return x == 0 ? y : gcd(y % x, x);
    }
}

