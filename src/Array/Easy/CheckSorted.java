package Array.Easy;

import java.util.ArrayList;
import java.util.List;

public class CheckSorted {
    public static void main(String[] args) {
           CheckSorted c = new CheckSorted();
           //c.removeDuplicate(new int[]{0,0,1,1,1,2,2,3,3,4});
        //c.leftRotateBy1(new int[]{1,2,3,4,5},1);

        //c.leftRotate(new int[]{1,2,3,4,5,6,7},3);

        int[] array1 = new int[]{1,1,2,3,3,4,5};
        int[] array2 = new int[]{2,3,3,5,5,6,7};
        //c.findUnion(array1,array2);
        //c.interSection(array1,array2);
     int result =   c.missingNumber(new int[]{1,2,4,5});
    }

    public int largest(int[] nums) {
      int largest = nums[0];

      for(int i=1;i<nums.length;i++){
          if(largest< nums[i]){
              largest = nums[i];
          }
      }
      return largest;
    }

    public static int secondLargest(int[] nums){
        if(nums.length==1) return -1;

        int largest = nums[0];
        int secondLargest = -1;

        for (int i=1;i< nums.length;i++){
            if(largest<nums[i]){
                secondLargest = largest;
                largest = nums[i];
            }else {
                if(nums[i]>secondLargest && nums[i]<largest){
                    secondLargest = nums[i];
                }
            }

        }
        return secondLargest;
    }

    public static int secondSmallest(int[] nums){
        if(nums.length==1) return -1;

        int smallest = nums[0];
        int secondSmallest = Integer.MAX_VALUE;

        for (int i=1;i< nums.length;i++){
            if(smallest>nums[i]){
                secondSmallest = smallest;
                smallest = nums[i];
            }else {
                if(nums[i]<secondSmallest && nums[i]>smallest){
                    secondSmallest = nums[i];
                }
            }
        }
        return secondSmallest;
    }

    public boolean checkSorted(int[] array){

        if(array.length ==1) return true;

        boolean result = true;

        for(int i=0;i<array.length-1;i++){
            if(array[i]>array[i+1]){
                return false;
            }
        }
        return true;
    }

    public int removeDuplicate(int[] array){

        int first=0;

        if(array.length==1) return 1;

        for (int i=1;i<array.length;i++){

            if(array[i]!=array[first]){
                array[++first] = array[i];
            }
        }

        return first+1;
    }

    public void leftRotateBy1(int[] array, int rotate){

        int i=0;

        int first = array[0];
        for(i=rotate;i<array.length;i++){

            array[rotate-1] = array[rotate];
        }

        array[array.length-1] = first;
    }

    public void leftRotate(int[] array,int k){
        k = k%array.length;

        int arrayLength = array.length;

        ArrayList<Integer> temp = new ArrayList<>();

        for(int i=0; i<k;i++){
            temp.add(array[i]);
        }

        for(int i=k;i<arrayLength;i++){
            array[i-k] = array[i];
        }

        for(int i = arrayLength-k;i<arrayLength;i++){
            array[i] = temp.get(i-(arrayLength-k));
        }
    }


    // optimal way
    public void rightRotate(int[] array, int k) {
        k = k%array.length;
        reverse(0,array.length-k-1,array);
        reverse(array.length-k,array.length-1,array);
        reverse(0,array.length-1,array);
    }

    private void reverse(int startIndex, int endIndex,int[] array){

        while (startIndex<endIndex){
            int temp = array[startIndex];
            array[startIndex] = array[endIndex];
            array[endIndex] = temp;
            ++startIndex;
            --endIndex;
        }
    }

    // my approach
    public void moveZeroes(int[] nums) {

        for(int i=0;i<nums.length;i++){
           int secondIndex = i;
             while (secondIndex < nums.length && nums[secondIndex]==0){
                 secondIndex++;
             }
             if(secondIndex == nums.length){
                 break;
             }
             if(nums[i] == 0 && nums[secondIndex]!=0){
                 nums[i] = nums[secondIndex];
                 nums[secondIndex]  =0;
             }
        }

    }

    public void movezeroOptimal(int[] nums){
        int j=-1;

        for(int i=0;i< nums.length;i++){
            if(nums[i]==0){
                j = i;
                break;
            }
        }

        if(j==-1) return;

        for(int i=j+1;i< nums.length;i++){
            if(nums[i]!=0){
                nums[j] = nums[i];
                nums[i] = 0;
                j++;
            }
        }
    }

    public List<Integer> findUnion(int[] array1,int[] array2){
        int length1 = array1.length;
        int length2 = array2.length;

        List<Integer> arrayList = new ArrayList<>();

        int first=0;
        int second=0;

        while (first <length1 && second<length2){

            if(array1[first]<array2[second]){
                if(arrayList.isEmpty() || arrayList.get(arrayList.size()-1)!=array1[first]){
                    arrayList.add(array1[first++]);
                }else {
                    first++;
                }

            }else {
                if(arrayList.isEmpty() || arrayList.get(arrayList.size()-1)!=array2[second]){
                    arrayList.add(array2[second++]);
                }else {
                    second++;
                }
            }
        }

        while (first<length1){
            if(arrayList.get(arrayList.size()-1)!=array1[first]){
                arrayList.add(array1[first++]);
            }else {
                first++;
            }
        }

        while (second<length2){
            if(arrayList.get(arrayList.size()-1)!=array2[second]){
                arrayList.add(array2[second++]);
            }else {
                second++;
            }
        }

     return arrayList;

    }

    public List<Integer> interSection(int[] array1, int[] array2){
      List<Integer> result = new ArrayList<>();

      int first=0;
      int second=0;

      while (first<array1.length && second < array2.length){

          if(array1[first] == array2[second]){
              result.add(array1[first]);
              ++first;
              ++second;
          } else if (array1[first] < array2[second]) {
              ++first;
          }else {
              ++second;
          }

      }
      return result;
    }

    public int missingNumber(int[] nums) {
    int xor1 = 0;
    int xor2=0;
    int N = nums[nums.length-1];
    int n= N-1;

    for(int i=0;i<n;i++){
      xor2 = xor2 ^ nums[i];
      xor1 = xor1 ^ (i+1);
    }

    xor1 = xor1^(N);

    return xor1^xor2;

    }

    public int missingNumber1(int[] nums){

        int length = nums.length;
        int sum=0;
        for(int i=0;i<length;i++){
            sum = sum+nums[i];
        }

        return (length*(length+1)/2) -sum;
    }

    public int findMaxConsecutiveOnes(int[] nums) {

        int count=0;
        int maxCount=0;

        for(int i=0;i<nums.length;i++){

            if(nums[i] == 1){
                ++count;
                maxCount = Math.max(maxCount,count);
            }else {
                count =0;
            }
        }
        return maxCount;
    }

    public int singleNumber(int[] nums) {
    int xor=0;
    for(int i=0;i<nums.length;i++){
        xor = xor^nums[i];
    }
    return xor;
    }
}
