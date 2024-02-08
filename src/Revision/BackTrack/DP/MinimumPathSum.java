package Revision.BackTrack.DP;

public class MinimumPathSum {
    public static void main(String[] args) {
    MinimumPathSum m = new MinimumPathSum();

    int[][] input = {{1,3,1},{1,5,1},{4,2,1}};
   int result = m.minPathSum(input);
    }

    public int minPathSum(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        long res =  minpathSum_Recur(rows-1,cols-1,grid);
        return (int)(res);
    }

    long mini = Integer.MAX_VALUE;


    private long minpathSum_Recur(int rowIndex, int colIndex,int[][] grid){

        if(rowIndex ==0 && colIndex ==0){
           return grid[rowIndex][colIndex];
        }
        if(rowIndex <0 || colIndex <0){
            return Integer.MAX_VALUE;
        }


            long up = grid[rowIndex][colIndex] +  minpathSum_Recur(rowIndex-1,colIndex,grid);
            long down = grid[rowIndex][colIndex] + minpathSum_Recur(rowIndex,colIndex-1,grid);

           return Math.min(up,down);


    }
}
