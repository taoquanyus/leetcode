import java.util.LinkedList;
import java.util.Queue;

public class RecentCounter {//队列,先进先出FIFO
    Queue<Integer> queue;//queue is just a interface, 必须还要经过实例化
    public RecentCounter() {
        queue=new LinkedList<Integer>();//实例化其实就可以理解为初始化
    }
    public int ping(int t) {
        queue.offer(t);
        while(queue.peek()<t-3000){//把没用的部分取出
            queue.remove();
        }
        return queue.size();
    }
}
