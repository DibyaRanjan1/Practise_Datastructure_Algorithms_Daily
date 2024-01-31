package Revision.BackTrack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NQueen {
    public static void main(String[] args) {

    }

    int size;
    List<List<String>> result = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {

        size =n;

        char[][] board = new char[n][n];
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                board[i][j] ='.';
            }
        }

        Set<Integer> colSet = new HashSet<>();
        Set<Integer> diagonalSet = new HashSet<>();
        Set<Integer> antidiagonalSet = new HashSet<>();

        backTrack(0,colSet,diagonalSet,antidiagonalSet,board);

return result;
    }


    private void backTrack(int row,Set<Integer> colset, Set<Integer> diagonalSet, Set<Integer> antiDiagonalSet, char[][] board){

        if(row == size){
         result.add(construct(board));
        }

        for(int col=0;col<size;col++){

            int diagonalValue = row+col;
            int antidiagonalValue = row-col;

            if(colset.contains(col) || diagonalSet.contains(diagonalValue) || antiDiagonalSet.contains(antidiagonalValue)) continue;

            colset.add(col);
            diagonalSet.add(diagonalValue);
            antiDiagonalSet.add(antidiagonalValue);
            board[row][col] = 'Q';

            backTrack(row+1,colset,diagonalSet,antiDiagonalSet,board);

            colset.remove(col);
            diagonalSet.remove(diagonalValue);
            antiDiagonalSet.remove(antidiagonalValue);
            board[row][col] ='.';

        }
    }

    private List<String> construct(char[][] board){

        List<String> res = new ArrayList<>();

        for(int i=0;i<board.length;i++){
            res.add(new String(board[i]));
        }
        return res;
    }


}
