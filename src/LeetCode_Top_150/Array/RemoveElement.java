package LeetCode_Top_150.Array;

import java.util.ArrayList;
import java.util.HashSet;

public class RemoveElement {
    public static void main(String[] args) {
        RemoveElement removeElement = new RemoveElement();
        removeElement.removeElementOptimize(new int[]{0,1,2,2,3,0,4,2},2);
    }

    public int removeElement(int[] nums, int val) {

        ArrayList<Integer> result = new ArrayList<>();

        for(int i=0;i< nums.length;i++){
            if(nums[i] !=val){
                result.add(nums[i]);
            }
        }

       for(int i=0;i<result.size();i++){
           nums[i] = result.get(i);
       }
        return result.size();
    }

    public int removeElementOptimize(int[] nums, int val) {
        int i=0;
        int n = nums.length;

        while (i<n){
            if(nums[i]==val){
                nums[i] = nums[n-1];
                --n;
            }else {
                i++;
            }
        }
        return n;
    }

}
