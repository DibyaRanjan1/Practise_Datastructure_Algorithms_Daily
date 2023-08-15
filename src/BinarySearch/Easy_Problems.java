package BinarySearch;

public class Easy_Problems {
    public static void main(String[] args) {
       Easy_Problems e = new Easy_Problems();

       int[] input = {10,20,30,40,50};
      int res1 = e.find_Floor(input,31);
      int res2 = e.find_Ceil(input,31);
       //e.getLowerBound(input,19);
        //e.getUperBound(input,15);
    }

    public int search(int[] nums, int target) {

        int low = 0;
        int high = nums.length-1;
        int mid = low + (high-low)/2;

        while (low<=high){
            if(nums[mid]==target){
                return mid;
            } else if (nums[mid] > target) {
                high = mid-1;
            }else {
                low = mid+1;
            }
        }
        return -1;
    }

    public int getLowerBound(int[] nums, int target){
        int low = 0;
        int high = nums.length-1;
        int result = nums.length;

        while (low<=high){
            int mid = low+ (high-low)/2;

          if (nums[mid] >= target) {
                result = mid;
                high = mid-1;
            }
            else {
                low = mid+1;
            }
        }
        return result;
    }

    public int getUperBound(int[] nums,int target){
        int low = 0;
        int high = nums.length-1;
        int result = nums.length;

        while (low<=high){
            int mid = low+ (high-low)/2;

            if(nums[mid] > target){
                result = mid;
                high = mid-1;
            }else {
                low = mid+1;
            }
        }
        return result;
    }

    public int searchInsert(int[] nums,int target){
        int low =0;
        int high = nums.length-1;
        int result = nums.length;

        while (low<=high){

            int mid = low + (high-low)/2;
            if(nums[mid]==target){
                return mid;
            }else if (nums[mid] > target){
                result = mid;
                high=mid-1;
            }else {
                low = mid+1;
            }
        }
        return result;

    }
    // time complexity n/2
    public int singleNonDuplicate(int[] nums) {

        int low =0;
        int high = nums.length -1;

        while (low<=high){

            if(nums[low]!=nums[++low]){
                return nums[--low];
            } else if (nums[high] !=nums[--high]) {
                return nums[++high];
            }else {
                ++low;
                --high;
            }
        }
        return -1;
    }

    public int singleNonDuplicateOptimized(int[] nums){

        if(nums.length==1) return nums[0];

        if(nums[0]!=nums[1]) return nums[0];
        if (nums[nums.length-1]!=nums[nums.length-2]) return nums[nums.length-1];

        int low = 1;
        int high = nums.length-2;

        while (low<=high){

            int mid = (high+low)/2;

            if(nums[mid] !=nums[mid-1] && nums[mid]!=nums[mid+1]){
                return nums[mid];
            }

            if((mid%2 == 0 && nums[mid-1] == nums[mid]) || (mid%2 !=0 && nums[mid+1] ==nums[mid] )){
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
       return -1;

    }

    public int find_Floor(int[] nums, int key){

        int low = 0;
        int high = nums.length-1;
        int floor = Integer.MIN_VALUE;

        while (low<=high){
            int mid = low+ (high-low)/2;

            if(nums[mid] > key){
                high = mid-1;
            }else if(nums[mid] < key) {
                floor = nums[mid];
                low = mid+1;
            }else {
                return nums[mid];
            }
        }
        return floor;
    }

    public int find_Ceil(int[] nums, int key){

        int low = 0;
        int high = nums.length-1;
        int ceil = Integer.MAX_VALUE;

        while (low<=high){
            int mid = low+ (high-low)/2;

            if(nums[mid] > key){
                    ceil = nums[mid];
                high = mid-1;
            }else if(nums[mid] < key) {
                low = mid+1;
            }else {
                return key;
            }
        }
        return ceil;
    }

}
