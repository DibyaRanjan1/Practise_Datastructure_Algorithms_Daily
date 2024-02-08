package Revision.BackTrack.DP;

import java.util.Arrays;

public class UniquePaths {
    public static void main(String[] args) {

        UniquePaths u = new UniquePaths();
      int count =  u.uniquePaths(3,7);

      int count1 = u.uniquePaths1(3,7);

    }


int result =0;
    public int uniquePaths(int m, int n) {
      int[][] grid = new int[m][n];
      for(int i=0;i<m;i++){
          Arrays.fill(grid[i],0);
      }
        uniquePaths_recur(0,0,m,n,grid);
      return result;
    }

    private void uniquePaths_recur(int rowIndex, int colIndex, int rows, int cols, int[][] grid){

     grid[rowIndex][colIndex] =1;
     if(rowIndex == rows-1 && colIndex == cols-1) result++;

      if(rowIndex+1 < rows ){
          if(grid[rowIndex+1][colIndex]==0) uniquePaths_recur(rowIndex+1,colIndex,rows,cols,grid);
      }
      if(colIndex+1 < cols){
          if(grid[rowIndex][colIndex+1]==0) uniquePaths_recur(rowIndex,colIndex+1,rows,cols,grid);
      }
        grid[rowIndex][colIndex] =0;

    }

    public int uniquePaths1(int m, int n) {

        int[][] memo = new int[m+1][n+1];

        for(int i=0;i<=m;i++){
            Arrays.fill(memo[i],-1);
        }
        uniquePaths_recur1(m-1,n-1,m,n,memo);
        return result;
    }

    private int uniquePaths_recur1(int rowIndex, int colIndex, int rows, int cols, int[][] memo){

      if(rowIndex ==0 && colIndex ==0) return 1;
      if(rowIndex <0 || colIndex <0) return 0;

      if(memo[rowIndex][colIndex]!=-1) return memo[rowIndex][colIndex];

       int up = uniquePaths_recur1(rowIndex-1,colIndex,rows,cols,memo);
       int down = uniquePaths_recur1(rowIndex,colIndex-1,rows,cols,memo);

       return memo[rowIndex][colIndex] = up+down;

    }

    public int uniquePaths_Tabulation(int m, int n) {

        int[][] dp = new int[m+1][n+1];

          dp[0][0] =1;

          for(int row=0;row<m;row++){
              for(int col=0; col<n;col++){

                  if(row==0 && col==0) continue;

                  int up=0;
                  int down=0;
                  if(row >0) {
                       up = dp[row-1][col];
                  }
                  if(col >0){
                      down = dp[row][col-1];
                  }

                  dp[row][col] = up+down;
              }
          }

          return dp[m-1][n-1];
    }

    public int uniquePaths_Tabulation1(int m, int n) {

       int[] prev = new int[m];

       for(int i=0;i<m;i++){
           int[] current = new int[m];

           for(int j=0;j<n;j++){

               if(i==0 && j==0) {
                   prev[j] =0;
               }else {
                   int up=0;
                   int down=0;
                   if(i >0) {
                       up = prev[j];
                   }
                   if(j >0){
                       down = current[j-1];
                   }
                   current[j] = up+down;
               }

               prev = current;


           }
       }
       return prev[n-1];
    }
}
