package Revision.BackTrack.DP;

import java.util.Arrays;

public class FalingPathSum {
    public static void main(String[] args) {
     FalingPathSum f = new FalingPathSum();
     //int[][] input = {{2,1,3},{6,5,4},{7,8,9}};
        int[][] input = {{17,82},{1,-44}};
    int result = f.minFallingPathSum(input);
    }

    public int minFallingPathSum(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        long mini = Integer.MAX_VALUE;
        long[][] memo = new long[rows][cols];

        for(int i=0;i<rows;i++){
            Arrays.fill(memo[i],Integer.MIN_VALUE);
        }

        for(int i=0;i<cols;i++){
            mini = Math.min(mini,minFallingPathSum_recur(rows-1,i,matrix,memo));

        }

      return (int)mini;
    }

    private long minFallingPathSum_recur(int rowIndex,int colIndex, int[][] matrix, long[][] memo){


        if(rowIndex == 0 && colIndex>=0 && colIndex < matrix[0].length){
            return matrix[0][colIndex];
        }
        if(rowIndex < 0 || colIndex <0 || colIndex >= matrix[0].length ) return Integer.MAX_VALUE;

        if(memo[rowIndex][colIndex] !=Integer.MIN_VALUE) return memo[rowIndex][colIndex];

        long straightUp =matrix[rowIndex][colIndex] + minFallingPathSum_recur(rowIndex-1,colIndex,matrix,memo);
        long leftup =matrix[rowIndex][colIndex] +  minFallingPathSum_recur(rowIndex-1,colIndex-1,matrix,memo);
        long rightup = matrix[rowIndex][colIndex] +  minFallingPathSum_recur(rowIndex-1,colIndex+1,matrix,memo);

       return memo[rowIndex][colIndex] = Math.min(straightUp,Math.min(leftup,rightup));

    }
}
