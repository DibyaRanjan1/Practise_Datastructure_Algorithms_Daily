package BackTracking;

import java.util.*;

public class Permutation_II {
    public static void main(String[] args) {
        Permutation_II p = new Permutation_II();
        p.permuteUnique(new int[]{1,2,1});
    }

    public List<List<Integer>> permuteUnique(int[] nums) {

       Arrays.sort(nums);
       List<List<Integer>> result = new ArrayList<>();
       boolean[] visited = new boolean[nums.length];

       util(nums,visited,new ArrayList<>(),result);
        return result;
    }

    private void util(int[] nums, boolean[] visited, List<Integer> comb, List<List<Integer>> result){

        if(comb.size() == nums.length){
            result.add(new ArrayList<>(comb));
             return;
        }

        for(int i=0;i< nums.length;i++){

            if(visited[i]) continue;
            if(i>0 && (!visited[i-1] && nums[i-1] == nums[i])) continue;
            visited[i]=true;
            comb.add(nums[i]);

            util(nums,visited,comb,result);

            visited[i]=false;
            comb.remove(comb.size()-1);
        }
    }
}
