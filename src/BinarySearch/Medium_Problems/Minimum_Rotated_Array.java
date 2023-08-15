package BinarySearch.Medium_Problems;

public class Minimum_Rotated_Array {
    public static void main(String[] args) {

    }

    public int findMin(int[] nums){

        if(nums.length==1) return nums[0];

        int low =0;
        int high= nums.length-1;
        int  min = Integer.MAX_VALUE;

        while (low<=high){
            int mid = low+ (high-low)/2;

            if(nums[low]<=nums[high]){
                min = Math.min(min,nums[low]);
                break;
            }

              if(nums[low] <=nums[mid]){
                  min = Math.min(min,nums[low])  ;
                  low = mid+1;
              }else {
                      min = Math.min(min,nums[mid]);
                      high= mid-1;
              }
        }
        return min;
    }
}
