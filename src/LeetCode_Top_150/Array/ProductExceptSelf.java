package LeetCode_Top_150.Array;

public class ProductExceptSelf {
    public static void main(String[] args) {
        ProductExceptSelf p = new ProductExceptSelf();
        p.productExceptSelf(new int[]{1,2,3,4});
    }

    public int[] productExceptSelf(int[] nums) {


        int[] result = new int[nums.length];
        int postFix = 1;
        result[0] = 1;
        for(int i=1;i< nums.length;i++){
            result[i] = result[i-1] * nums[i-1];
        }
        result[nums.length-1] = result[nums.length-1]*postFix;
        for(int i= nums.length-2;i>=0;i--){
            postFix = postFix * nums[i+1];
            result[i] = result[i]*postFix;
        }
        return result;
    }
}
