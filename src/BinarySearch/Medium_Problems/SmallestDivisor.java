package BinarySearch.Medium_Problems;

public class SmallestDivisor {
    public static void main(String[] args) {

         SmallestDivisor s = new SmallestDivisor();
         s.smallestDivisor(new int[]{21212,10101,12121},1000000);
    }

    public int smallestDivisor(int[] nums, int threshold) {

        int high=Integer.MIN_VALUE;
        int low = 1;

        for(int i=0;i< nums.length;i++){

            high = Math.max(nums[i],high);
        }

        int result = Integer.MAX_VALUE;


        while (low<=high){
            int mid = low+(high-low)/2;
             result = sumOfDivisions(nums,mid,threshold);

             if(result > threshold){
                 low = mid+1;
             }else {
                 high = mid-1;
             }
        }
        return low;
    }

    public int sumOfDivisions(int[] nums, int divider,int threshHold){
         int result=0;

         for(int i=0;i< nums.length;i++){
             result = result+ (int)Math.ceil(((double)nums[i])/((double) divider));
         }
         return result;
    }


}
