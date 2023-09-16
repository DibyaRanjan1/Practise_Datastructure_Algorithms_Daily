package Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class Pair_MM{
    public int step;
    public int number;

    public Pair_MM(int step,int number){
        this.number = number;
        this.step = step;
    }
}
public class Minimum_Multipication {
    public static void main(String[] args) {
       Minimum_Multipication m = new Minimum_Multipication();
       m.minimumMultiplications(new int[]{2,5,7},3,30);
    }

    int minimumMultiplications(int[] arr, int start, int end) {

        // Your code here
           if(start ==end) return 0;
        Queue<Pair_MM> pq = new LinkedList<Pair_MM>();
        pq.add(new Pair_MM(0,start));

        int[] distance = new int[100000];
        Arrays.fill(distance,Integer.MAX_VALUE);

        distance[start] = 0;

        int result=Integer.MAX_VALUE;

        while (!pq.isEmpty()){
            int parentStep = pq.peek().step;
            int parentNumber = pq.peek().number;
            pq.remove();

            for(int i=0;i<arr.length;i++){
                int newNumber = (parentNumber * arr[i])%100000;
                if(distance[newNumber] > parentStep+1){
                    if(newNumber == end) return parentStep+1;
                    distance[newNumber] = parentStep+1;
                    pq.add(new Pair_MM(parentStep+1,newNumber));
                }
            }
        }
      if(result == Integer.MAX_VALUE) return -1;
      return result;

    }
}
