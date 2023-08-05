package Graph;

import java.util.ArrayList;
import java.util.Stack;

public class TopoDFS {
    public static void main(String[] args) {


        int V = 6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(2).add(3);
        adj.get(3).add(1);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(5).add(0);
        adj.get(5).add(2);

        topoSort(6,adj);
    }

    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj)
    {
        boolean[] visited = new boolean[adj.size()];
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[adj.size()];

        for(int i=0;i<adj.size();i++){
            if(!visited[i]){
                topoDfs(adj,visited,i,stack);
            }
        }

        for (int i=0;i<result.length;i++){
            if(!stack.isEmpty()){
                result[i] = stack.pop();
            }

        }
        return result;

    }

    private static void topoDfs(ArrayList<ArrayList<Integer>> adj,boolean[] visited, int source, Stack<Integer> stack){

        visited[source] = true;

        for(Integer it:adj.get(source)){
            if(!visited[it]){
                topoDfs(adj,visited,it,stack);

            }

        }

        stack.push(source);


    }
}
