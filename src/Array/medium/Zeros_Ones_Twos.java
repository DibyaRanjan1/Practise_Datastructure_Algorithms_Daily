package Array.medium;

import java.security.KeyPair;
import java.util.HashMap;
import java.util.Map;

public class Zeros_Ones_Twos {
    public static void main(String[] args) {
     Zeros_Ones_Twos z = new Zeros_Ones_Twos();
     z.majorityElement(new int[]{3,0,3});
    }

    public void sortColors(int[] nums) {
      int start=0;
      int mid = 0;
      int end = nums.length -1;

      while (mid <end){

          if(nums[mid] ==2){
              swap(nums,mid,end);
              --end;
          }else if (nums[mid] ==1){
              ++mid;
          }else {
              swap(nums,mid,start);
              ++start;
          }
      }
    }

    public void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public int majorityElement(int[] nums) {
       int len = nums.length/2;
        HashMap<Integer,Integer> map = new HashMap<>();
       for(int i=0;i< nums.length;i++){
           if(map.containsKey(nums[i])){
               map.put(nums[i],map.get(nums[i])+1);
           }else {
               map.put(nums[i],1);
           }
       }

       for (Map.Entry<Integer,Integer> itr: map.entrySet()){
           if(itr.getValue() >len){
               return itr.getKey();
           }
       }
       return -1;
    }

    public int majorityElementOptimal(int[] nums){

        int ele = -1;
        int count =0;

        for(int i=0;i< nums.length;i++){
            if(count==0){
                ele = nums[i];
            }
            if(ele == nums[i]){
                ++count;
            }else {
                --count;
            }
        }
return ele;

    }
}
