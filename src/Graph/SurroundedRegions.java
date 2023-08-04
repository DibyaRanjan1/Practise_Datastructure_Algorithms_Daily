package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegions {
    public static void main(String[] args) {
        char mat[][] = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'O', 'X', 'X'},
                {'X', 'X', 'O', 'O'}};
        SurroundedRegions ss = new SurroundedRegions();

        ss.solve(mat);

        System.out.println(mat);
    }

    public void solve(char[][] board) {

        if(board ==null) return;

      int rows = board.length;
      int cols = board[0].length;

      int[][] visited = new int[rows][cols];

      int[] rowx = {0,0,1,-1};
      int[] coly = {1,-1,0,0};

      for(int i=0;i<cols;i++){

          if(visited[0][i] !=1 && board[0][i] == 'O'){
              dfs(board,0,i,visited,rowx,coly);
          }

          if(visited[rows-1][i] !=1 && board[rows-1][i] =='O'){
              dfs(board,rows-1,i,visited,rowx,coly);
          }
      }

      for(int i=0;i<rows;i++){
          if(visited[i][0] !=1 && board[i][0] == 'O'){
             dfs(board,i,0,visited,rowx,coly);
          }
          if(visited[i][rows-1] !=1 && board[i][rows-1] =='O'){
              dfs(board,i,rows-1,visited,rowx,coly);
          }
      }

      for(int i=0;i<rows;i++){
          for(int j=0;j<cols;j++){
              if(visited[i][j] == 0 && board[i][j] == 'O'){
                  board[i][j] = 'X';
              }
          }
      }
    }

    public void dfs(char[][] board,int row,int col,int[][] visited,int[] rows,int[] cols){
       visited[row][col] = 1;
       int rowLength = board.length;
       int colLength = board[0].length;

      for(int i=0;i<4;i++){
          int newRow = row+rows[i];
          int newCol = col+ cols[i];

          if(newRow>=0 && newRow < rowLength && newCol >=0 && newCol < colLength && visited[newRow][newCol]==0 && board[newRow][newCol] == 'O'){
              dfs(board,newRow,newCol,visited,rows,cols);
          }

      }
    }
}
