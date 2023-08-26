package BinarySearch.Matrix;

public class FindPeakGrid {
    public static void main(String[] args) {

    }

    public int[] findPeakGrid(int[][] mat) {
       int rowLength = mat.length;
       int colLength = mat[0].length;

       int low =0;
       int high = colLength-1;

       while (low<=high){
           int midCol = low+(high-low)/2;
           int midrow = 0;
           for(int i=0;i<rowLength-1;i++){
               midrow = mat[i][midCol] > mat[midrow][midCol]?i:midrow;
           }

           boolean isLeftBig = ((midCol-1) >=0) && (mat[midrow][midCol-1] > mat[midrow][midCol]);
           boolean isRightBig = ((midCol+1) < colLength) && (mat[midrow][midCol+1] > mat[midrow][midCol]);

           if(!isLeftBig && !isRightBig){
               return new int[]{midrow,midCol};
           } else if (isRightBig) {
               low = midCol+1;
           }else {
               high = midCol-1;
           }
       }
       return null;
    }
}
