package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Pair_NWD{

    int distance;
    int node;
    public  Pair_NWD(int distance,int node){
        this.distance = distance;
        this.node = node;
    }
}

public class NumberOfWay_Destination {
    public static void main(String[] args) {

    }

    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<Pair_NWD>> adj = new ArrayList<ArrayList<Pair_NWD>>();

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<Pair_NWD>());
        }

        for(int i=0;i<roads.length;i++){
            adj.get(roads[i][0]).add(new Pair_NWD(roads[i][2],roads[i][1]));
            adj.get(roads[i][1]).add(new Pair_NWD(roads[i][2],roads[i][0]));
        }

        int[] distance = new int[n];

        Arrays.fill(distance,(int)1e9);

        distance[0]=0;

        int[] ways = new int[n];
        Arrays.fill(ways,0);
        ways[0] = 1;

        PriorityQueue<Pair_NWD> pq = new PriorityQueue<Pair_NWD>((x,y) -> x.distance-y.distance);
        pq.add(new Pair_NWD(0,0));

        int mod = (int)(1e9+7);
        while (!pq.isEmpty()){

            Pair_NWD parent = pq.poll();

            for(Pair_NWD curr:adj.get(parent.node)){

                if(distance[curr.node] > parent.distance + curr.distance){
                    distance[curr.node] = parent.distance + curr.distance;

                    Pair_NWD newNode = new Pair_NWD(parent.distance + curr.distance,curr.node);

                        ways[curr.node] = ways[parent.node];
                        pq.add(newNode);

                } else if (distance[curr.node] == parent.distance + curr.distance) {
                    ways[curr.node]= (ways[curr.node]+ways[parent.node])%mod;
                }
            }
        }


        return ways[n-1]%mod;


    }
}
