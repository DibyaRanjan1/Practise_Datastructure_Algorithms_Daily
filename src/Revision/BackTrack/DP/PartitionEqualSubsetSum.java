package Revision.BackTrack.DP;

public class PartitionEqualSubsetSum {
    public static void main(String[] args) {

    }

    public boolean canPartition(int[] nums) {

   return true;
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
}
