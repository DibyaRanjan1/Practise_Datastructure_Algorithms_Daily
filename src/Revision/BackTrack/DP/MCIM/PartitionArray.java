package Revision.BackTrack.DP.MCIM;

import java.util.Arrays;

public class PartitionArray {
    public static void main(String[] args) {

    }

    public int maxSumAfterPartitioning(int[] arr, int k) {
       int[] memo = new int[arr.length];
        Arrays.fill(memo,-1);

        return maxSumAfterPartitioning_Recur(0,arr,k,memo);
    }

    public int maxSumAfterPartitioning_Recur(int index,int[] arr,int k,int[] memo) {

        if(index == arr.length) return 0;
        if(memo[index]!=-1) return memo[index];

        int maxi = Integer.MIN_VALUE;
        int maxResult = Integer.MIN_VALUE;
        int length = 0;

        for(int i=index; i< Math.min(index+k,arr.length);i++){
         length++;
         maxi = Math.max(maxi,arr[i]);
         int sum = (length * maxi) + maxSumAfterPartitioning_Recur(i+1,arr,k,memo);
         maxResult = Math.max(maxResult,sum);

        }
        return memo[index] = maxResult;
    }
}
