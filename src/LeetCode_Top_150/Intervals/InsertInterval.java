package LeetCode_Top_150.Intervals;

import java.util.LinkedList;

public class InsertInterval {
    public static void main(String[] args) {

    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        LinkedList<int[]> result = new LinkedList<>();

       int i=0;

       //
       while (i<intervals.length && newInterval[0] > intervals[i][1]){
           result.add(intervals[i]);
           i++;
       }

       while (i<intervals.length && newInterval[1] >= intervals[i][0]){
           newInterval[0] = Math.min(newInterval[0],intervals[i][0]);
           newInterval[1] = Math.max(newInterval[1],intervals[i][1]);
           i++;
       }
       result.add(newInterval);

       while (i<intervals.length){
           result.add(intervals[i]);
           i++;
       }

       return result.toArray(new int[result.size()][]);

    }
}
