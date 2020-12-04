import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Solution {//每日一题，难度较大,以下是参考答案

    public boolean isPossible(int[] nums) {//这里需要注意，priorityqueue是升序的，
                                            // 即queue.poll拿的是最小的那个数，所以也就会有为什么会自动选择队列小的那个数了
        Map<Integer, PriorityQueue<Integer>> hashtable = new HashMap<Integer, PriorityQueue<Integer>>();
        for (int x : nums) {
            if (!hashtable.containsKey(x)) hashtable.put(x, new PriorityQueue<Integer>());
            if (hashtable.containsKey(x - 1)) {//这个queue里面装的是hashcode的长度
                int prevLength = hashtable.get(x - 1).poll();//poll是priority queue的取出
                if (hashtable.get(x - 1).isEmpty()) {//如果p—queue是空的，直接删掉这个这个队列
                    hashtable.remove(x - 1);
                }
                hashtable.get(x).offer(prevLength + 1);
            } else {
                hashtable.get(x).offer(1);
            }
        }
        Set<Map.Entry<Integer, PriorityQueue<Integer>>> entrySet = hashtable.entrySet();//这里定义entryset为hashmap所有的集合
        for (Map.Entry<Integer, PriorityQueue<Integer>> entry : entrySet) {//对于每个子序列，如果长度小于3就返回false
            PriorityQueue<Integer> queue = entry.getValue();
            if (queue.peek() < 3) {
                return false;
            }
        }
        return true;
    }
}
