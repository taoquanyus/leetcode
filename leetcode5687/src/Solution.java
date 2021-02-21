import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        int[] nums=new int[]{-5,-3,-3,-2,7,1,1,2,3,4,5,6,7,3,3,2,4,5,5,6,7,3,3,-1,3,-5,-6,-3,-4,-2,7,-2,-3,-3,-5};
        int[] multipliers=new int[]{-10,-5,3,4,6,3,4,32,2,1,1};
        System.out.println(maximumScore(nums,multipliers));
    }
    public static int maximumScore(int[] nums, int[] multipliers) {
        int m=multipliers.length;
        HashMap<Integer,Integer>[] hashMaps=new HashMap[m];
        return traceback(nums,multipliers,0,0,hashMaps);
    }

    private static int traceback(int[] nums, int[] multipliers, int front, int back,HashMap[] hashmaps) {
        //front 表示前面用了多少数
        //back 表示后面用了多少数
        if(front+back==multipliers.length) return 0;
        HashMap<Integer,Integer> temp=hashmaps[front];
        if(temp!=null&&temp.containsKey(back)){
            return temp.get(back);
        }
        //选择前面
        int count1=nums[front]*multipliers[front+back]+traceback(nums,multipliers,front+1,back,hashmaps);
        //选择后面
        int count2=nums[nums.length-1-back]*multipliers[front+back]+traceback(nums,multipliers,front,back+1,hashmaps);

        int ans=Math.max(count1,count2);
        if(temp==null){
            temp=new HashMap<Integer, Integer>();
            temp.put(back,ans);
            hashmaps[front]=temp;
        }
        else {
            hashmaps[front].put(back,ans);
        }
        return ans;
    }

    //我和答案的思路基本是相同的
    //但是我是真的蠢，没有利用状态转移方程
    //这道题应该是可以写出来的
    public int maximumScore2(int[] nums, int[] multipliers) {
        int m = multipliers.length;
        int[][]dp = new int[m + 1][m + 1];
        dp[1][0] = nums[0] * multipliers[0];
        dp[0][1] = nums[nums.length - 1] * multipliers[0];
        for (int i = 2; i <= m; i++) {
            int mul = multipliers[i - 1];
            for(int l = 0;l <= i;l++){
                int r = i - l;
                int nums_index = nums.length - (i - l);
                if(l == 0){
                    dp[l][r] = dp[l][r - 1] + mul * nums[nums_index];
                    continue;
                }
                if(r == 0){
                    dp[l][r] = dp[l - 1][r] + mul * nums[l - 1];
                    continue;
                }
                dp[l][r] = dp[l - 1][r] + mul * nums[l - 1];
                dp[l][r] = Math.max(dp[l][r],dp[l][r - 1] + mul * nums[nums_index]);
            }
        }
        int ans = Integer.MIN_VALUE;
        for(int i = 0;i <= m;i++){
            ans = Math.max(dp[i][m - i],ans);
        }
        return ans;
    }
}
