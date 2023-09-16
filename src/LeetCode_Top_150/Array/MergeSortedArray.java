package LeetCode_Top_150.Array;

import java.util.ArrayList;

public class MergeSortedArray {
    public static void main(String[] args) {

    }

    // Using extra space
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        ArrayList<Integer> result = new ArrayList<>();

        if(n==0) return;

        int nums1Index = 0;
        int nums2Index = 0;

         while (nums1Index < m || nums2Index < n){
             if(nums1[nums1Index]< nums2[nums2Index]){
                 if(result.isEmpty() || result.get(result.size()-1)!= nums1[nums1Index]){
                     result.add(nums1[nums1Index]);

                 }
                 nums1Index++;

             }else if(nums2[nums2Index] < nums1[nums1Index]) {
                 if(result.isEmpty() || result.get(result.size()-1)!=nums2[nums2Index]){
                     result.add(nums2[nums2Index]);
                 }
                 nums2Index++;
             }else {
                 nums1Index++;
                 nums2Index++;
             }
         }

         while (nums1Index < m){
             if( result.isEmpty() || result.get(result.size()-1)!= nums1[nums1Index]){
                 result.add(nums1[nums1Index]);
             }
             nums1Index++;
         }

        while (nums2Index < n){
            if(result.isEmpty() || result.get(result.size()-1)!=nums2[nums2Index]){
                result.add(nums2[nums2Index]) ;
            }
            nums2Index++;
        }

        for(int i=0;i<result.size();i++){
            nums1[i] = result.get(i);
        }


    }

    public void mergeOptimize(int[] nums1, int m, int[] nums2, int n){
        int p1 = m-1;
        int p2 = n-1;

        for (int p = m + n - 1; p >= 0; p--) {
            if (p2 < 0) {
                break;
            }
            if (p1 >= 0 && nums1[p1] > nums2[p2]) {
                nums1[p] = nums1[p1--];
            } else {
                nums1[p] = nums2[p2--];
            }
        }
    }
}
