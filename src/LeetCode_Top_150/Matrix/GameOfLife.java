package LeetCode_Top_150.Matrix;

public class GameOfLife {
    public static void main(String[] args) {

        GameOfLife g = new GameOfLife();
        int[][] array = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        g.gameOfLife(array);
    }

    public void gameOfLife(int[][] board) {

        int rows = board.length;
        int cols = board[0].length;

        int[][] output = new int[rows][cols];

        int[][] cordinates = {{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1}};


        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                int numberofNeighbourLiveCells = 0;

                for(int k=0;k<cordinates.length;k++){

                    int newRow = i+cordinates[k][0];
                    int newCol = j+cordinates[k][1];

                    if(newRow >=0 && newRow < rows && newCol >=0 && newCol < cols){
                        if(board[newRow][newCol] == 1){
                            numberofNeighbourLiveCells++;
                        }
                    }
                }

                if(board[i][j]==1){
                    if(numberofNeighbourLiveCells<2 || numberofNeighbourLiveCells>3){
                        output[i][j] = 0;
                    } else {
                        output[i][j] = 1;
                    }
                }else {
                   if(numberofNeighbourLiveCells==3){
                       output[i][j] = 1;
                   }
                }
            }
        }

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                board[i][j] = output[i][j];
            }
        }
    }
}
