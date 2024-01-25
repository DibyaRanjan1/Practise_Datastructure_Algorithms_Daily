package LeetCode_Top_150.Graph;

import java.util.ArrayList;
import java.util.List;

public class SurroundedRegions {

    class Pair<U,V>{
      public U first;
      public V second;

      public Pair(U first, V second){
         this.first = first;
         this.second = second;
      }
    }
    public static void main(String[] args) {

    }

    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        List<Pair<Integer,Integer>> boarders = new ArrayList<>();
        for(int i=0;i<rows;i++){
            boarders.add(new Pair<>(i,0));
            boarders.add(new Pair<>(i,cols-1));
        }

        for(int i=0;i<cols;i++){
            boarders.add(new Pair<>(0,i));
            boarders.add(new Pair<>(rows-1,i));
        }

        for(Pair<Integer,Integer> boarder:boarders){
            dfs(boarder.first,boarder.second,rows,cols,board);
        }

        for(int row=0;row<rows;row++){
            for(int col=0;col<cols;col++){
                if(board[row][col]=='E'){
                    board[row][col] = 'O';
                } else if (board[row][col] == 'O') {
                    board[row][col] = 'X';
                }
            }
        }
    }

    private void dfs(int row, int col, int rows, int cols,char[][] board){
        if(board[row][col] !='O') return;

        board[row][col] ='E';
        int[] xCordinate = new int[]{1,0,-1,0};
        int[] yCordinate = new int[]{0,1,0,-1};

        for(int i=0;i<4;i++){
            int newRow = row+xCordinate[i];
            int newCol = col+yCordinate[i];

            if(newRow <0 || newRow >= rows || newCol <0 || newCol >=cols || board[newRow][newCol] !='O') continue;


            dfs(newRow,newCol,rows,cols,board);
        }
    }
}
