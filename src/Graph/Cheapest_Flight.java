package Graph;

import java.util.*;

class Pair_Cheapest{
    Pair_Cheapest(int node,int price){
        this.node = node;
        this.price = price;

    }
    public int node;
    public int price;
    public int stop;
}
public class Cheapest_Flight {
    public static void main(String[] args) {

    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        ArrayList<ArrayList<Pair_Cheapest>> adj = new ArrayList<ArrayList<Pair_Cheapest>>();

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<Pair_Cheapest>());
        }

        for(int i=0;i<flights.length;i++){
            adj.get(flights[i][0]).add(new Pair_Cheapest(flights[i][1],flights[i][2]));
        }

        Queue<Pair_Cheapest> pq = new LinkedList<Pair_Cheapest>();

        Pair_Cheapest p = new Pair_Cheapest(src,0);
        p.stop = 0;
        pq.add(p);

        int[] distance =new int[n];

        Arrays.fill(distance,(int)1e9);

        distance[src] = 0;

        while (!pq.isEmpty()){

            Pair_Cheapest currentNode = pq.poll();
            int curPrice = currentNode.price;
            int curNode = currentNode.node;
            int curStop = currentNode.stop;

            if(curStop > k) continue;
            for(Pair_Cheapest it: adj.get(curNode)){

                if(curStop <= k &&  distance[it.node] > curPrice + it.price){
                    distance[it.node] = curPrice + it.price;
                    Pair_Cheapest newNode = new Pair_Cheapest(it.node,curPrice + it.price);
                    newNode.stop = curStop+1;
                    pq.add(newNode);
                }
            }
        }

        if(distance[dst] == (int)1e9){
            return -1;
        }
        return distance[dst];
    }
}
