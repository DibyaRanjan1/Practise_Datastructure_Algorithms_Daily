package BackTracking;

import java.util.Arrays;

public class WordSearch {
    private char[][] board;
    private int ROWS;
    private int COLS;
    public static void main(String[] args) {
       WordSearch w = new WordSearch();

      char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};

       w.exist(board,"ABCCED");
    }

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.ROWS = board.length;
        this.COLS = board[0].length;

        for (int row = 0; row < this.ROWS; ++row)
            for (int col = 0; col < this.COLS; ++col)
                if (this.backtrack(row, col, word, 0))
                    return true;
        return false;

    }

    private boolean backtrack( int row,int col, String word,int index){

        if (index >= word.length())
            return true;

        if (row < 0 || row == this.ROWS || col < 0 || col == this.COLS
                || this.board[row][col] != word.charAt(index))
            return false;

        this.board[row][col] = '#';

        int[] rowOffsets = {0, 1, 0, -1};
        int[] colOffsets = {1, 0, -1, 0};
        for (int d = 0; d < 4; ++d) {
            if (this.backtrack(row + rowOffsets[d], col + colOffsets[d], word, index + 1))
                // return without cleanup
                return true;
        }

        /* Step 4). clean up and return the result. */
        this.board[row][col] = word.charAt(index);
        return false;
    }
}
