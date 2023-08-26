package Sorting;

import java.util.ArrayList;

public class MergeSort {
    public static void main(String[] args) {
          MergeSort m= new MergeSort();
          int[] result = new int[]{5,1,2,8,3,3,5,9,4};

          m.mergeSort(result);
    }

    public void mergeSort(int[] array){
         sort(array,0, array.length-1);
    }

    private void sort(int[] array, int startIndex,int endIndex){

        if(startIndex>=endIndex) return;

        int mid = (startIndex+endIndex)/2;
        sort(array,startIndex,mid);
        sort(array,mid+1,endIndex);
        merge(array,startIndex,mid,endIndex);
    }

    private void merge(int[] array, int low, int mid, int high){
        ArrayList<Integer> lst = new ArrayList<>();

        int left = low;
        int right = mid+1;

        while (left<=mid && right<=high){
            if(array[left] <= array[right]){
                lst.add(array[left++]);
            }else {
                lst.add(array[right++]);
            }
        }

        while (left<=mid){
            lst.add(array[left++]);
        }
        while (right<=high){
            lst.add(array[right++]);
        }

        for (int i = low;i<=high;i++){
            array[i] = lst.get(i-low);
        }
    }
}
