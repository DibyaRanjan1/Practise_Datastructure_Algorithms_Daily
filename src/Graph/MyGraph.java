package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class MyGraph {
    public static void main(String[] args) {

        int v=6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(v);

        for(int i=0;i< v;i++){
            adj.add(new ArrayList<Integer>());
        }

        AddEdge(adj,0,1);
        AddEdge(adj,0,2);
        AddEdge(adj,1,3);
        AddEdge(adj,1,2);
        AddEdge(adj,4,5);

       // PrintGraph(adj);

       // BFSUndirectedGraph(adj,4,0);

        BFSDisconnectedGraph(adj,6,0);
    }

    public static void AddEdge(ArrayList<ArrayList<Integer>> adj,int u,int v){

        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    public static void PrintGraph(ArrayList<ArrayList<Integer>> adjList){
        for(int i=0;i<adjList.size();i++){
            for(int j=0;j< adjList.get(i).size();j++ ){
                System.out.println(adjList.get(i).get(j));
            }
            System.out.println();
        }
    }

    public static void BFSUndirectedGraph(ArrayList<ArrayList<Integer>> adjList,int v, int s){
        Boolean visited[] = new Boolean[v+1];

        for(int i=0;i<visited.length;i++){
            visited[i] = false;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        visited[s] = true;

        while(!queue.isEmpty()){
         Integer data =   queue.poll();
            System.out.println(data + " ");

           for(int u: adjList.get(data)){

               if(!visited[u]){
                   visited[u] = true;
                   queue.add(u);
               }

           }

        }
    }

    public static void BFSDisconnectedGraph(ArrayList<ArrayList<Integer>> adjList,int v, int s){
        Boolean visited[] = new Boolean[v+1];

        for(int i=0;i<visited.length;i++){
            visited[i] = false;
        }

        for (int i=0;i<adjList.size();i++){
            if(!visited[i]){
                BFSGraph(adjList,i,visited);
            }

        }


    }

    public static void BFSGraph(ArrayList<ArrayList<Integer>> adjList, int s,Boolean[] visited){


        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        visited[s] = true;

        while(!queue.isEmpty()){
            Integer data =   queue.poll();
            System.out.println(data + " ");

            for(int u: adjList.get(data)){

                if(!visited[u]){
                    visited[u] = true;
                    queue.add(u);
                }
            }
        }
    }

}
