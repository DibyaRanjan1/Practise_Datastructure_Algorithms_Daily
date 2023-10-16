package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combination_II {
    public static void main(String[] args) {
       Combination_II c = new Combination_II();
     var result =  c.combinationSum2(new int[]{1,1,2,},2);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);

        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> comb = new ArrayList<>();

        backtrack(ans,0,comb,target,candidates);
        return ans;

    }

    private void backtrack(List<List<Integer>> ans, int index,List<Integer> comb,int target, int[] candidates){

        if(target ==0){
            ans.add(new ArrayList<>(comb));
            return;
        } else if (target<0) {
            return;
        }

        for(int i=index;i<candidates.length;i++){
            if(i!=index && candidates[i] == candidates[i-1]){
               continue;
            }
            comb.add(candidates[i]);
            backtrack(ans,i+1,comb,target-candidates[i],candidates);
            comb.remove(comb.size()-1);
        }
    }
}
