package LeetCode_Top_150.Graph;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class SnakeLadder {

    class Pair<U,V>{

        Pair(U key,V value){
            this.key = key;
            this.value = value;
        }
        U key;
        V value;
    }
    public static void main(String[] args) {

        SnakeLadder s = new SnakeLadder();

        int[][] board = {{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,35,-1,-1,13,-1},{-1,-1,-1,-1,-1,-1},{-1,15,-1,-1,-1,-1}};
        s.snakesAndLadders(board);
    }

    public int snakesAndLadders(int[][] board) {

        int n = board.length;
        Pair<Integer,Integer>[] cells = new Pair[n*n+1];

        int[] columns = new int[n];
        for(int i=0;i<n;i++){
            columns[i] = i;
        }
        int label=1;

        for(int row = n-1;row>=0;row--){
            for(int column:columns){
                cells[label++] = new Pair<>(row,column);
            }

            Collections.reverse(Arrays.asList(columns));
        }

        int[] dis = new int[n*n+1];
        Arrays.fill(dis,-1);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        dis[1] =0;

        while (!queue.isEmpty()){

            int curr = queue.poll();

            for(int next = curr+1; next < Math.min(n*n, curr+6);next++){

                int row = cells[next].key;
                int col = cells[next].value;

                int destiantion = board[row][col] !=-1 ? board[row][col]:next;

                if(dis[destiantion] ==-1){
                  dis[destiantion] = dis[curr]+1;
                  queue.add(destiantion);
                }
            }
        }

        return dis[n*n];



    }
}
