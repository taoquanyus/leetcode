import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] height=new int[]{1,8,100,2,100,4,8,3,7};
        int[] helo =Arrays.copyOfRange(height,0,height.length);
        System.out.println(maxArea(height));
    }
    public static int maxArea(int[] height){
        //我以为这样能够省一些时间，但我还是太年轻了，还是超时
        int n = height.length;
        int left=0,right=n-1;
        int area=Math.min(height[left],height[right])*(n-1);

        while(left<n-1){
            left++;
            if(height[left]>height[0]) break;
        }
        while(right>0){
            right--;
            if(height[right]>height[n-1]) break;
        }

        if(left!=n-1){
            area=Math.max(area,maxArea(Arrays.copyOfRange(height,left,n)));
        }
        if(right!=0){
            area=Math.max(area,maxArea(Arrays.copyOfRange(height,0,right+1)));
        }
        return area;
    }
//参考答案，非常简单
    public int maxArea2(int[] height) {
        int l = 0, r = height.length - 1;
        int ans = 0;
        while (l < r) {
            int area = Math.min(height[l], height[r]) * (r - l);
            ans = Math.max(ans, area);
            if (height[l] <= height[r]) {
                ++l;
            }
            else {
                --r;
            }
        }
        return ans;
    }

}
