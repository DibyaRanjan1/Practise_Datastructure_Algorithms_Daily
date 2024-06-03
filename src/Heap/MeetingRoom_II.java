package Heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoom_II {
    public static void main(String[] args) {

    }

    class ArrayComparator implements Comparator<int[]>{

        @Override
        public int compare(int[] o1, int[] o2) {
            if(o1[0] < o2[0] ){
                return 1;
            } else if (o1[0]>o2[0]) {
                return -1;
            }else {
                if(o1[1] < o2[1]){
                    return 1;
                } else if (o1[1]>o2[1]) {
                    return -1;
                }else {
                    return 0;
                }
            }
        }
    }

    public int minMeetingRooms(int[][] intervals) {
        PriorityQueue<Integer> meetingRoomAllocator = new PriorityQueue<Integer>(intervals.length, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });

        int result=1;

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });

        meetingRoomAllocator.add(intervals[0][1]);

        for(int i=1;i<intervals.length;i++){

            if(intervals[i][0] >= meetingRoomAllocator.peek()){
                meetingRoomAllocator.poll();
            }

            meetingRoomAllocator.add(intervals[i][1]);
        }
      return meetingRoomAllocator.size();
    }
}
