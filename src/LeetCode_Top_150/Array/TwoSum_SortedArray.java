package LeetCode_Top_150.Array;

public class TwoSum_SortedArray {
    public static void main(String[] args) {

    }

    public int[] twoSum(int[] numbers, int target) {
        int start=0;
        int end = numbers.length-1;
        int sum=0;

        while (start<end){
            sum=numbers[start]+numbers[end];

            if(sum == target){
                return new int[]{start+1,end+1};
            } else if (sum > target) {
                --end;
            }else {
                ++start;
            }

        }
        return new int[]{-1,-1};
    }
}
