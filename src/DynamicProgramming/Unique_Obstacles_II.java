package DynamicProgramming;

import java.util.Arrays;

public class Unique_Obstacles_II {
    public static void main(String[] args) {

        Unique_Obstacles_II u = new Unique_Obstacles_II();
        u.uniquePathsWithObstacles(new int[][]{{0,0,0},{0,1,0},{0,0,0}});
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

       int rows = obstacleGrid.length;
       int cols = obstacleGrid[0].length;

       int[][] memo = new int[rows][cols];

       for(int i=0;i<rows;i++){
           Arrays.fill(memo[i],-1);
       }

       int result = dp(0,0,rows,cols,obstacleGrid,memo);
       return result;
    }

    private int dp(int row,int col,int rows,int cols,int[][] obst,int[][] memo){
        if(row >=rows || col >= cols) return 0;
        if(obst[row][col] ==1) return 0;
        if(row == rows-1 && col == cols-1) return 1;

        if(memo[row][col] !=-1) return memo[row][col];

        int down = dp(row+1,col,rows,cols,obst,memo);
        int right = dp(row, col+1,rows,cols,obst,memo);

        return memo[row][col] = down+right;

    }
}
