package SlidingWindow.Medium;

public class SubArrayProduct {
    public static void main(String[] args) {
        SubArrayProduct subArrayProduct = new SubArrayProduct();
        subArrayProduct.numSubarrayProductLessThanK(new int[]{10,5,2,6},100);
    }

    public int numSubarrayProductLessThanK(int[] nums, int k) {
      int leftIndex=0;
      int rightIndex=0;

      int result =0;
      int currentProductWindow=1;

      for(;rightIndex<nums.length;rightIndex++){

          for(int i=rightIndex;i >=0 && i >=leftIndex;--i){
              currentProductWindow = currentProductWindow * nums[i];
              if(currentProductWindow >= k){
                  leftIndex++;
              }else {
                  result++;
              }
          }
          currentProductWindow=1;
      }
      return result;
    }

    public int numSubarrayProductLessThanK_Optimize(int[] nums, int k) {
        int leftIndex=0;
        int rightIndex=0;

        if(k<=1) return 0;

        int result =0;
        int currentProductWindow=1;

        for(;rightIndex<nums.length;rightIndex++){

            currentProductWindow *= nums[rightIndex];

            while (currentProductWindow >=k){
                currentProductWindow /= nums[leftIndex++];
            }

            result += rightIndex-leftIndex+1;
        }
        return result;
    }


}
