package Stack.Montonic_Stack;

import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElement {
    public static void main(String[] args) {

    }

    // My way
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        Stack<Integer> stack = new Stack<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] result = new int[nums1.length];
        for(int i=nums2.length-1;i>=0;i--){

            while (!stack.isEmpty() && stack.peek() < nums2[i] ){
                stack.pop();
            }

            if(stack.isEmpty()){
                map.put(nums2[i],-1);
            }else {
                int nextGreaterElement = stack.peek();
                map.put(nums2[i],nextGreaterElement);
            }
            stack.push(nums2[i]);
        }

        for(int i=0;i<nums1.length;i++){
            result[i] = map.get(nums1[i]);
        }
        return result;
    }

    // Cool way by leetcode
    public int[] nextGreaterElementOptimal(int[] nums1, int[] nums2) {

        Stack<Integer> stack = new Stack<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] result = new int[nums1.length];

        for(int num: nums2){

            while (!stack.isEmpty() && stack.peek() < num){
                map.put(stack.pop(),num);
            }
            stack.push(num);
        }

        for(int i=0;i<nums1.length;i++){
            result[i] = map.getOrDefault(nums1[i],-1);
        }

        return result;
    }
}
