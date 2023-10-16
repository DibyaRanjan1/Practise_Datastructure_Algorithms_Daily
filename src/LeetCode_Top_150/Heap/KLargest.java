package LeetCode_Top_150.Heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Random;

public class KLargest {
    public static void main(String[] args) {
        KLargest k = new KLargest();
       int result = k.findKthLargest_Inplace(new int[]{3,2,3,1,2,4,5,5,6},4);
    }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int it:nums){
            pq.add(it);
            if(pq.size()>k){
                pq.remove();
            }
        }
        return pq.peek();
    }
    
    public int findKthLargest_Optimize(int[] nums,int k){
        ArrayList<Integer> numsLst = new ArrayList<>();
        for(int num:nums){
            numsLst.add(num);
        }
        return quickSort(numsLst,k);
    }
    
    private int quickSort(ArrayList<Integer> nums,int k){
        
        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> mid = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();
        
        int pivot = new Random().nextInt(nums.size());
        int pivotNum = nums.get(pivot);
        
        for(int i=0;i<nums.size();i++){
            int currentNum = nums.get(i);

            if(currentNum > pivotNum){
                left.add(currentNum);
            } else if (currentNum<pivotNum) {
                right.add(currentNum);
            }else {
                mid.add(currentNum);
            }
        }
        
        if(k <= left.size()){
           return quickSort(left,k);
        } else if (left.size() + mid.size() <k) {

           return quickSort(right,k-left.size()-mid.size());
        }
        return pivotNum;
    }

    public int findKthLargest_Inplace(int[] nums,int k){
     return quickSelect(nums,0,nums.length-1,k);
    }

    private void swap(int[] nums,int low,int high){
        int temp = nums[low];
        nums[low] = nums[high];
        nums[high] = temp;
    }

    private int quickSelect(int[] nums,int low,int high,int k){
       int pivot =low;

       for(int i=low;i<high;i++){
           if(nums[i] <= nums[high]){
               swap(nums,pivot,i);
               ++pivot;
           }
       }

       swap(nums,pivot,high);

       int count = high-pivot+1;
       if(count==k) return nums[pivot];
       if(count>k) return quickSelect(nums,pivot+1,high,k);
       return quickSelect(nums,low,pivot-1,k-count);
    }
}
