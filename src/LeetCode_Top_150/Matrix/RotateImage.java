package LeetCode_Top_150.Matrix;

public class RotateImage {
    public static void main(String[] args) {

    }

    public void rotate(int[][] matrix) {

        int n = matrix.length;

        // Tanspose
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){

                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        //reverse
        for(int i=0;i<n;i++){
            for(int j=0;j<n/2;j++){
                int temp = matrix[i][n-j-1];
                matrix[i][n-j-1] =  matrix[i][j];
                matrix[i][j] = temp;
            }
        }

    }
}
