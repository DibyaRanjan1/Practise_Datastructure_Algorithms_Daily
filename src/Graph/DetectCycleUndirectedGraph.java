package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Node{
    int first;
    int second;

   public Node(int first, int second){
this.first = first;
this.second = second;
    }
}
public class DetectCycleUndirectedGraph {
    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i=0;i<4;i++){
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(3);
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);
        adj.get(3).add(0);



        //isCycleUsingBFS(4,adj);
        isCycleUsingDFS(4,adj);
    }

    public static boolean isCycleUsingBFS(int V, ArrayList<ArrayList<Integer>> adj){

        boolean[] visited = new boolean[V];

        for(int i=0;i<V;i++){
            if(!visited[i]){
                boolean result = checkCycle(visited,adj,i);
                if(result) return true;
            }
        }
        return false;
    }

    private static boolean checkCycle(boolean[] visited,ArrayList<ArrayList<Integer>> adj, int source){
        Queue<Node> q = new LinkedList<Node>();
        q.add(new Node(source,-1));

        visited[source] = true;

        while (!q.isEmpty()){
            Node node = q.poll();
            int src = node.first;
            int parent = node.second;


            for(Integer it: adj.get(src)){
                if(!visited[it]){
                    q.add(new Node(it,src));
                    visited[it] = true;
                }else {
                    if(parent != it) return true;
                }
            }
        }
        return false;
    }

    public static boolean isCycleUsingDFS(int V, ArrayList<ArrayList<Integer>> adj){
        boolean[] visited = new boolean[V];
        for(int i=0;i<V;i++){
            if(!visited[i]){
               boolean result =isCycleUsingDFSUtil(visited,adj,i,-1);
               if(result) return true;
            }
        }
        return false;

    }

    private static boolean isCycleUsingDFSUtil(boolean[] visited,ArrayList<ArrayList<Integer>> adj, int source,int parent){
        visited[source] = true;

        for(Integer it:adj.get(source)){
            if(!visited[it]){
               boolean result = isCycleUsingDFSUtil(visited,adj,it,source);
               if(result) return true;
            }else {
                if(parent!=it) return true;
            }
        }
        return false;
    }
}
