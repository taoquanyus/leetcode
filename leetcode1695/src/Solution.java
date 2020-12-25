import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;


public class Solution {
    public static void main(String[] args) {
        int[] nums={4,2,4,5,6};
        System.out.println(maximumUniqueSubarray(nums));
    }
    public static int maximumUniqueSubarray(int[] nums){//超出了时间限制，因为map导致超时
        int fore=0;
        HashMap<Integer,Integer> hashmap=new HashMap<>();
        int ans=0;
        int temp=0;
        while(fore<nums.length){
            if(!hashmap.containsKey(nums[fore])){
                hashmap.put(nums[fore],fore);
                temp+=nums[fore];
                fore++;
            }
            else {
                fore=hashmap.get(nums[fore])+1;
                hashmap.clear();
                ans=Math.max(ans,temp);
                temp=0;
            }
        }
        ans=Math.max(ans,temp);
        return ans;
    }
    public static int maximumUniqueSubarray2(int[] nums){//代码很漂亮！
        Set<Integer> hashset=new HashSet<>();
        int start=0,sum=0,max=0;
        for(int i=0;i<nums.length;i++){
            if(!hashset.contains(nums[i])){
                hashset.add(nums[i]);
                sum+=nums[i];
                max=Math.max(max,sum);
            }
            else{
                while(nums[i]!=nums[start]){
                    sum -=nums[start];
                    hashset.remove(nums[start]);
                    start++;
                }
                start++;
            }
        }
        return max;
    }
}
