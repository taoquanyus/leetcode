import java.util.PriorityQueue;

public class KthLargest {//本想用堆来解决这个问题的，但是答案教我用了优先队列

    private PriorityQueue<Integer> queue;
    private int limit;

    public KthLargest(int k, int[] nums) {
        limit = k;
//        PriorityQueue queue = new PriorityQueue<>(k);//前面半句是初始化，后面半句是实例化，因为已经初始化过了，可以直接这样写：
        queue=new PriorityQueue<>(k);
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        if (queue.size()<limit){
            queue.add(val);
        }
        else if(val>=queue.peek()){
            queue.remove();
            queue.add(val);//这里先add再remove和先remove再add的内存使用结果不同，在替换时，应当学会要先remove后add.
        }
        return queue.peek();
    }
}


