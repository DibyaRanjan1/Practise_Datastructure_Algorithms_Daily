package LeetCode_Top_150.Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIsland {
    public static void main(String[] args) {

        NumberOfIsland n = new NumberOfIsland();

        char[][] grid = new char[][]{
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'},
        };
        n.numIslands(grid);
    }

    public int numIslands(char[][] grid) {
       int cols = grid[0].length;
       int rows = grid.length;

       int islandsCount = 0;

       Boolean[][] visited = new Boolean[rows][cols];

       for(int i=0;i<rows;i++){
           Arrays.fill(visited[i],false);
       }


        for(int i=0;i<rows;i++){
          for(int j=0;j<cols;j++){
              if(!visited[i][j] && grid[i][j]=='1'){
                  ++islandsCount;
                  bfs(i,j,grid,visited);
              }
          }
        }

        return islandsCount;
    }

    private void bfs(int row,int col,char[][] grid,Boolean[][] visited){

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row,col});
        visited[row][col] = true;

        int[] x = new int[]{1,-1,0,0};
        int[] y = new int[]{0,0,1,-1};

        int cols = grid[0].length;
        int rows = grid.length;

        while (!queue.isEmpty()){
          int currentRow =  queue.peek()[0];
          int currentCol = queue.peek()[1];

          queue.remove();

          for(int i=0;i<4;i++){
            int newRow = currentRow + x[i];
            int newCol = currentCol + y[i];

            if(newRow <0 || newRow >= rows || newCol <0 || newCol >=cols || grid[newRow][newCol]=='0' || visited[newRow][newCol]) continue;

            visited[newRow][newCol] = true;
            queue.add(new int[]{newRow,newCol});
          }

        }
    }
}
