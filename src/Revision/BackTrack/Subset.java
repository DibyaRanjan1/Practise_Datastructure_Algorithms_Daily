package Revision.BackTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subset {

    public static void main(String[] args) {

        Subset s = new Subset();
        //s.subsets(new int[]{1,2,3});
        s.subsetsWithDup(new int[]{1,2,2});
    }

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> comb = new ArrayList<>();

        backTrack_SubSet(0,nums,comb,result);
        return result;

    }

    private void backTrack_SubSet(int index,int[] nums, List<Integer> comb, List<List<Integer>> result){

        if(index >= nums.length) {
            result.add(new ArrayList<>(comb));
            return;
        }
            comb.add(nums[index]);
            backTrack_SubSet(index+1,nums,comb,result);

            comb.remove(comb.size()-1);
            backTrack_SubSet(index+1,nums,comb,result);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<Integer> comb = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();

        int[] visited = new int[nums.length];

        backTrack_subsetsWithDup(0,nums,comb,result,visited);
        return result;
    }

    private void backTrack_subsetsWithDup(int index,int[] nums,List<Integer> comb,List<List<Integer>> result, int[] visited){

        if(index >= nums.length){
            result.add(new ArrayList<>(comb));
            return;
        }


        comb.add(nums[index]);
        visited[index] =1;

        if(index>0 && (visited[index] == 0 && nums[index-1] == nums[index])) return;

        backTrack_subsetsWithDup(index+1,nums,comb,result,visited);

        comb.remove(comb.size()-1);
        visited[index] =0;
        backTrack_subsetsWithDup(index+1,nums,comb,result,visited);
    }
}
