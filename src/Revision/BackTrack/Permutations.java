package Revision.BackTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        Permutations p = new Permutations();
        p.permute(new int[]{1,2,3});
    }
    public List<List<Integer>> permute(int[] nums) {
        int N = nums.length;;
        List<List<Integer>> result = new ArrayList<>();

        List<Integer> comb = new ArrayList<>();
        backtrack(nums,result,comb);
        return result;
    }

    private void backtrack(int[] nums, List<List<Integer>> result, List<Integer> comb){


        if(comb.size() == nums.length){
            result.add(new ArrayList<>(comb));
            return;
        }

        for(int num:nums){
            if(!comb.contains(num)){
                comb.add(num);
                backtrack(nums,result,comb);
                comb.remove(comb.size()-1);
            }
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> comb = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];

         backtrack_PermuteUnique(nums,comb,result,visited);
         return result;
    }

    private void backtrack_PermuteUnique(int[] nums, List<Integer> comb,List<List<Integer>> result, boolean[] visited){

        if(nums.length == comb.size()){
            result.add(new ArrayList<>(comb));
            return;
        }

        for(int i=0;i<nums.length;i++){

          if(visited[i]) continue;
          if(i>0 && (!visited[i] && nums[i-1] == nums[i])) continue;

          comb.add(nums[i]);
          backtrack_PermuteUnique(nums,comb,result,visited);
          visited[i] =false;
          comb.remove(comb.size()-1);

        }
    }
}
