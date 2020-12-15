import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int findJudge(int N, int[][] trust) {//自己写的代码
        Set<Integer> hashset = new HashSet<>();
        for (int i = 1; i <= N; i++) hashset.add(i);//填充所有的
        for (int k[] : trust) {
            if (hashset.contains(k[0])) hashset.remove(k[0]);
        }
        for (int j : hashset) {
            int weigh = 0;
            for (int m[] : trust) {
                if (m[1] == j) weigh++;
            }
            if (weigh == N - 1) return j;
        }
        return -1;
    }

    //这题的数据结构用的应该是图
    //根据题意，此为有向图，有唯一的一个人，入度为N-1，出度为0；
    public int findJudge2(int N, int[][] trust) {
        int[] inDegree = new int[N + 1];//定义入度和出度
        int[] outDegree = new int[N + 1];
        for (int i = 0; i < trust.length; i++) {//二维的数组的长度是由第一个维度决定的
            inDegree[trust[i][1]]++;
            outDegree[trust[i][0]]++;
        }

        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == N - 1 && outDegree[i] == 0) {
                return i;
            }
        }
        return -1;
    }
}
