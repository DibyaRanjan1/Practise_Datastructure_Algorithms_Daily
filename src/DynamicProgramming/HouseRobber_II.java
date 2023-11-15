package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class HouseRobber_II {
    public static void main(String[] args) {

    }

    public int rob(int[] nums) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        if(nums.length ==1) return nums[0];
       for(int i=0;i< nums.length;i++){
           if(i!=0) list1.add(nums[i]);
           if(i!= nums.length-1) list2.add(nums[i]);
       }
     return Math.max(findMaxSum_space_optimize(list1,list1.size()),findMaxSum_space_optimize(list2,list2.size()));

    }

    int findMaxSum_space_optimize( List<Integer> arr, int n) {
        int prev2=0,prev=arr.get(0);


        for(int i=1;i<n;i++){
            int take = arr.get(i);

            if(i>1){
                take += prev2;
            }
            int notTake = 0+prev;

            int curr = Math.max(take,notTake);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
}
