package Revision.BackTrack.DP;

public class SubsetSum {
    public static void main(String[] args) {
       SubsetSum s = new SubsetSum();
      boolean res = s.subsetSumToK(5,4,new int[]{2,5,1,6,7});
    }

    public boolean subsetSumToK(int n, int k, int arr[]){
        Boolean[][] memo = new Boolean[n+1][k+1];
       return subsetSumToK_recur(n-1,k,arr, memo);
    }

    private boolean subsetSumToK_recur(int index,int k, int arr[], Boolean[][] memo){

        if(k==0) return true;
        if(index == 0) return arr[0]== k;
        if(k <0 || index <0) return false;

        if(memo[index][k]!=null) return memo[index][k];

       boolean take = false;
       if(arr[index] <=k) take = subsetSumToK_recur(index-1,k-arr[index],arr,memo);
       if(take) return true;

      boolean notTake = subsetSumToK_recur(index-1,k,arr,memo);
       return memo[index][k] =  take || notTake;
    }


    public boolean subsetSumToK_tabulation(int n, int k, int arr[]) {
        Boolean[][] dp = new Boolean[n + 1][k + 1];

        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        dp[0][arr[0]] = true;

        for (int i = 1; i < n; i++) {
            for (int K = 1; K <= k; K++) {

               boolean take = false;
               if(arr[i] <=k) take = dp[i-1][K];
               boolean nottake = dp[i-1][K];
               dp[i][K] = take || nottake;
            }
        }
     return dp[n-1][k];
    }

    public boolean subsetSumToK_spaceOptimize(int n, int k, int arr[]) {

        Boolean[] prev = new Boolean[k+1];
        Boolean[] current = new Boolean[k+1];

        prev[0] = current[0]=true;

        prev[arr[0]] = true;


        for (int i = 1; i < n; i++) {
            for (int K = 1; K <= k; K++) {

                boolean take = false;
                if(arr[i] <=k) take = prev[K-arr[i]];
                boolean nottake = prev[K];
                current[K] = take || nottake;
            }
            prev = current;
        }
        return prev[k];
    }

}
