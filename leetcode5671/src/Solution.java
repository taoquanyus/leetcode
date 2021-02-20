import java.util.LinkedList;

class Solution {
//bfs
    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length, n = isWater[0].length,cnt=0,height=0;
        int[][] heights = new int[m][n];
        LinkedList<int[]> cords = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(isWater[i][j]==1){
                    //找到水源的位置和水源的个数
                    cords.offer(new int[]{i,j});//水池的队列
                    cnt++;
                }else {
                    heights[i][j]=-1;//初始值为-1
                }
            }
        }
        while (!cords.isEmpty()){
            int size = cords.size();
            height++;
            for (int i = 0; i < size; i++) {
                int[] cord = cords.pollFirst();//水池的源
                for (int[] dir: dirs){
                    int x = cord[0]+dir[0];
                    int y = cord[1]+dir[1];
                    if(x>=0 && x<m && y>=0 && y<n && heights[x][y]==-1){
                        cnt++;
                        heights[x][y]=height;
                        cords.offer(new int[]{x,y});
                    }
                    if(cnt==m*n)return heights;
                }
            }
        }
        return heights;
    }

    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    //上下左右四个点

}
