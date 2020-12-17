import java.util.*;

public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {//看了答案的思路写的
        //先转化数据，把输入数据转化为邻接表和入度
        int[] indegrees = new int[numCourses];
        List<List<Integer>> edge = new ArrayList<List<Integer>>();
        for (int i = 0; i < numCourses; i++) {
            edge.add(new ArrayList<Integer>());
        }
        for (int[] n : prerequisites) {
            indegrees[n[0]]++;//入度
            edge.get(n[1]).add(n[0]);//用List来表示网结构
        }
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) {//入度为0时
                for (int k : edge.get(i)) {
                    indegrees[k]--;
                }
                indegrees[i] = -1;
                i = -1;//为了重启循环
            }
        }
        for (int indegree : indegrees) {
            if (indegree > 0) return false;
        }
        return true;
    }

    //深度优先算法
    List<List<Integer>> edge;
    int[] search;
    boolean valid = true;

    public boolean canFinish3(int numCourses, int[][] prerequisites) {//同样也是看了答案的思路写的
        edge = new ArrayList<List<Integer>>();
        for (int i = 0; i < numCourses; i++) {
            edge.add(new ArrayList<Integer>());
        }
        search = new int[numCourses];//0为未搜索，1为搜索中，2为以搜索
        for (int[] n : prerequisites) {
            edge.get(n[1]).add(n[0]);//用List来表示网结构
        }
        for (int i = 0; i < numCourses && valid; i++) {
            if (search[i] == 0) {
                dfs(i);
            }
        }
        return valid;
    }

    public void dfs(int u) {
        search[u] = 1;
        for (int v : edge.get(u)) {
            if (search[v] == 0) {
                dfs(v);
                if (!valid) return;
            } else if (search[v] == 1) {
                valid = false;
                return;
            }
        }
        search[u] = 2;
    }


    List<List<Integer>> edges;
    int[] indeg;

    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<List<Integer>>();
        for (int i = 0; i < numCourses; ++i) {
            edges.add(new ArrayList<Integer>());
        }
        indeg = new int[numCourses];
        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);
            ++indeg[info[0]];
        }

        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; ++i) {//和我的代码的区别是它使用了队列作为重启函数
            if (indeg[i] == 0) {
                queue.offer(i);
            }
        }

        int visited = 0;
        while (!queue.isEmpty()) {
            ++visited;
            int u = queue.poll();
            for (int v : edges.get(u)) {
                --indeg[v];
                if (indeg[v] == 0) {
                    queue.offer(v);
                }
            }
        }

        return visited == numCourses;
    }

}
