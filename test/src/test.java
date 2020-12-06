import java.util.*;

public class test {
    public static void main(String[] args) {
        String s="anagram";
        Queue<Character> queues = new PriorityQueue<>();
        for (char c1 : s.toCharArray()) {
            queues.add(c1);
        }
        System.out.println(queues);

    }
}
