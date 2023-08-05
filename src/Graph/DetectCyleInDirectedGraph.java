package Graph;

import java.util.ArrayList;

public class DetectCyleInDirectedGraph {
    public static void main(String[] args) {

    }


    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        boolean[] visited = new boolean[adj.size()];
        boolean[] pathVisited = new boolean[adj.size()];

        for(int i=0;i<adj.size();i++){
            if(!visited[i]){
                boolean result = isCycle(adj,visited,pathVisited,0);
                if(result) return true;
            }
        }
        return false;

    }

    private boolean isCycle(ArrayList<ArrayList<Integer>> adj,boolean[] visited, boolean[] pathVisited,int source){

        visited[source] = true;
        pathVisited[source] = true;
        for(Integer it: adj.get(source)){
            if(!visited[it]){
              boolean result =  isCycle(adj,visited,pathVisited,it);
             if(result) return true;
            }
            else {
                if(pathVisited[it]) return true;
            }


        }
        pathVisited[source] = false;
        return false;
    }

}
