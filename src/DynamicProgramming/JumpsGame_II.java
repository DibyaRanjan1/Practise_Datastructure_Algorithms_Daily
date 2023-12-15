package DynamicProgramming;

import java.util.Arrays;

public class JumpsGame_II {


    public static void main(String[] args) {
       JumpsGame_II j = new JumpsGame_II();
    //int count =   j.jump(new int[]{2,3,1,1,4});
//        int count =   j.jump_tab(new int[]{2,1});
        int count =   j.jump_greedy(new int[]{2,3,1,1,4});
    }

    public int jump(int[] nums) {
        int[] memo = new int[nums.length+1];
        Arrays.fill(memo,-1);

         return jump_Util(nums,0,memo);
    }
    public int jump_Util(int[] nums, int index ,int[] memo) {
        if(index >=nums.length-1) return 0;

        if(memo[index]!=-1) return memo[index];
        int jump = nums[index];
        int min = nums.length;
        for(int i=1;i<=jump;i++){
          min = Math.min(min, 1+ jump_Util(nums,index+ i,memo));
        }
        return memo[index] =  min;
    }

    public int jump_tab(int[] nums) {
        int[] dp = new int[nums.length+1];
        Arrays.fill(dp,-1);
        dp[nums.length-1] = 0;


        for(int index=nums.length-1;index>=0;--index){
            int jump = nums[index];
            int min = nums.length;
            for(int i=1;i<=jump;i++){
                min = Math.min(min, 1+ dp[index+ i]);
            }
            dp[index]=min;
        }
        return dp[0];
    }

    public int jump_greedy(int[] nums) {
        int answer = 0, n = nums.length;
        int curEnd = 0, curFar = 0;

        for (int i = 0; i < n - 1; ++i) {
            curFar = Math.max(curFar, i + nums[i]);


            if (i == curEnd) {
                answer++;
                curEnd = curFar;
            }
        }

        return answer;
    }

}
