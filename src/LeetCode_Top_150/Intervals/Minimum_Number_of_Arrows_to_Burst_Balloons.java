package LeetCode_Top_150.Intervals;

import java.util.Arrays;
import java.util.LinkedList;

public class Minimum_Number_of_Arrows_to_Burst_Balloons {
    public static void main(String[] args) {
        Minimum_Number_of_Arrows_to_Burst_Balloons m = new Minimum_Number_of_Arrows_to_Burst_Balloons();
      int [][] points = {{3,9},{7,12},{3,8},{6,8},{9,10},{2,9},{0,9},{3,9},{0,6},{2,8}};
      m.findMinArrowShots(points);
    }

    // My solution
    public int findMinArrowShots(int[][] points) {

        Arrays.sort(points, (o1, o2) -> {
            if (o1[1] == o2[1]) return 0;
            if (o1[1] < o2[1]) return -1;
            return 1;
        });

        LinkedList<int[]> result = new LinkedList<>();

        int count = points.length;

        for(int i=0;i< points.length;i++){

            if(result.isEmpty()){
                result.add(points[i]);
                continue;
            }

            if(result.getLast()[1] <= points[i][1] && result.getLast()[1] >= points[i][0] ){
                --count;

            }else {
                result.add(points[i]);
            }
        }
        return count;
    }

    public int findMinArrowShots_Optimal(int[][] points) {

        Arrays.sort(points,(a,b) -> (Integer.compare(a[1],b[1])));


        int xEnd = points[0][1];
        int arrows = 1;

        for(int[] it:points){

            int start = it[0];
            int end = it[1];

            if(start> xEnd){
                arrows++;
              xEnd = end;
            }
        }

        return arrows;
    }
}
