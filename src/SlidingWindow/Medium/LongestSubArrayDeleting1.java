package SlidingWindow.Medium;

public class LongestSubArrayDeleting1 {
    public static void main(String[] args) {

    }

    public int longestSubarray(int[] nums) {
        int leftIndex = 0;
        int rightIndex = 0;
        int result=0;
        int zeroCount=0;

        for (; rightIndex < nums.length; rightIndex++) {

            zeroCount += nums[rightIndex]==0?1:0;
            if(zeroCount >1){
                zeroCount -= nums[leftIndex++]==0?1:0;
            }
            result = Math.max(result,rightIndex-leftIndex);
        }

        return result;

    }
}
