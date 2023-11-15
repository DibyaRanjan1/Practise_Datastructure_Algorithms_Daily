package DynamicProgramming;

import java.util.Arrays;

public class SubsetEqualK {
    public static void main(String[] args) {
     boolean res =   subsetSumToK(4,4,new int[]{6,1,2,1});
    }

    public static boolean subsetSumToK(int n, int k, int arr[]){
        int[][] dp = new int[n][k+1];

        for(int[] row:dp){
          Arrays.fill(row,-1);
        }

      return isSubsetExists(n,k,arr,n-1,dp);
    }

    private static boolean isSubsetExists(int n,int k,int arr[],int index,int[][] dp){
        if(k==0) return true;
        if(index ==0) return arr[index] ==k;

        if(dp[index][k]!=-1) return dp[index][k] ==1;

        boolean nottake = isSubsetExists(n,k,arr,index-1,dp);

        boolean take = false;

        if(k > arr[index]){
            take = isSubsetExists(n,k-arr[index],arr,index-1,dp);
        }
         dp[index][k] = (take || nottake) ?1:0;
        return (take || nottake);
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

                 if(arr[i] <=k){
                     take = dp[i-1][j-arr[i]];
                 }
                 dp[i][k] = (take || nottake);
             }
         }
         return dp[n-1][k];

    }
}
