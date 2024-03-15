package Intervals;

import java.util.Arrays;

public class MeetingRoom_II {
    public static void main(String[] args) {

    }

    public int minMeetingRooms(int[][] intervals) {

        Arrays.sort(intervals,(a,b)->{
            return Integer.compare(a[0],b[0]);
        });

        return 1;
    }
}
