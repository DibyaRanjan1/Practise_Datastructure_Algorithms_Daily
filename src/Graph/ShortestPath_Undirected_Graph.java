package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

 class Pair{
    public int node;
    public int distance;
}
public class ShortestPath_Undirected_Graph {
    public static void main(String[] args) {

    }

    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<Integer>());
        }

        for(int i=0;i<m;i++){

            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);

        }

        int[] distance = new int[n];
        Arrays.fill(distance,Integer.MAX_VALUE);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        distance[src] = 0;

        while (!queue.isEmpty()){
            int node = queue.poll();

            for(int it:adj.get(node)){
                int currentNodeDistance = distance[it];
                if(distance[node]+1 < currentNodeDistance){
                    distance[it] = 1+distance[node];
                    queue.add(it);
                }

            }
        }

        for(int i=0;i<n;i++){
            if(distance[i] == Integer.MAX_VALUE){
                distance[i] = -1;
            }
        }
        return distance;
    }
}
