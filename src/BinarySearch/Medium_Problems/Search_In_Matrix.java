package BinarySearch.Medium_Problems;

public class Search_In_Matrix {
    public static void main(String[] args) {

    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int low =0;
        int high = (rows*cols)-1;

        while (low<=high){
           int mid = (low+high)/2;

           int row = mid/cols;
           int col = mid%cols;

           if(matrix[row][col] == target){
               return true;
           } else if (matrix[row][col] < target) {
               high = mid-1;
           }else {
               low = mid+1;
           }

        }
        return false;
    }
}
