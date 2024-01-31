package Revision.BackTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combination {
    public static void main(String[] args) {

        Combination c = new Combination();
    // var result =   c.combinationSum(new int[]{2,3,6,7},7);
       // var result = c.combinationSum2(new int[]{2,5,2,1,2},5);

        //var result = c.combinationSum3(3,9);

         var result = c.combinationSum4(new int[]{1,2,3},4);

    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> comb = new ArrayList<>();


        backtrack_combinationSum(0,candidates,result,comb,target);
        return result;

    }

     private void backtrack_combinationSum(int index, int[] candidates, List<List<Integer>> result,List<Integer> comb, int target){

        if(target ==0){
            result.add(new ArrayList<>(comb));

        } else if (target < 0) {
            return;
        }

        for(int i=index;i<candidates.length;i++){
                comb.add(candidates[i]);
                backtrack_combinationSum(i,candidates,result,comb,target-candidates[i]);
                comb.remove(comb.size()-1);
        }
     }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> comb = new ArrayList<>();

        Arrays.sort(candidates);

        backtrack_combinationSum2(0,candidates,comb,result,target);

         return result;
    }

    private void backtrack_combinationSum2(int index,int[] candidates, List<Integer> comb, List<List<Integer>> result,int target){
        if(target ==0){
            result.add(new ArrayList<>(comb));
            return;
        } else if (target <=0) {
            return;
        }

        for(int i=index;i<candidates.length;i++){

            if(i!=index && candidates[i-1]==candidates[i]){
                continue;
            }
            comb.add(candidates[i]);
            backtrack_combinationSum2(i+1,candidates,comb,result,target-candidates[i]);
            comb.remove(comb.size()-1);
        }
    }

    int K=0;
    int N=0;
    public List<List<Integer>> combinationSum3(int k, int n) {
      List<List<Integer>> result = new ArrayList<>();
      List<Integer> comb = new ArrayList<>();
      K = k;
      N =n;

      backtrack_combinationSum3(1,k,n,result,comb);
      return result;
    }



    private void backtrack_combinationSum3(int currentNumber,int k,int sum,List<List<Integer>> result, List<Integer> comb){
        if(sum ==0 && k==0){
            result.add(new ArrayList<>(comb));
            return;
        } else if (sum <0 || k<0 || comb.size()>=K) {
            return;
        }

        for (int i=currentNumber;i<=N;i++){
            comb.add(i);
            backtrack_combinationSum3(i+1,k-1,sum-i,result,comb);
            comb.remove(comb.size()-1);
        }
    }

    public int combinationSum4(int[] nums, int target) {
      List<List<Integer>> result = new ArrayList<>();
      List<Integer> comb = new ArrayList<>();
      backtrack_combinationSum4(0,nums,comb,result,target);
      return result.size();
    }

    private void backtrack_combinationSum4(int index,int[] nums,List<Integer> comb, List<List<Integer>> result, int target){
        if(target ==0){
            result.add(new ArrayList<>(comb));
            return;
        } else if (target <0) {
            return;
        }

        for(int i=0;i< nums.length;i++){
            comb.add(nums[i]);
            backtrack_combinationSum4(i,nums,comb,result,target-nums[i]);
            comb.remove(comb.size()-1);

        }
    }

    public int combinationSum4_memo(int[] nums, int target) {

        Integer[] memo = new Integer[target+1];
        return combinationSum4_memo_util(0,nums,target,memo);
    }

    public int combinationSum4_memo_util(int index,int[] nums, int target,Integer[] memo) {
        if(target ==0){
            return 1;
        }
        if(target<0) return 0;
        if(memo[index]!=null) return memo[index];

        int count=0;
        for(int i=0;i<nums.length;i++){
         count +=  combinationSum4_memo_util(index+1,nums,target-nums[i],memo);
        }

        return memo[index] = count;

    }
}
