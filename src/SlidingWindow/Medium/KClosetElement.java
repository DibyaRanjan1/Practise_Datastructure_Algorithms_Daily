package SlidingWindow.Medium;

import java.util.ArrayList;
import java.util.List;

public class KClosetElement {
    public static void main(String[] args) {

    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        int left=0;
        int right=arr.length-k;

        List<Integer> result = new ArrayList<>();

        while (left < right){
            int mid = (left+right)/2;
            if(x-arr[mid] > arr[mid+k]-x){
                left =mid+1;
            }else {
                right =mid;
            }
        }

        for(int i=left;i<left+k;i++){
            result.add(arr[i]);
        }
        return result;
    }
}
