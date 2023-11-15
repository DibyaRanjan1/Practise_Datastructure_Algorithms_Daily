package DynamicProgramming;

import java.util.Arrays;

public class Min_path {
    public static void main(String[] args) {
      Min_path m = new Min_path();
      int res = m.minPathSum(new int[][]{{1,3,1},{1,5,1},{4,2,1}});
    }

    public int minPathSum(int[][] grid) {
        int[][] mem0 = new int[grid.length][grid[0].length];
        for(int i=0;i< mem0.length;i++){
            Arrays.fill(mem0[i],-1);
        }
       return dp(0,0, grid.length, grid[0].length,grid, mem0);
    }



    private int dp(int row, int col, int rows, int cols, int[][] grid,int[][] memo){

         if(row >=rows || col >=cols) return Integer.MAX_VALUE;
         if(row == rows-1&& col == cols-1) return grid[row][col];

         if(memo[row][col] !=-1) return memo[row][col];
        int down  =  dp(row+1,col,rows,cols,grid,memo);
        int up = dp(row,col+1,rows,cols,grid,memo);

         memo[row][col] =   grid[row][col] +  Math.min(down,up);
         return memo[row][col];

    }

    public int minPathSum_tabulation(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

       int[] prev = new int[cols];

        for(int row=0;row<rows;row++){
            int[] curr = new int[cols];

            for(int col=0;col<cols;col++){
                if(row ==0 && col==0){
                    curr[col] = grid[row][col];
                }else {
                    int up = grid[row][col];

                    if(row >0) up+= prev[col];

                    int left = grid[row][col];
                    if(col > 0) left += curr[col-1];

                    curr[col] = Math.min(up,left);
                }
            }
            prev = curr;
        }
        return prev[cols-1];
    }
}
