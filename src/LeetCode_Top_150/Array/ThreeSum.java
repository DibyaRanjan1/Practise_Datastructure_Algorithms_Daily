package LeetCode_Top_150.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
      ThreeSum t  =new ThreeSum();
      t.threeSum(new int[]{-2,0,1,1,2});
    }

    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for(int i=0;i<nums.length;i++){

            if(i>0 && nums[i]==nums[i-1]) continue;
            int j = i+1;
            int k = nums.length-1;

            while (j<k){

                int sum = nums[i]+nums[j]+nums[k];

                if(sum>0){
                    --k;
                } else if (sum<0) {
                    j++;
                }else {

                    ArrayList<Integer> subResult = new ArrayList<>();

                    subResult.add(nums[i]);
                    subResult.add(nums[j]);
                    subResult.add(nums[k]);

                    result.add(subResult);

                    j++;
                    --k;

                    while (j<k && nums[k] ==nums[k+1]){
                        --k;
                    }
                    while (j<k && nums[j]==nums[j-1]){
                        j++;
                    }
                }
            }
        }

        return result;
    }
}
