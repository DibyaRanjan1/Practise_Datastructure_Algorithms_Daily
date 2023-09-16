package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

class Pair1{
    public int node;
    public int weight;
}
public class Shortest_path_DAG {
    public static void main(String[] args) {

    }

    public int[] shortestPath(int N,int M, int[][] edges) {
        ArrayList<ArrayList<Pair1>> adj = new ArrayList<ArrayList<Pair1>>();

        for (int i=0;i<N;i++){
            adj.add(new ArrayList<Pair1>());
        }

        for(int i=0;i<M;i++){

        Pair1 p = new Pair1();
        p.node = edges[i][1];
        p.weight = edges[i][2];
            adj.get(edges[i][0]).add(p);
        }

        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[N];
        int[] distance = new int[N];
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[0] = 0;

        topoSort(adj,stack,visited,0);

        while (!stack.isEmpty()){
            int popedElement = stack.pop();

            for(Pair1 it:adj.get(popedElement)){
                if(distance[popedElement] + it.weight < distance[it.weight]){
                    distance[it.node] = distance[popedElement] + it.weight;
                }
            }
        }
        return distance;

    }

    private void topoSort(ArrayList<ArrayList<Pair1>> adj , Stack<Integer> stack, boolean[] visited,int src){
        visited[src]=true;

        for(Pair1 it:adj.get(src)){
            if(!visited[it.node]){
                topoSort(adj,stack,visited,it.node);
            }
        }

        stack.push(src);
    }
}
