package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    public static void main(String[] args) {

        int[][] isConnected =new int[3][3];
        isConnected[0][0] = 2;
        isConnected[0][1] = 1;
        isConnected[0][2] = 1;

        isConnected[1][0] = 1;
        isConnected[1][1] = 1;
        isConnected[1][2] = 0;

        isConnected[2][0] = 0;
        isConnected[2][1] = 1;
        isConnected[2][2] = 1;

        orangesRotting(isConnected);
    }

    public static int orangesRotting(int[][] grid) {

        if(grid == null || grid.length ==0)
            return 0;

     int rows = grid.length;
     int cols = grid[0].length;

     int countFreshOrange = 0;


        Queue<int[]> q = new LinkedList<>();

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j] ==2){
                    q.offer(new int[]{i,j});
                }
                if(grid[i][j] !=0){
                   countFreshOrange++;
                }
            }
        }
        if(countFreshOrange == 0) return 0;

        int cnt=0, countMin = 0;
        int dx[]={0,0,1,-1};
        int dy[]={1,-1,0,0};

        while(!q.isEmpty()){
            int size = q.size();
            cnt = cnt + size;

            for(int i=0;i<size;i++){
                int[] point = q.poll();
                for(int j=0;j<4;j++){
                    int x = point[0]+dx[j];
                    int y = point[1]+dy[j];

                    if(x < 0 || y<0 || x>=rows || y >=cols || grid[x][y] ==0 || grid[x][y] == 2) continue;

                    grid[x][y] =2;
                    q.offer(new int[]{x,y});

                }
            }

            if(!q.isEmpty()) countMin++;
        }

        return countFreshOrange == cnt ? countMin:-1;

    }


}
