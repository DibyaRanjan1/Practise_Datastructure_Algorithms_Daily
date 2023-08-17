package BinarySearch.Medium_Problems;

public class Kth_Missing {
    public static void main(String[] args) {
     Kth_Missing k = new Kth_Missing();
     k.findKthPositive(new int[]{1,2,3,4},2);
    }

    public int findKthPositive(int[] arr, int k) {
        int low = 0;
        int high = arr.length-1;

        while (low<=high){

            int mid = low+(high-low)/2;

            int numberOfMissingEle = arr[mid] - (mid+1);

            if(numberOfMissingEle <k){
                low = mid+1;
            }else {
                high = mid-1;
            }
        }
   return k+high+1;
    }
}
