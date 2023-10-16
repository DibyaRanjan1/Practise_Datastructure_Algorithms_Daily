package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class Subset {
    public static void main(String[] args) {
        Subset s = new Subset();
        s.subsets(new int[]{1,2,3});
    }

    public List<List<Integer>> subsets(int[] nums) {
     List<List<Integer>> result = new ArrayList<>();
     List<Integer> list = new ArrayList<>();
       helper(result,0,nums,list);
       return result;
    }

    private void helper(List<List<Integer>> result, int start,int[] nums, List<Integer> lst){
        if(start >= nums.length){
            result.add(new ArrayList<>(lst));
        }else {

            lst.add(nums[start]);
            helper(result,start+1,nums,lst);

            lst.remove(lst.size()-1);

            helper(result,start+1,nums,lst);
        }
    }


}
