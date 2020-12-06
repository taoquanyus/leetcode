public class Solution {
    public int xorOperation(int n, int start){//很简单的模拟法
        int ans=0;
        for(int i=0;i<n;++i){
            int num=start+2*i;
            ans=ans^num;
        }
        return ans;
    }
    public int xorOperation1(int n, int start){//可以再省一个变量内存
        int ans=0;
        for(int i=0;i<n;++i){
            ans^=start+2*i;
        }
        return ans;
    }
}
