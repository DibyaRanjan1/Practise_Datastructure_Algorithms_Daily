package BinarySearch.Medium_Problems;

public class Search_Rotated_Array {
    public static void main(String[] args) {

    }

    public int search(int[] nums, int target) {

        int low =0;
        int high= nums.length -1;
        int result = -1;

        while (low<=high){
            int mid= low+ (high-low)/2;

            if(nums[mid]==target){
                return mid;
            }
            if (nums[low] <= nums[mid]) {
                if(nums[low]<=target && nums[mid]>=target){
                    high = mid-1;
                }else {
                    low = mid+1;
                }
            }
            else {
                if(nums[mid] <= target && nums[high] >= target){
                    low = mid+1;
                }else {
                    high = mid-1;
                }
            }
        }
        return result;

    }

    public boolean searchWithDuplicate(int[] nums, int target) {

        int low =0;
        int high= nums.length -1;

        while (low<=high){
            int mid= low+ (high-low)/2;

            if(nums[mid]==target){
                return true;
            }
            if(nums[low]==nums[mid] && nums[mid]==nums[high]){
                low = low+1;
                high = high-1;
                continue;
            }
            if (nums[low] <= nums[mid]) {
                if(nums[low]<=target && nums[mid]>=target){
                    high = mid-1;
                }else {
                    low = mid+1;
                }
            }
            else {
                if(nums[mid] <= target && nums[high] >= target){
                    low = mid+1;
                }else {
                    high = mid-1;
                }
            }
        }
        return false;

    }
}
