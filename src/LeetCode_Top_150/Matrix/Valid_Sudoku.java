package LeetCode_Top_150.Matrix;

public class Valid_Sudoku {
    public static void main(String[] args) {
          Valid_Sudoku v = new Valid_Sudoku();
     char[][] input = new char[][]{
             {'8','3','.','.','7','.','.','.','.'}
,{'6','.','.','1','9','5','.','.','.'}
,{'.','9','8','.','.','.','.','6','.'}
,{'8','.','.','.','6','.','.','.','3'}
,{'4','.','.','8','.','3','.','.','1'}
,{'7','.','.','.','2','.','.','.','6'}
,{'.','6','.','.','.','.','2','8','.'}
,{'.','.','.','4','1','9','.','.','5'}
,{'.','.','.','.','8','.','.','7','9'}};
     v.isValidSudoku(input);

    }

    public boolean isValidSudoku(char[][] board) {
        int N=9;

        char[][] rows = new char[N][N];
        char[][] cols = new char[N][N];
        char[][] boxes = new char[N][N];

        for(int row=0;row<N;row++){
            for(int col=0;col<N;col++){

                if(board[row][col] == '.'){
                    continue;
                }
                int val = board[row][col] - '1';

                if(rows[row][val] == 1){
                    return false;
                }

                rows[row][val] =1;

                if(cols[col][val]==1){
                    return false;
                }

                cols[col][val] =1;

                int idx = (row/3)*3+(col/3);

                if(boxes[idx][val]==1){
                    return false;
                }

                boxes[idx][val]=1;
            }
        }
return true;
    }
}
