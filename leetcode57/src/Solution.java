import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(newInterval.length==0) return intervals;
        if(intervals.length==0) return new int[][]{newInterval};
        List<int[]> cur = new ArrayList<>();
        int n=intervals.length;
        if(newInterval[0]>intervals[n-1][1]){
            for(int[] temp:intervals){
                cur.add(temp);
            }
            cur.add(newInterval);
            return cur.toArray(new int[cur.size()][]);
        }
        if(newInterval[1]<intervals[0][0]){
            cur.add(newInterval);
            for(int[] temp:intervals){
                cur.add(temp);
            }
            return cur.toArray(new int[cur.size()][]);
        }
        int min=0,i;
        for (i = 0; i < n; ++i) {
            if(newInterval[0]<=intervals[i][1]){
                if(newInterval[0]<intervals[i][0]){
                    min=newInterval[0];
                }
                else {
                    min=intervals[i][0];
                }
                break;
            }
            cur.add(intervals[i]);
        }
        if(newInterval[1]>=intervals[n-1][1]){
            cur.add(new int[]{min,newInterval[1]});
            return cur.toArray(new int[cur.size()-1][]);
        }
        int max;
        while(i<n){
            if(newInterval[1]<intervals[i][1]){
                if(newInterval[1]<intervals[i][0]){
                    max=newInterval[1];
                    cur.add(new int[]{min,max});
                    break;
                }
                max=intervals[i][1];
                cur.add(new int[]{min,max});
                i++;
                break;
            }
            i++;
        }
        while(i<intervals.length){
            cur.add(intervals[i]);
            i++;
        }
        return cur.toArray(new int[cur.size()][]);
    }
    //答案的方法，利用了flag标记，少写了许多冗余的部分
    public int[][] insert2(int[][] intervals, int[] newInterval) {
        int left = newInterval[0];
        int right = newInterval[1];
        boolean placed = false;
        List<int[]> ansList = new ArrayList<int[]>();
        for (int[] interval : intervals) {
            if (interval[0] > right) {
                // 在插入区间的右侧且无交集
                if (!placed) {
                    ansList.add(new int[]{left, right});
                    placed = true;
                }
                ansList.add(interval);
            } else if (interval[1] < left) {
                // 在插入区间的左侧且无交集
                ansList.add(interval);
            } else {
                // 与插入区间有交集，计算它们的并集
                left = Math.min(left, interval[0]);
                right = Math.max(right, interval[1]);
            }
        }
        if (!placed) {
            ansList.add(new int[]{left, right});
        }
        int[][] ans = new int[ansList.size()][2];
        for (int i = 0; i < ansList.size(); ++i) {
            ans[i] = ansList.get(i);
        }
        return ans;
    }
}
