import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length==1) return intervals;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        List<int[]>ans=new ArrayList<>();
        ans.add(intervals[0]);
        int max=intervals[0][1];
        for(int i=1;i<intervals.length;++i){
            int[] interval=intervals[i];
            if(interval[0]>max){
                ans.add(interval);
                max=interval[1];
            }
            if(interval[0]<=max){
                int temp[]=ans.get(ans.size()-1);
                temp[1]=Math.max(temp[1],interval[1]);
                max=temp[1];
            }
        }

        return ans.toArray(new int[ans.size()][]);
    }
}
