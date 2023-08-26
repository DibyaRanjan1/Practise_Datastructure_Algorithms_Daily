package BinarySearch.Medium_Problems;

public class Row_with_max_1s {
    public static void main(String[] args) {


        Row_with_max_1s r  =new Row_with_max_1s();
        int[][] arr=  {
                {0 ,0 ,0 ,1, 1, 1, 1, 1, 1},
                {0 ,0, 0, 0, 1, 1, 1, 1, 1},
                {0 ,0 ,0 ,0 ,1 ,1 ,1 ,1, 1}
        };


        r.rowWithMax1s(arr,3,9);
    }

    int rowWithMax1s(int arr[][], int n, int m) {
        // code here
        int index = -1;
        int totalNumOf1=0;

        for(int i=0;i<n;i++){
            int numberOf1 = findMax1(arr,i,m);
            if(numberOf1 ==0) continue;
            if(totalNumOf1 < numberOf1){
                totalNumOf1 = numberOf1;
                index = i;
            }
        }
        return index;
    }

    int findMax1(int [][] arr, int row,int col){
        int low=0;
        int high = col-1;

        while (low<=high){
            int mid = (low+high)/2;

            if(arr[row][mid] <=0){
                low = mid+1;
            }else {
                high = mid-1;
            }
        }
        return col-low;
    }
}
