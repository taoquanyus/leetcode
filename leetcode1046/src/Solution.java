import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {

    private PriorityQueue<Integer> queue;
    public int lastStoneWeight(int[] stones){//我写的代码
        queue=new PriorityQueue<>(new UserComparator());
        for(int stone:stones){
            queue.add(stone);
        }
        int l=stones.length-1;
        for (int i=0;i<l;i++){
            int a=queue.poll();
            int b=queue.poll();
            queue.add(Math.abs(a-b));
        }
        return queue.peek();
    }

    class UserComparator implements Comparator<Integer> {

        public int compare(Integer u1, Integer u2) {
            if (u1 > u2) {
                return -1;
            }
            else{
                return 1;
            }
        }
    }


    public int lastStoneWeight1(int[] stones) {//别人的参考答案，其实道理很简单啊
        if (stones.length == 2) {
            return Math.abs(stones[0] - stones[1]);
        }
        if (stones.length == 1) {
            return stones[0];
        }
        Arrays.sort(stones);
        if (stones[stones.length - 3] == 0) {
            return stones[stones.length - 1] - stones[stones.length - 2];
        }
        stones[stones.length - 1] = stones[stones.length - 1] - stones[stones.length - 2];
        stones[stones.length - 2] = 0;
        return lastStoneWeight1(stones);
    }
}
