package Stack.Montonic_Stack;

import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElement_II {
    public static void main(String[] args) {

    }

    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[nums.length];

        for(int i= nums.length-1;i>= 0;i--){
            stack.push(nums[i]);
        }

        for(int i= nums.length-1; i>=0;i--){
            while (!stack.isEmpty() && stack.peek() <= nums[i]){
                stack.pop();
            }

            result[i] = stack.isEmpty()?-1:stack.peek();
            stack.push(nums[i]);
        }

      return result;
    }

    public int[] nextGreaterElementsII(int[] nums){

        Stack<Integer> stack = new Stack<>();
        int[] result = new int[nums.length];
        int len = nums.length;

        for (int i=2*nums.length-1;i>=0;i--){
            while (!stack.isEmpty() && stack.peek() <= nums[i%len]){
                stack.pop();
            }

            if(i<len){
                if(stack.isEmpty()){
                    result[i] = -1;
                }else {
                    result[i] = stack.peek();
                }
            }

            stack.push(nums[i]);
        }
        return result;
    }
}

