package Graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {

  public void addEdge(ArrayList<ArrayList<Integer>> adjList,int u,int v){
       adjList.get(u).add(v);
       adjList.get(v).add(u);
  }

    public void addEdgeDirected(ArrayList<ArrayList<Integer>> adjList,int u,int v){
        adjList.get(u).add(v);
    }

  public void bfs(ArrayList<ArrayList<Integer>> adjList,int v){

      boolean[] visited = new boolean[v+1];

      int s=1;

      Queue<Integer> queue = new LinkedList<>();
      queue.add(s);

      visited[s] = true;

      while (!queue.isEmpty()){

          int val = queue.poll();
          System.out.println(val);

          for(int i=0;i<adjList.get(val).size();i++){

              int newnode = adjList.get(val).get(i);

              if(!visited[newnode]){
                  queue.add(newnode);
                  visited[newnode] = true;
              }
          }
      }
  }

  public void dfs(ArrayList<ArrayList<Integer>> adj,int v){
  boolean[] visited = new boolean[v+1];

  dfsUtil(adj,visited,1);

  }

  private void dfsUtil(ArrayList<ArrayList<Integer>> adj,boolean[] visited,int v){
      visited[v] = true;
      System.out.println(v);
      for(int i=0;i< adj.get(v).size();i++){

          if(!visited[adj.get(v).get(i)])
          dfsUtil(adj,visited,adj.get(v).get(i));
      }
  }



}
