import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        int[] arrays = new int[k];
        for (int i = 0; i < k; i++) {
            arrays[i] = nums[i];
        }
        Arrays.sort(arrays);
        int length = nums.length;
        for (int i = k; i < length; i++) {
            if (nums[i] > arrays[0]) {
                arrays[0] = nums[i];
                Arrays.sort(arrays);
            }
        }
        return arrays[0];
    }
    //利用堆排序来解决
    //建立一个大根堆，做k-1次删除操作后的堆顶元素就是要找的答案
    public int findKthLargest2(int[] nums, int k) {
        int heapSize = nums.length;
        buildMaxHeap(nums, heapSize);//建堆
        for (int i = nums.length - 1; i >= nums.length - k + 1; --i) {
            swap(nums, 0, i);
            --heapSize;
            maxHeapify(nums, 0, heapSize);
        }
        return nums[0];
    }

    public void buildMaxHeap(int[] a, int heapSize) {//建立最大堆
        for (int i = heapSize / 2; i >= 0; --i) {
            maxHeapify(a, i, heapSize);
        }
    }

    public void maxHeapify(int[] a, int i, int heapSize) {
        int l = i * 2 + 1, r = i * 2 + 2, largest = i;
        if (l < heapSize && a[l] > a[largest]) {
            largest = l;
        }
        if (r < heapSize && a[r] > a[largest]) {
            largest = r;
        }
        if (largest != i) {
            swap(a, i, largest);
            maxHeapify(a, largest, heapSize);
        }
    }
    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    //优先队列
    public static int findKthLargest3(int[] nums, int k) {
        Queue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            if(pq.size() < k){
                pq.add(num);
            }
            else if(pq.peek() < num){
                pq.remove();
                pq.add(num);
            }
        }
        return pq.peek();
    }
}
