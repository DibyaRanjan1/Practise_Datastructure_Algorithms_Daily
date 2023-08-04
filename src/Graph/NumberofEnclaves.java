package Graph;

public class NumberofEnclaves {
    public static void main(String[] args) {
        NumberofEnclaves vv = new NumberofEnclaves();
        int[][] arr = {
                {1 ,0 ,1 ,0 ,1},
                {0 ,1, 0, 1 ,0},
                {1 ,0 ,1 ,0 ,1},
                {0 ,1 ,0 ,1 ,0},

                {1, 0, 1, 0, 1},
                {0 ,1 ,0 ,1 ,0},

                {1, 0, 1, 0, 1},
                {0 ,1 ,0 ,1 ,0},
        };
       int result = vv.numEnclaves(arr);
    }

    public int numEnclaves(int[][] grid) {
       int totalRows = grid.length;
       int totalCols = grid[0].length;

       int[][] visited = new int[totalRows][totalCols];
       int[] xrow = {0,0,1,-1};
       int[] ycol = {1,-1,0,0};

       int max=0;

       for(int i=0;i<totalCols;i++){
           if(grid[0][i] ==1 && visited[0][i] == 0){
               dfs(grid,visited,0,i,xrow,ycol)  ;
           }
           if(grid[totalRows-1][i] ==1 && visited[totalRows-1][i] ==0){
               dfs(grid,visited,totalRows-1,i,xrow,ycol)  ;
           }
       }

        for(int i=0;i<totalRows;i++){
            if(grid[i][0] ==1 && visited[i][0] == 0){
                dfs(grid,visited,i,0,xrow,ycol)  ;
            }
            if(grid[i][totalCols-1] ==1 && visited[i][totalCols-1] ==0){
                dfs(grid,visited,i,totalCols-1,xrow,ycol)  ;
            }
        }

        for(int i=0;i<totalRows;i++){
            for(int j=0;j<totalCols;j++){
                if(visited[i][j] ==0 && grid[i][j] == 1){
                   ++max;
                }
            }
        }

        return max;
    }

    private void dfs(int[][] grid,int[][] visited, int row,int col,int[] xrows,int[] ycols){

        visited[row][col] = 1;
     int totalRows = grid.length;
     int totalCols = grid[0].length;

     for(int i=0;i<4;i++){
         int newRow = row+xrows[i];
         int newCol = col+ycols[i];

         if(newRow >=0 && newRow < totalRows && newCol>=0 && newCol < totalCols &&
                 visited[newRow][newCol] ==0 && grid[newRow][newCol] ==1){

        dfs( grid,visited, newRow,newCol,xrows,ycols);

         }
     }

    }


}
