package DynamicProgramming.LIS;

import java.util.Arrays;

public class LengthLIS {
    public static void main(String[] args) {
        LengthLIS l = new LengthLIS();
       int result = l.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18});

    }

    public int lengthOfLIS(int[] nums) {

        int n = nums.length;
        int[][] memo = new int[n+1][n+1];

        for(int i=0;i<=n;i++){
            Arrays.fill(memo[i],-1);
        }


        return lengthOfLIS_DP(0,-1,nums,memo);
    }

    private int lengthOfLIS_DP(int index,int prevIndex,int[] nums, int[][] memo){

        if(index == nums.length ) return 0;
         if(memo[index][prevIndex+1] !=-1) return memo[index][prevIndex+1];
        int length = lengthOfLIS_DP(index+1,prevIndex,nums,memo);

        if(prevIndex ==-1 || nums[index] > nums[prevIndex]){
            length =Math.max(length,1+ lengthOfLIS_DP(index+1,index,nums,memo)) ;
        }
       return memo[index][prevIndex+1] =  length;
    }

    public int lengthOfLIS_tabulation(int[] nums) {

        int n = nums.length;
        int[][] memo = new int[n+1][n+1];

        for(int index=n-1;index>=0;--index){

            for(int prevIndex=index-1;prevIndex>=-1; -- prevIndex){

                int length = memo[index+1][prevIndex+1];

                if(prevIndex ==-1 || nums[index] > nums[prevIndex]){
                    length =Math.max(length,1+ memo[index+1][index+1]) ;
                }

                memo[index][prevIndex+1] = length;
            }
        }
        return memo[0][0];
    }
}
