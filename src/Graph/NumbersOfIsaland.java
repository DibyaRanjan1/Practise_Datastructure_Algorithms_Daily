package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class NumbersOfIsaland {
    public static void main(String[] args) {

        char[][] grid =  {
                {'0', '1', '1', '1', '0', '0', '0'},
                {'0', '0', '1', '1', '0', '1', '0'}
        };

        NumbersOfIsaland n = new NumbersOfIsaland();
        n.numIslands(grid);
    }

    public int numIslands(char[][] grid) {

        if(grid ==null) return 0;

        Queue<pair1> q = new LinkedList<>();


        int rows = grid.length;
        int cols = grid[0].length;

        boolean[][] visited = new boolean[rows][cols];

        int count =0;

        for (int i=0;i< rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    ++count;
                   bfs(grid,visited,i,j);

                }
            }
        }
        return count;
    }

    private void bfs(char[][] grid, boolean[][] visited, int row,int col){
        Queue<pair1> q = new LinkedList<>();
        q.add(new pair1(row,col));
        int rows = grid.length;
        int cols = grid[0].length;

        int[] xcorinates = {-1,-1,1,1,0,0,1,-1};
        int[] ycorinates = {-1,1,-1,1,1,-1,0,0};
        while (!q.isEmpty()){
            pair1 temp = q.poll();

            for(int i=0;i<8;i++){
                int newX = temp.first + xcorinates[i];
                int newY = temp.second + ycorinates[i];

                if(newX>=0 && newX<rows && newY>=0 && newY < cols && grid[newX][newY] == '1' && !visited[newX][newY]){
                    visited[newX][newY] = true;
                    q.add(new pair1(newX,newY));
                }
            }
        }
    }

    class pair1{
        public int first;
        public  int second;


        public pair1(int first,int second){
            this.first = first;
            this.second = second;
        }


    }
}
