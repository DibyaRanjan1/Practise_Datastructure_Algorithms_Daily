package Array.medium;

public class Max_SubArray {
    public static void main(String[] args) {
      Max_SubArray m = new Max_SubArray();
      m.maxSubArray1(new int[]{-2,-3,4,-1,-2,1,5,-3});
    }

    public int maxSubArray(int[] nums) {
     int sum=0;
     int maxSum=nums[0];
     for(int i=0;i< nums.length;i++){
         sum = sum+ nums[i];
         if(sum > maxSum){
             maxSum = sum;
         }

         if(sum <0){
             sum = 0;
         }
     }
     return maxSum;
    }

    public int[] maxSubArray1(int[] nums){
        int sum=0;
        int subArrayStart=-1;
        int subArrayEnd=-1;
        int max=Integer.MIN_VALUE;

        int tempIndex = 0;

        for (int i=0;i< nums.length;i++){

            sum = sum+nums[i];

            if(sum > max){
                subArrayEnd = i;
                subArrayStart = tempIndex;
                max = sum;
            }
            if(sum<0){
                tempIndex = i+1;
                sum = 0;
            }
        }
return new int[] {subArrayStart,subArrayEnd};
    }
}
