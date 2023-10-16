package Heap;

import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

public class LastStoneWeight {
    public static void main(String[] args) {

    }

    public int lastStoneWeight(int[] stones) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0;i<stones.length;i++){
            pq.add(stones[i]);
        }

        while (pq.size()>1){
           int first = pq.poll();
           if(pq.isEmpty()) return first;
           int second = pq.poll();

           if(first!=second) pq.add(Math.abs(first-second));
           if(pq.size()==1) return pq.peek();
        }

        return 0;
    }
}
