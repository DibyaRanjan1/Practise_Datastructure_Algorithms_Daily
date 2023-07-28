package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class EasyProblems {

    public static void main(String[] args) {

        int V=6;
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();

        for(int i=0;i<V;i++){
            adjList.add(new ArrayList<Integer>());
        }

//        Graph g = new Graph();
//        g.addEdge(adjList, 1, 2);
//        g.addEdge(adjList, 1, 3);
//        g.addEdge(adjList, 2, 4);
//        g.addEdge(adjList, 2, 5);
//        g.addEdge(adjList, 3, 5);
//        g.addEdge(adjList, 4, 5);
//        g.addEdge(adjList, 4, 6);
//        g.addEdge(adjList, 5, 6);



        //g.bfs(adjList,V);
        //g.dfs(adjList,V);

       // shortestPathFromSource(adjList,1,V);

        //detectCycleInGraph(adjList,V);

        Graph g1 = new Graph();
        g1.addEdgeDirected(adjList,0,1);
        g1.addEdgeDirected(adjList,2,1);
        g1.addEdgeDirected(adjList,2,3);
        g1.addEdgeDirected(adjList,3,4);
        g1.addEdgeDirected(adjList,4,5);
        g1.addEdgeDirected(adjList,5,3);

        detectCycleInDirectedGraph(adjList,V);

    }

    public static int[] shortestPathFromSource(ArrayList<ArrayList<Integer>> adj, int source,int V){

        boolean[] visited = new boolean[V+1];
        int[] distance = new int[V+1];

        for(int i=1;i<V+1;i++){
            distance[i] = Integer.MAX_VALUE;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);

        visited[source] = true;
        distance[1] = 0;

        while (!queue.isEmpty()){

            int val = queue.poll();

            for(int i=0;i<adj.get(val).size();i++){

                if(!visited[adj.get(val).get(i)]){
                    visited[adj.get(val).get(i)] = true;
                    distance[adj.get(val).get(i)] = distance[val]+1;
                    queue.add(adj.get(val).get(i));
                }
            }
        }

        return distance;
    }

    public static boolean detectCycleInGraph(ArrayList<ArrayList<Integer>> adjList,int V){
        boolean[] visited = new boolean[V+1];

        for(int i=1;i< V+1;i++){

            if(!visited[i]){
              boolean result =  dfsUtil(adjList,i,visited,-1);
              if(result) return true;
            }
        }
        return false;
    }

    private static boolean dfsUtil(ArrayList<ArrayList<Integer>> adj,int source, boolean[] visited,int parent){

        visited[source] = true;
        for (int i=0;i<adj.get(source).size();i++){
            if(!visited[adj.get(source).get(i)]){
               boolean result = dfsUtil(adj,adj.get(source).get(i),visited,source);
              if(result) return true;

            }else {
                if(adj.get(source).get(i) != parent) return true;
            }
        }
        return false;
    }

    public static boolean detectCycleInDirectedGraph(ArrayList<ArrayList<Integer>> adj,int v){
        boolean[] visited = new boolean[v];
        boolean[] recStack = new boolean[v];

        for(int i=0;i< adj.size();i++){
            if(!visited[i]){
              boolean result =  detectCycleInDirectedGraphUtil(adj,visited,recStack,i);
              if(result) return true;
            }
        }
        return false;


    }

    private static boolean detectCycleInDirectedGraphUtil(ArrayList<ArrayList<Integer>> adj,boolean[] visited, boolean[] recStack,int source){
        visited[source] = true;
        recStack[source] = true;

        for(int i=0;i< adj.get(source).size();i++){

            if(!visited[adj.get(source).get(i)]){
              boolean result =  detectCycleInDirectedGraphUtil(adj, visited, recStack, adj.get(source).get(i));
              if(result) return true;
            }else {
                if(recStack[adj.get(source).get(i)]) return true;
            }
        }

        recStack[source] = false;
        return false;
    }
}

