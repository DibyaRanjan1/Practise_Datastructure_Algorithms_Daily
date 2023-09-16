package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Pair_Path_Min{
    public int weight;
    public int row;
    public int col;
}
public class PathWith_MinEffort {
    public static void main(String[] args) {

    }

    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length;
        int cols =heights[0].length;

        ArrayList<ArrayList<Integer>> efforts = new ArrayList<ArrayList<Integer>>();

        int[][] cordinates = {{1,0},{-1,0},{0,1},{0,-1}};
        int[][] distance = new int[rows][cols];

        int nodeDistance = 0;

        for(int i=0;i<rows;i++){
            Arrays.fill(distance[i],(int)(1e9));
        }


        PriorityQueue<Pair_Path_Min> pq = new PriorityQueue<Pair_Path_Min>((x,y) -> (x.weight - y.weight));

        distance[0][0] = 0;
         Pair_Path_Min p = new Pair_Path_Min();
         p.col =0;
         p.row = 0;
         p.weight =0;

         pq.add(p);

         while (!pq.isEmpty()){

             Pair_Path_Min topNode = pq.poll();
             int currRow = topNode.row;
             int currCol = topNode.col;
             int currDistance = topNode.weight;

             if(currRow == rows-1 && currCol == cols-1) return currDistance;

             for(int i=0;i<4;i++){
                 int newRow = currRow + cordinates[i][0];
                 int newCol = currCol + cordinates[i][1];

                 if(newRow <0 || newRow > rows-1 || newCol < 0 || newCol > cols-1) continue;

                 int newDistance =Math.abs(heights[newRow][newCol] - heights[currRow][currCol]);

                 nodeDistance = Math.max(currDistance,newDistance);

                if(distance[newRow][newCol] > nodeDistance){
                    distance[newRow][newCol] = nodeDistance;

                    Pair_Path_Min newNode = new Pair_Path_Min();
                    newNode.weight = nodeDistance;
                    newNode.row = newRow;
                    newNode.col = newCol;
                    pq.add(newNode);
                }
             }
         }

return -1;

    }

    private void dfs(int[][] heights,int srcRow,int srcCol,int[][] cordinate, boolean[][] visited, ArrayList<ArrayList<Integer>> result){
        int rows = heights.length;
        int cols =heights[0].length;
        if(srcRow == rows-1 && srcCol == cols-1) return;
        visited[srcRow][srcCol] = true;



        for(int i=0;i<4;i++){
            int newRow = srcRow + cordinate[i][0];
            int newCol = srcCol + cordinate[i][1];

            if(newRow<0 || newRow > rows-1 || newCol < 0 || newCol > cols-1 || visited[newRow][newCol]){
                continue;
            }
             int absDistance = Math.abs(heights[srcRow][srcCol] - heights[newRow][newCol]);
            dfs(heights,newRow,newCol,cordinate,visited,result);

        }


    }
}
