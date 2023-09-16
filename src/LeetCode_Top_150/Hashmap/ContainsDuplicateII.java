package LeetCode_Top_150.Hashmap;

import java.util.HashMap;

public class ContainsDuplicateII {
    public static void main(String[] args) {

    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0;i< nums.length;i++){

            if(!map.containsKey(nums[i])){
                map.put(nums[i],i);
            }else {
                int startIndex = map.get(nums[i]);
                if(Math.abs(i-startIndex) <=k){
                    return true;
                }
                map.put(nums[i],i);
            }
        }
        return false;
    }

    public boolean containsNearbyDuplicate1(int[] nums, int k) {

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0;i< nums.length;i++){

            if(!map.containsKey(nums[i])){
                map.put(nums[i],i);
            }else {
                int startIndex = map.get(nums[i]);
                if(Math.abs(i-startIndex) <=k){
                    return true;
                }
                map.put(nums[i],i);
            }
        }
        return false;
    }
}
