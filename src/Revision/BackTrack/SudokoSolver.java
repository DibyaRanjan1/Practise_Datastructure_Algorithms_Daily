package Revision.BackTrack;

public class SudokoSolver {
    public static void main(String[] args) {

    }

    public void solveSudoku(char[][] board) {
        backTrack_Solve(board);

    }

    private boolean backTrack_Solve(char[][] board){

        for(int row=0;row<board.length;row++){
            for(int col=0;col<board[0].length;col++){

                if(board[row][col] == '.'){

                  for(char ch='1';ch<'9';ch++){
                      board[row][col] = ch;
                     if(isValid(board,row,col,ch)){
                         if(backTrack_Solve(board)) return true;
                         else   board[row][col] = '.';
                     }
                     else {
                        return false;
                     }
                  }
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char val){

        for(int i=0;i<9;i++){
            if(board[row][i] == val) return false;
            if(board[i][col] ==  val) return false;
            if(board[row+ i/3][col + i%3] == val) return false;
        }
        return true;
    }
}
