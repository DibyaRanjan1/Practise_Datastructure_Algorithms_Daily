package Intervals;

import java.util.Arrays;

public class MeetingRomms {
    public static void main(String[] args) {

    }

    public boolean canAttendMeetings(int[][] intervals) {

        if(intervals.length==0) return true;

        Arrays.sort(intervals,( a,  b)->{
            return Integer.compare(a[0],b[0]);
        });

        int prevStart=intervals[0][0];
        int prevEnd =intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            int currentStart = intervals[i][0];
            int currentEnd = intervals[i][1];

            if(prevEnd > currentStart) return false;
            prevStart = currentStart;
            prevEnd = currentEnd;
        }
        return true;
    }
}
