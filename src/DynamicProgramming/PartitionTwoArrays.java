package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;

public class PartitionTwoArrays {
    // Helper function to calculate the minimum absolute difference of two subsets
    static int minSubsetSumDifference(int[] arr) {
        int totSum = 0;
        int n = arr.length;

        // Calculate the total sum of the array elements
        for (int i = 0; i < n; i++) {
            totSum += arr[i];
        }

        // Create a DP table to store subset sum information
        boolean[][] dp = new boolean[n][totSum + 1];

        // Initialize the DP table for the first row
        for (int i = 0; i <= totSum; i++) {
            dp[0][i] = (i == arr[0]);
        }

        // Fill in the DP table using bottom-up dynamic programming
        for (int ind = 1; ind < n; ind++) {
            for (int target = 0; target <= totSum; target++) {
                // Calculate if the current element is not taken
                boolean notTaken = dp[ind - 1][target];

                // Calculate if the current element is taken
                boolean taken = false;
                if (arr[ind] <= target) {
                    taken = dp[ind - 1][target - arr[ind]];
                }

                // Update the DP table for the current element and target sum
                dp[ind][target] = notTaken || taken;
            }
        }

        int mini = Integer.MAX_VALUE;

        // Find the minimum absolute difference between two subsets
        for (int i = 0; i <= totSum; i++) {
            if (dp[n - 1][i]) {
                int diff = Math.abs(i - (totSum - i));
                mini = Math.min(mini, diff);
            }
        }
        return mini;
    }

    public static void main(String[] args) {
       int[] arr = new int[]{1, 2, 3, 4};
        int n = arr.length;

        // Calculate and print the minimum absolute difference
        System.out.println("The minimum absolute difference is: " + minSubsetSumDifference(arr));
    }
}






