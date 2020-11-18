import java.util.HashMap;
import java.util.Map;

public class Solution {
    public Solution() {
    }

    //我的代码
    public int repeatedNTimes(int[] A) {
        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
        for (int i = 0; i < A.length; i++) {
            if (hashtable.containsKey(A[i])) {
                int temp1 = hashtable.getOrDefault(A[i], -1).intValue();
                hashtable.replace(A[i], ++temp1);
                if (2 * temp1 >= A.length) ;
                return A[i];
            } else
                hashtable.put(A[i], 1);
        }
        return 0;
    }

    //别人的代码
    public int repeatedNTimes1(int[] A) {
        Map<Integer, Integer> count = new HashMap();
        for (int x : A) {//不要用 for int i；应该直接用数组遍历
            count.put(x, count.getOrDefault(x, 0) + 1);
        }
        for (int k : count.keySet())
            if (count.get(k) > 1)
                return k;
        throw null;
    }
}
