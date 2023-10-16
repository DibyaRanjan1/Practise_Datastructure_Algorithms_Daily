package LeetCode_Top_150.Matrix;

import java.util.ArrayList;
import java.util.List;

public class Set_Matrix_Zeroes {
    public static void main(String[] args) {
       Set_Matrix_Zeroes set =new Set_Matrix_Zeroes();
       int[][] array = {{1,1,1},{1,0,1},{1,1,1}};
       set.setZeroes(array);
    }

    public void setZeroes(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        boolean isCol =false;

        for(int i=0;i<rows;i++){

            if(matrix[i][0]==0){
                isCol = true;
            }

            for(int j=1;j<cols;j++){

                if(matrix[i][j]==0){
                    matrix[0][j] =0;
                    matrix[i][0] =0;
                }
            }
        }

        for(int i=1;i<rows;i++){
            for(int j=1;j<cols;j++ ){

                if(matrix[i][0]==0 || matrix[0][j]==0){
                    matrix[i][j]=0;
                }
            }
        }

        if (matrix[0][0] == 0) {
            for (int j = 0; j < cols; j++) {
                matrix[0][j] = 0;
            }
        }

        // See if the first column needs to be set to zero as well
        if (isCol) {
            for (int i = 0; i < rows; i++) {
                matrix[i][0] = 0;
            }
        }


    }
}
