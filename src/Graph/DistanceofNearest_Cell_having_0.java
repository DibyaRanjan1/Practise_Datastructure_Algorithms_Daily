package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class DistanceofNearest_Cell_having_0 {
    public static void main(String[] args) {

        int[][] grid = {
                {0,1,1,0},
                {1,1,0,0},
                {0,0,1,1}
        };
       int[][] result = updateMatrix(grid);
    }

    public static int[][] updateMatrix(int[][] mat) {

        if(mat ==null) return mat;

        int rows = mat.length;;
        int cols = mat[0].length;

        int[][] result = new int[rows][cols];
        int[][] visited = new int[rows][cols];

        Queue<TempNode> q = new LinkedList<TempNode>();



        for (int i=0;i< rows;i++){
            for(int j=0;j<cols;j++){

                if(mat[i][j] ==0){
                    result[i][j] = 0;
                    q.add(new TempNode(i,j,0));
                    visited[i][j] = 1;
                }else {
                    visited[i][j] = 0;
                }
            }
        }

        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};

        while (!q.isEmpty()){
            TempNode coordinate = q.poll();

            int row = coordinate.first;
            int col = coordinate.second;
            int dis = coordinate.third;

            result[row][col] = dis;

            for(int i=0;i<4;i++){
                int rowx = row+dx[i];
                int coly = col+ dy[i];

                if(rowx < rows && rowx >=0 && coly < cols && coly>=0 && visited[rowx][coly]==0){
                    visited[rowx][coly] = 1;
                    q.add(new TempNode(rowx,coly,dis+1));
                }
            }

            }
        return result;
        }

    }


class TempNode{
    int first;
    int second;
    int third;
    public TempNode(int first,int second,int third){
        this.first = first;
        this.second = second;
        this.third = third;
    }
}
