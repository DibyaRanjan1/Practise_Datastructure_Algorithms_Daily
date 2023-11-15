package DynamicProgramming;

import java.util.Arrays;

public class FindMaxSum {

    int result = Integer.MIN_VALUE;
    public static void main(String[] args) {
      FindMaxSum f = new FindMaxSum();
      f.findMaxSum(new int[]{3, 2, 7, 10},4);
    }

    int findMaxSum(int arr[], int n) {
        int[] memo = new int[n+1];
        Arrays.fill(memo,-1);
int result = dp(arr,n-1,n,memo);
return result;
    }

    int dp(int[] arr, int index,int n, int[] memo){

        if(index < 0){
            return 0;
        }
        if(memo[index]!=-1) return memo[index];

       return memo[index] =  Math.max(dp(arr,index-1,n,memo),dp(arr,index-2,n,memo)+arr[index]);
    }

    int findMaxSum_realdp(int arr[], int n) {
       int[] dp = new int[n];
       Arrays.fill(dp,-1);
       dp[0] = arr[0];
        for(int i=1;i< n;i++){

           int take =  arr[i];
           if(i>1){
               take += dp[i-2];
           }
           int notTake = dp[i-1];

           dp[i] = Math.max(take,notTake);
        }
        return dp[n-1];
    }

    int findMaxSum_space_optimize(int arr[], int n) {
        int prev2=0,prev=arr[0];
        for(int i=1;i<n;i++){
            int take = arr[i];

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
