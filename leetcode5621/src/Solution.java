import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Stack<Integer> stack=new Stack<>();
        Queue<Integer> queue=new LinkedList<>();
        for(int i=sandwiches.length-1;i>=0;i--){
            stack.push(sandwiches[i]);
        }
        for(int j=0;j<students.length;j++){
            queue.offer(students[j]);
        }
        int count = 0;
        while (!queue.isEmpty()) {
            int temp=queue.poll();
            if (temp == stack.peek()) {
                stack.pop();
                count = 0;
            } else {
                count++;
                queue.offer(temp);
                if (count >= stack.size())
                    return count;
            }
        }
        return 0;
    }
}
