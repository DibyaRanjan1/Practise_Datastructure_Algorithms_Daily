package BinarySearch.Matrix;

public class Matrix_Median {
    public static void main(String[] args) {


    }
    public int findMedian(int[][] A) {
        int rowLength = A.length;
        int colLength = A[0].length;

        int low=1;
        int high = (int)Math.pow(9,10);

        int matrixMedian = (rowLength*colLength)/2;

        while (low<=high){

            int mid = low+(high-low)/2;
            int count=0;
            for(int i=0; i<rowLength;i++){
                count += findNumberofValuesLessThanMid(A,i,mid);
            }

            if(count > matrixMedian){
                high = mid-1;
            }else {
                low = mid+1;
            }
        }

return low;
    }

    public int findNumberofValuesLessThanMid(int[][] A,int row, int midComparer){
        int low = 0;
        int high = A[row].length-1;

        while (low<=high){
            int mid = low+(high-low)/2;

            if(A[row][mid]<=midComparer){
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return low;
    }
}
