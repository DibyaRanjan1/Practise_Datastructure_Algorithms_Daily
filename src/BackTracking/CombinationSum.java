package BackTracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
       CombinationSum c = new CombinationSum();
       c.combinationSum(new int[]{2,3,6,7},7);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> lst = new LinkedList<>();

        helper(result,0,candidates,lst,target);
        return result;
    }

    private void helper(List<List<Integer>> ans,int start, int[] candidates, LinkedList<Integer> lst, int target){

       if(target ==0){
           ans.add(new ArrayList<>(lst));
       } else if (target < 0) {
           return;
       }

       for(int i = start;i<candidates.length;i++){
           lst.add(candidates[i]);
           helper(ans,i,candidates,lst,target-candidates[i]);
           lst.removeLast();
       }
    }
}
