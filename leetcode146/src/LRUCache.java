import java.util.HashMap;
import java.util.LinkedList;

public class LRUCache {
    //面试题非常喜欢考，正确答案应该是hashmap+双向链表，但我用的是linklist+hashmap实现的
    //可能不符合题目的O(1)要求，对hashmap和Linklist的底层学习还不够
    int capacity;
    HashMap<Integer,Integer> hashMap=new HashMap<>();
    LinkedList<Integer> queue=new LinkedList<>();

    public LRUCache(int capacity) {
        //初始化
        this.capacity=capacity;
    }

    public int get(int key) {
        if(!queue.contains(key)) return -1;
        int value=hashMap.get(key);
        int index=queue.indexOf(key);
        queue.remove(index);
        queue.add(key);
        return value;
    }

    public void put(int key, int value) {
        if(queue.contains(key)){//如果曾经添加过,只是作为更新
            int index=queue.indexOf(key);
            queue.remove(index);
            queue.add(key);
            hashMap.put(key,value);
            return;
        }
        if(queue.size()<capacity){
            //如果没有添加过
            queue.add(key);
            hashMap.put(key,value);
        }
        else if(queue.size()>=capacity){
            int oldKey=queue.get(0);
            queue.removeFirst();
            hashMap.remove(oldKey);
            queue.add(key);
            hashMap.put(key,value);
        }
    }
}
class main{
    public static void main(String[] args) {
        LRUCache lruCache=new LRUCache(2);
        lruCache.put(1,1);
        lruCache.put(2,2);
        lruCache.get(1);
        lruCache.put(3,3);
        lruCache.get(2);
    }
}
