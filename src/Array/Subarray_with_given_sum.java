package Array;

import java.util.ArrayList;

public class Subarray_with_given_sum {
    public static void main(String[] args) {

        //int[] arr ={1,2,3,4,5,6,7,8,9,10};
        //subarraySum(arr,10,15);
//
//        int[] arr ={135 ,101, 170 ,125 ,79, 159, 163, 65, 106 ,146, 82, 28, 162, 92, 196 ,143, 28, 37, 192, 5, 103, 154, 93, 183, 22 ,117, 119 ,96 ,48, 127 ,172, 139 ,70, 113 ,68 ,100 ,36 ,95 ,104 ,12, 123 ,134};
//        subarraySum(arr,42,468);

//        ArrayList<Integer> arr1 = new ArrayList<Integer>(){
//            {
//                add(100);
//                add(200);
//                add(300);
//                add(400);
//            }
//        };
//
//      long result =   maximumSumSubarray(2,arr1,4);

        ArrayList<Long> arr1 = new ArrayList<Long>(){
            {
                add((long)0);
                add((long)1);
                add((long)2);

            }
        };

        long result =   solve(5,3,arr1);
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

    static long maximumSumSubarray(int K, ArrayList<Integer> Arr,int N){

        long result = 0;

        long maxResult = 0;

        for(int i=0;i<K;i++){
            result = result + Arr.get(i);
        }
        maxResult = result;

        for(int i=K;i < N;i++){
            result = result + Arr.get(i) - Arr.get(i-K);
            if(result > maxResult){
                maxResult = result;
            }
        }
        return maxResult;
    }

    static long solve(int N, int K, ArrayList<Long> GeekNum) {
        long result = 0;
        if(K==1){
            return GeekNum.get(0);
        }

        for(int i=0;i<K;i++){
            result = result + GeekNum.get(i);
        }

        GeekNum.add(result);

        for(int i=K;i<N;i++){
            result =result +  result - GeekNum.get(i-K);
            GeekNum.add(result);
            if(GeekNum.size() == N){
                break;
            }
        }
        return GeekNum.get(N-1);
    }
}
