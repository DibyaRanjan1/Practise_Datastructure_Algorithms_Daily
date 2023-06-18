package Array;

import java.util.ArrayList;

public class Subarray_with_given_sum {
    public static void main(String[] args) {

        //int[] arr ={1,2,3,4,5,6,7,8,9,10};
        //subarraySum(arr,10,15);

        int[] arr ={135 ,101, 170 ,125 ,79, 159, 163, 65, 106 ,146, 82, 28, 162, 92, 196 ,143, 28, 37, 192, 5, 103, 154, 93, 183, 22 ,117, 119 ,96 ,48, 127 ,172, 139 ,70, 113 ,68 ,100 ,36 ,95 ,104 ,12, 123 ,134};
        subarraySum(arr,42,468);
    }

    static ArrayList<Integer> subarraySum(int[] arr, int n, int s)
    {
        // Your code here
        int currentSum = 0;
        int start = 0;
        int end = 0;
        boolean flag = false;


        ArrayList<Integer> result = new ArrayList<>();


      for(int i=0;i< n;i++){
          
          currentSum = currentSum + arr[i];
          
          if(currentSum >= s){
              end = i;
              while (currentSum > s && start < end){
                  currentSum =  currentSum - arr[start];
                  start ++;
              }

              if(currentSum ==s){
                  result.add(start+1);
                  result.add(end+1);
                  return result;
              }
          }
      }
        result.add(-1);
        return result;
    }
}
