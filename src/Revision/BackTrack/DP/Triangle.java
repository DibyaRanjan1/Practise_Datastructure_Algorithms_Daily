package Revision.BackTrack.DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle {
    public static void main(String[] args) {
       Triangle t = new Triangle();

       List<List<Integer>> input = new ArrayList<>(4);
          List<Integer> input1 = new ArrayList<>();
          input1.add(2);

        List<Integer> input2 = new ArrayList<>();
        input2.add(3);
        input2.add(4);

        List<Integer> input3 = new ArrayList<>();
        input3.add(6);
        input3.add(5);
        input3.add(7);

        List<Integer> input4 = new ArrayList<>();
        input4.add(4);
        input4.add(1);
        input4.add(8);
        input4.add(3);

        input.add(input1);
        input.add(input2);
        input.add(input3);
        input.add(input4);

     int result =  t.minimumTotal(input);
     int result1 = t.minimumTotal_tabulation(input);
    }

    public int minimumTotal(List<List<Integer>> triangle) {

        int size = triangle.size();
        int[][] memo = new int[size][size];

        for(int i=0;i<size;i++){
            Arrays.fill(memo[i],-1);
        }
        return minimumTotal_recur(0,0,triangle, memo);
    }

    private int minimumTotal_recur(int rowIndex,int colIndex, List<List<Integer>> triangle, int[][] memo){

        if(rowIndex == triangle.size()-1 && colIndex < triangle.get(rowIndex).size() ){
            return triangle.get(rowIndex).get(colIndex);
        }
        if(rowIndex >= triangle.size() || colIndex >= triangle.get(rowIndex).size()) return Integer.MAX_VALUE;

        if(memo[rowIndex][colIndex]!=-1) return memo[rowIndex][colIndex];

         int down = triangle.get(rowIndex).get(colIndex) +  minimumTotal_recur(rowIndex+1, colIndex,triangle,memo);
         int downRight = triangle.get(rowIndex).get(colIndex) +   minimumTotal_recur(rowIndex+1,colIndex+1,triangle,memo);

         return memo[rowIndex][colIndex] = Math.min(down,downRight);

    }

    public int minimumTotal_tabulation(List<List<Integer>> triangle) {

        int size = triangle.size();
        int[][] memo = new int[size][size];

        for(int i=0;i<size;i++){
            memo[size-1][i] = triangle.get(size-1).get(i);
        }

        for(int i=size-2;i>=0;i--){
            for(int j = 0;j< triangle.get(i).size();j++){

                  int down = Integer.MAX_VALUE;

                 down =triangle.get(i).get(j) + memo[i+1][j];

                  int downRight = Integer.MAX_VALUE;
                 downRight = triangle.get(i).get(j) + memo[i+1][j+1];

                  memo[i][j] = Math.min(down,downRight);
            }
        }

        return memo[0][0];
    }
}
