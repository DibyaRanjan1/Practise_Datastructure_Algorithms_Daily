package Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Pair_SPB{
    public int weight;
    public int row;
    public int col;
}
public class Shortest_Path_Binary_Matrix {
    public static void main(String[] args) {
        int[][] array = {{0,1},{1,0}};

       Shortest_Path_Binary_Matrix s = new Shortest_Path_Binary_Matrix();
       int result = s.shortestPathBinaryMatrix(array);
    }

    public int shortestPathBinaryMatrix(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        int result=-1;

        if(grid[0][0]==1) return result;

        int[][] distance = new int[rows][cols];
        for(int i=0;i<rows;i++){
            Arrays.fill(distance[i],(int)(1e9));
        }

        Queue<Pair_SPB> queue = new LinkedList<Pair_SPB>();
        distance[0][0] = 1;

        Pair_SPB srcPair = new Pair_SPB();
        srcPair.col = 0;
        srcPair.row = 0;
        srcPair.weight = 1;

        queue.add(srcPair);

        int[] xrow = {1,1,-1,-1,1,-1,0,0};
        int[] ycol = {1,-1,1,-1,0,0,1,-1};

        while (!queue.isEmpty()){
            Pair_SPB curr = queue.poll();

            for(int i=0;i<8;i++){
               int newRow =curr.row +  xrow[i];
               int newCol = curr.col + ycol[i];

               if(newRow >= 0 && newRow < rows && newCol >=0 && newCol < cols && grid[newRow][newCol] == 0 ){

                   if(distance[curr.row][curr.col] + 1 < distance[newRow][newCol]){
                       distance[newRow][newCol] = distance[curr.row][curr.col] + 1;
                       Pair_SPB currEle = new Pair_SPB();
                       currEle.row = newRow;
                       currEle.col = newCol;
                       currEle.weight = distance[newRow][newCol];
                       queue.add(currEle);
                   }

               }
            }
        }

      if(distance[distance.length-1][distance.length-1] == 1e9){
          return -1;
      }
      return distance[distance.length-1][distance.length-1];

    }
}
