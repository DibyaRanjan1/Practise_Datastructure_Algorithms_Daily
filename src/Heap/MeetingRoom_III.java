package Heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoom_III {
    public static void main(String[] args) {

    }

    public int mostBooked(int n, int[][] meetings) {

        PriorityQueue<Integer> unUsed = new PriorityQueue<>();

        for(int i=0;i<n;i++){
            unUsed.add(i);
        }

        PriorityQueue<long[]> used = new PriorityQueue<long[]>((a,b)->
            a[0]!=b[0]?Long.compare(a[0],b[0]):Long.compare(a[1],b[1])
        );

        var meetingCount = new int[n];

        Arrays.sort(meetings,(a,b)->
                a[0]!=b[0]?Integer.compare(a[0],b[0]):Integer.compare(a[1],b[1]));

        for(int i=0;i<meetings.length;i++){
            int start = meetings[i][0];
            int end = meetings[i][1];

            while (!used.isEmpty() && used.peek()[0] <= start){
                 int room = (int)used.poll()[1];
                 unUsed.offer(room);
            }

            if(!unUsed.isEmpty()){
                int unUsedRooms = unUsed.poll();
                used.offer(new long[]{end,unUsedRooms});
                meetingCount[unUsedRooms]++;
            }else {
               long roomAvaliablityTime =  used.peek()[0];
               int room = (int) used.poll()[1];
               used.offer(new long[]{roomAvaliablityTime+end-start,room});
               meetingCount[room]++;
            }
        }

        int maxMeetingCount = 0, maxMeetingCountRoom = 0;
        for (int i = 0; i < n; i++) {
            if (meetingCount[i] > maxMeetingCount) {
                maxMeetingCount = meetingCount[i];
                maxMeetingCountRoom = i;
            }
        }

        return maxMeetingCountRoom;

    }
}
