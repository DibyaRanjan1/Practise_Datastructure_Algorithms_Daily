package BackTracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Permutation {
    public static void main(String[] args) {
   Permutation p = new Permutation();
   p.permute(new int[]{1,2,3});
    }

    public List<List<Integer>> permute(int[] nums) {
      List<List<Integer>> ans = new ArrayList<>();
        LinkedList<Integer> comb = new LinkedList<>();
         helperBackTrack(ans,comb,nums);
      return ans;
    }

    private void helperBackTrack(List<List<Integer>> ans,LinkedList<Integer> comb,int[] nums){

        if(comb.size()==nums.length){
            ans.add(new ArrayList<>(comb));
            return;
        }

        for(int num:nums){
            if(!comb.contains(num)){
                comb.add(num);
                helperBackTrack(ans,comb,nums);
                comb.remove(comb.size()-1);
            }
        }
    }
}
