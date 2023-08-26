package BinarySearch.Medium_Problems;

public class Search_In_Matrix_II {
    public static void main(String[] args) {

    }

    public boolean searchMatrix(int[][] matrix, int target) {
        
        int rows = matrix.length;
        int cols = matrix[0].length;

        int low = 0;
        int high = cols-1;
        
        while (low < rows && high >=0){
            
            if(matrix[low][high]==target){
                return true;
            } else if (matrix[low][high] > target) {
                --high;
            }else {
                ++low;
            }
        }
        return false;
    }
}
