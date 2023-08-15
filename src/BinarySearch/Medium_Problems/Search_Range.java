package BinarySearch.Medium_Problems;

import java.awt.event.HierarchyBoundsAdapter;

public class Search_Range {
    public static void main(String[] args) {
        Search_Range s = new Search_Range();
        int[] input= new int[]{5,7,7,8,8,10};
        s.searchRange(input,8);
    }

    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1,-1};

        if(nums ==null) return result;
        if(nums.length ==0) return result;

          result[0] = this.searchRangeFirst(nums,target);
          result[1] = this.searchRangeSecond(nums,target);
          return result;
    }

    public int searchRangeFirst(int[] nums, int taregt){
        int low =0;
        int high = nums.length-1;
        int first = -1;

        while (low<=high){
            int mid = low+ (high-low)/2;

            if(nums[mid] < taregt){
                low =mid+1;
            }else if (nums[mid] >= taregt){
                first = mid;
               high = mid-1;
            }
        }
        return first;
    }

    public int searchRangeSecond(int[] nums, int taregt){
        int low =0;
        int high = nums.length-1;
        int second = -1;

        while (low<=high){
            int mid = low+ (high-low)/2;

            if(nums[mid] <= taregt){
                if(nums[mid]==taregt){
                    second = mid;
                }
               low = mid+1;
            }else if (nums[mid] > taregt){
                high = mid-1;
            }
        }
        return second;
    }


}
