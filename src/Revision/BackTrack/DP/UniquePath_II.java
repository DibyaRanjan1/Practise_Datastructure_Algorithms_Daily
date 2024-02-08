package Revision.BackTrack.DP;

import java.util.Arrays;

public class UniquePath_II {
    public static void main(String[] args) {
        UniquePath_II u = new UniquePath_II();

        int[][] input = {{0,0,0},{0,1,0},{0,0,0}};
        u.uniquePathsWithObstacles(input);

        int res = u.uniquePathsWithObstacles_memo(input);

        int res1 = u.uniquePathsWithObstacles_tabulation1(input);
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;

       int result = uniquePathsWithObstacles_recur(rows-1,cols-1,obstacleGrid);
       return result;
    }

    private int uniquePathsWithObstacles_recur(int rowIndex, int colIndex, int[][] grid){

        if(rowIndex == 0 && colIndex ==0) return 1;
        if(rowIndex <0 || colIndex <0 || grid[rowIndex][colIndex] ==1) return 0;

            int up = uniquePathsWithObstacles_recur(rowIndex-1,colIndex,grid);
            int down = uniquePathsWithObstacles_recur(rowIndex,colIndex-1,grid);

       return up+down;
    }

    public int uniquePathsWithObstacles_memo(int[][] obstacleGrid) {

        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;

        int[][] memo = new int[rows][cols];

        for (int i=0;i<rows;i++){
            Arrays.fill(memo[i],-1);
        }

        int result = uniquePathsWithObstacles_memo(rows-1,cols-1,obstacleGrid,memo);
        return result;
    }

    private int uniquePathsWithObstacles_memo(int rowIndex, int colIndex, int[][] grid, int[][] memo){

        if(rowIndex == 0 && colIndex ==0) return 1;
        if(rowIndex <0 || colIndex <0 || grid[rowIndex][colIndex] ==1) return 0;

        if(memo[rowIndex][colIndex]!=-1) return memo[rowIndex][colIndex];

        int up = uniquePathsWithObstacles_recur(rowIndex-1,colIndex,grid);
        int down = uniquePathsWithObstacles_recur(rowIndex,colIndex-1,grid);

        return memo[rowIndex][colIndex] = up+down;
    }

    public int uniquePathsWithObstacles_tabulation(int[][] obstacleGrid) {

        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;

        int[][] dp = new int[rows][cols];

        dp[0][0] = 1;

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){

                if(i==0 && j==0){
                    dp[0][0] =1;
                } else if (obstacleGrid[i][j]==1) {
                    continue;
                } else {
                    int up=0;
                    int left=0;

                    if(i>0){
                        up = dp[i-1][j];
                    }
                    if(j>0){
                        left = dp[i][j-1];
                    }

                    dp[i][j] = up+left;
                }
            }
        }

        return dp[rows-1][cols-1];

    }

    public int uniquePathsWithObstacles_tabulation1(int[][] obstacleGrid) {

        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;

        int[] prev = new int[cols];



        for(int i=0;i<rows;i++){

            int[] current = new int[cols];

            for(int j=0;j<cols;j++){

                if(i==0 && j==0){
                current[j] =1;
                } else if (obstacleGrid[i][j]==1) {
                    continue;
                } else {
                    int up=0;
                    int left=0;

                    if(i>0){
                        up = prev[j];
                    }
                    if(j>0){
                        left = current[j-1];
                    }

                    current[j] = up+left;
                }
            }
            prev = current;
        }

        return prev[cols-1];

    }
}
