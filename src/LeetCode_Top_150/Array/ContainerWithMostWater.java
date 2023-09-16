package LeetCode_Top_150.Array;

public class ContainerWithMostWater {
    public static void main(String[] args) {

    }

    public int maxArea(int[] height) {
     int start=0;
     int end = height.length-1;
     int sum=0;
     while (start<end){

       int minHeight =  Math.min(height[start],height[end]);
       sum = Math.max(sum,minHeight*(end-start));
       if(height[start] < height[end]){
         ++start;
       }else {
       --end;
       }

     }
     return sum;
    }
}
