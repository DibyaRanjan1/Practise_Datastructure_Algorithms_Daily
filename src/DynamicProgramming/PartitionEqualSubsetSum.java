package DynamicProgramming;

public class PartitionEqualSubsetSum {
    public static void main(String[] args) {
     boolean result =  canPartition(new int[]{1,5,11,5});
    }

    public static boolean canPartition(int[] nums) {

        int totalSum = 0;

        for(int i=0;i< nums.length;i++){
            totalSum += nums[i];
        }

        if(totalSum%2==1) return false;

        int target = totalSum/2;

      return isSubsetExists_tabulation(nums.length, target,nums);
    }

    private static boolean isSubsetExists_tabulation(int n,int k,int arr[]){
        boolean[][] dp = new boolean[n][k+1];

        for(int i=0;i<n;i++){
            dp[i][0] = true;
        }
        if(arr[0] <=k){
            dp[0][arr[0]] = true;
        }

        for(int i=1;i<n;i++){
            for(int j=1;j<=k;j++){

                boolean nottake = dp[i-1][j];

                boolean take = false;

                if(arr[i] <=j){
                    take = dp[i-1][j-arr[i]];
                }
                dp[i][j] = (take || nottake);
            }
        }
        return dp[n-1][k];

    }
}
