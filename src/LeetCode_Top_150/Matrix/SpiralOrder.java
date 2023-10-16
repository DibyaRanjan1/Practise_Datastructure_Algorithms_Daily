package LeetCode_Top_150.Matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder {
    public static void main(String[] args) {

    }

    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> result = new ArrayList<>();

        int maxRow = matrix.length;
        int macCol = matrix[0].length;

       int left=0;
       int up=0;
       int right = macCol-1;
       int down = maxRow-1;

       while (result.size()< maxRow * macCol){

           for(int col=0;col<= right;col++){
               result.add(matrix[left][col]);
           }

           for(int row=up+1;row<=down;row++){
               result.add(matrix[row][right]);
           }

           if(up!=down){
               for(int col = right-1;col>=left;col--){
                   result.add(matrix[down][col]);
               }
           }

           if(left!=right){
               for(int row=down-1;row>up;row--){
                   result.add(matrix[row][left]);
               }
           }

           left++;
           right--;
           up++;
           down--;
       }

   return result;
    }
}
