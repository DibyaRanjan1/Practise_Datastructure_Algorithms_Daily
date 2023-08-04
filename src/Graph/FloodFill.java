package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {
    public static void main(String[] args) {
        int[][] input = new int[2][3];
        input[0][0] = 0;
        input[0][1] = 0;
        input[0][2] = 0;

        input[1][0] = 0;
        input[1][1] = 1;
        input[1][2] = 0;

        int sr = 1;int sc = 1; int color = 2;
       floodFill(input,sr,sc,2);
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
       if(image ==null ) return image;

        int startingPixel = image[sr][sc];

        int rows = image.length;
        int cols = image[0].length;

        int[] dx ={0,0,1,-1};
        int[] dy ={1,-1,0,0};

        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{sr,sc});
          image[sr][sc] = color;
        while(!q.isEmpty()){
             int[] element = q.poll();

            for(int i=0;i<4;i++){
                int row = element[0]+dx[i];
                int cole = element[1]+dy[i];

                if(row >= rows || row <0 || cole >= cols || cole <0 || image[row][cole]==color || image[row][cole] !=startingPixel) continue;
                image[row][cole] = color;
                q.offer(new int[]{row,cole});
            }
        }
     return image;

    }
}
