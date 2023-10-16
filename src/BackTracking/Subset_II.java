package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subset_II {
    public static void main(String[] args) {
    Subset_II s = new Subset_II();
    s.subsetsWithDup(new int[]{1,2,2,3});
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
      List<List<Integer>> ans = new ArrayList<>();
      List<Integer> comb = new ArrayList<>();
      Arrays.sort(nums);

        backtrack(0,ans,comb,nums);
        return ans;
     }

     private void backtrack(int start,List<List<Integer>> ans,List<Integer> comb,int[] nums){


        ans.add(new ArrayList<>(comb));

       for(int i=start;i< nums.length;i++){

           if(i!=start && nums[i] == nums[i-1]) continue;

           comb.add(nums[i]);
           backtrack(i+1,ans,comb,nums);
           comb.remove(comb.size()-1);
       }

     }
}
