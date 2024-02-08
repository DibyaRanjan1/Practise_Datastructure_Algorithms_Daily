package Revision.BackTrack.DP;

import java.util.Arrays;

public class NinjaTraining {
    public static void main(String[] args) {

        NinjaTraining n = new NinjaTraining();

        int[][] input = {
                {1,2,5},
                {3,1,1},
                {3,3,3}
        };

      //int result =  n.ninjaTraining(3,input);
      int result1 = n.ninjaTraining_memo(3,input);
    }

    public  int ninjaTraining(int n, int points[][]) {

        return  ninjaTraining_recur(0,-1,n,points);

    }

    private int ninjaTraining_recur(int currentIndex, int prevIndex, int n, int points[][]){

        if(currentIndex ==n) return 0;

        int maxInEachRow = -1;
        for(int i=0;i<3;i++){
            if(prevIndex!=i){
              int takeMarit =   points[currentIndex][i] +  ninjaTraining_recur(currentIndex+1,i,n,points);
             maxInEachRow =Math.max(maxInEachRow,takeMarit) ;
            }

        }
        return maxInEachRow;
    }

    public  int ninjaTraining_memo(int n, int points[][]) {

        int row = 4;
        int col =4;

        int[][] memo = new int[row][col];
        for(int i=0;i<row;i++){
            Arrays.fill(memo[i],-1);
        }
        return  ninjaTraining_memo(0,3,n,points,memo);

    }
    private int ninjaTraining_memo(int currentIndex, int prevIndex, int n, int points[][],int[][] memo){

        if(currentIndex ==n) return 0;

        if(memo[currentIndex][prevIndex]!=-1) return memo[currentIndex][prevIndex];

        int maxInEachRow = -1;
        for(int i=0;i<3;i++){
            if(prevIndex!=i){
                int takeMarit =   points[currentIndex][i] +  ninjaTraining_recur(currentIndex+1,i,n,points);
                maxInEachRow =Math.max(maxInEachRow,takeMarit) ;
            }

        }
        return memo[currentIndex][prevIndex] = maxInEachRow;
    }

    public  int ninjaTraining_tabulation(int n, int points[][]) {

        int rows = n;
        int cols =4;

        int[] prev = new int[4];

        prev[0] = Math.max(points[rows-1][1], points[rows-1][2]);
        prev[1] = Math.max(points[rows-1][0], points[rows-1][2]);
        prev[2] = Math.max(points[rows-1][1], points[rows-1][0]);
        prev[3] = Math.max(points[rows-1][1], Math.max(points[rows-1][2],points[rows-1][0]));

        for(int row=rows-2;row>=0;row--){

            int[] temp = new int[4];

            for(int last=cols-1;last >=0;last--){
                temp[last] =0;

                for(int task=0;task<3;task++){
                    if(task!=last){
                        temp[last] =Math.max(temp[last],points[row][task] + prev[task]);

                    }
                }
                prev = temp;
            }
        }

        return prev[0];

    }


}
