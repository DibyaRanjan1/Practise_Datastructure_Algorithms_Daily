package DynamicProgramming;

import java.util.Arrays;

public class JumpGame {
    public static void main(String[] args) {
      JumpGame j = new JumpGame();
     //boolean res = j.canJump(new int[]{2,3,1,1,4});
        boolean res = j.canJump_tabulation(new int[]{2,3,1,1,4});
    }

    public boolean canJump(int[] nums) {
        int[] memo = new int[nums.length+1];
        Arrays.fill(memo,-1);
       return canJump_Util(nums,0,memo);
    }

    private boolean canJump_Util(int[] nums,int index, int[] memo){

        if(index >= nums.length-1) return true;

        if(memo[index]!=-1) return memo[index] ==1;
        int jump = Math.min(index+ nums[index],nums.length-1);

        for (int i=index+1;i<= jump;i++){
          boolean result =  canJump_Util(nums,i,memo);

          if(result){
              memo[i] = 1;
              return true;
          }

        }
        memo[index] = 0;
        return false;
    }

    public boolean canJump_tabulation(int[] nums) {
        int[] memo = new int[nums.length+1];
        Arrays.fill(memo,-1);

        memo[nums.length-1] = 1;

        for(int index=nums.length-2;index>=0;--index){
            int jump = Math.min(index+ nums[index],nums.length-1);
            for(int j=index+1;j<=jump;j++){

                if(memo[j]==1){
                    memo[index] = 1;
                    break;
                }
            }
        }
        return memo[0] == 1;
    }

    public boolean canJump_Greedy(int[] nums){
        int lastPos = nums.length-1;
        for(int i=nums.length-1;i>=0;--i){

            if(i+nums[i] >= lastPos){
                lastPos = i;
            }
        }
        return lastPos ==0;
    }
}
