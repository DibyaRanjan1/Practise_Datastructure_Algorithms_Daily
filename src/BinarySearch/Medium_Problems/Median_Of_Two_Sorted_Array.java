package BinarySearch.Medium_Problems;

import java.util.ArrayList;

public class Median_Of_Two_Sorted_Array {
    public static void main(String[] args) {

    }

    //brute force
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        ArrayList<Integer> num3 = new ArrayList<>();

        int n1=nums1.length;
        int n2=nums2.length;
         int i=0,j=0;

        while (i<n1 && j<n2){
            if(nums1[i] < nums2[j]){
                num3.add(nums1[i++]);
            }else {
                num3.add(nums2[j++]);
            }
        }

        while (i<n1){
            num3.add(nums1[i++]);
        }
        while (j<n2){
            num3.add(nums2[j++]);
        }

        int n = n1+n2;

        if(n%2==1){
            return  (double)num3.get((n1+n2)/2);
        }

       return  ((double)num3.get(n/2)  + (double)num3.get((n/2)-1))/2.0;
    }

    public double findMedian(int[] num1, int[] num2){

        if(num2.length < num1.length){
            return findMedianSortedArrays(num2,num1);
        }

        int n1 = num1.length;
        int n2 = num2.length;;


        int low=0;
        int high=n1;
        int left = (n1+n2+1)/2;
        int n = n1+n2;

        while (low<=high){
            int mid1 = (high+low)/2;
            int mid2 = left - mid1;

            int l1 = Integer.MIN_VALUE;
            int l2 = Integer.MIN_VALUE;

            int r1 = Integer.MAX_VALUE;
            int r2 = Integer.MAX_VALUE;

            if(mid1 < n1){
               r1 = num1[mid1];
            }

            if(mid2 <n2){
                r2 = num2[mid2];
            }

            if(mid1-1 >=0){
                l1 = num1[mid1-1];
            }

            if(mid2-1>=0){
                l2 = num2[mid2-1];
            }

            if(l1<=r2 && l2<=r1){
                if(n%2 ==0) return Math.max(l1,l2);
                return ((double) (Math.max(l1,l2) + Math.min(r1,r2)))/2.0;
            } else if (l1>r2) {
                high = mid1-1;
            }
            else {
                low = mid1+1;
            }


        }
        return 0;
    }
}
