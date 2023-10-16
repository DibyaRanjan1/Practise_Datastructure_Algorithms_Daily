package DynamicProgramming;

import java.util.Arrays;

public class HouseRobber {

    private int[] memo;
    public static void main(String[] args) {
     HouseRobber h = new HouseRobber();
    int result = h.rob(new int[]{1,2,3,1});
    }

    public int rob(int[] nums) {
        this.memo = new int[100];
        Arrays.fill(memo,-1);
     return recur(nums,0);
    }

    public int recur(int[] nums,int index){

        if(index >= nums.length) return 0;

        if(this.memo[index]>-1){
            return this.memo[index];
        }

        int first = recur(nums,index+1);
        int second = recur(nums,index+2) + nums[index];

       int ans = Math.max(first,second);
       this.memo[index] = ans;
       return ans;

    }

    public int rob1(int[] nums) {
       int N = nums.length;
       if(N==0) return 0;

       int robNextPluseOne = 0;
       int robNext = nums[N-1];

       for(int i=N-2;i>=0;--i){
           int current = Math.max(robNext,robNextPluseOne+nums[i]);

           robNextPluseOne = robNext;
           robNext = current;
       }
       return robNext;
    }
}
