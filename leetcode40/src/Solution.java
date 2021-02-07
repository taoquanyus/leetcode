import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int[] nums=new int[]{1,1};
        int target=1;
        combinationSum2(nums,target);
    }
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> combination=new ArrayList<>();
        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(candidates);
        workSum(candidates,target,0,combination,ans);
        return ans;
    }

    private static void workSum(int[] candidates, int target, int index, List<Integer> combination, List<List<Integer>> ans) {
        if(index==candidates.length||candidates[index]>target){
            return;
        }
        int count =1;
        while(index+count<candidates.length&&candidates[index+count]==candidates[index]){
            count++;
        }
        workSum(candidates,target,index+ count,combination,ans);
        if(candidates[index]==target){
            combination.add(candidates[index]);
            ans.add(new ArrayList<Integer>(combination));
            combination.remove(combination.size()-1);
        }
        if(candidates[index]<target){
            combination.add(candidates[index]);
            workSum(candidates,target-candidates[index],index+1,combination,ans);
            combination.remove(combination.size()-1);
        }
        //直接跳过
    }
}
