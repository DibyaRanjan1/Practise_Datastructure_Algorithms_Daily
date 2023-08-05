package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TopoBFS {
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
        return topoBFS(adj);
    }

    private static int[] topoBFS(ArrayList<ArrayList<Integer>> adj){
        int[] indegree = new int[adj.size()];

        getIndegree(adj,indegree);

        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<indegree.length;i++){
            if(indegree[i] == 0)
                q.add(i);
        }

        int index =0;
        int[] result = new int[adj.size()];

        while (!q.isEmpty()){
            int num = q.poll();
            result[index++] = num;

            for(Integer it:adj.get(num)){
                indegree[it]--;
                if(indegree[it] == 0){
                    q.add(it);
                }
            }
        }
        return result;
    }

    private static void getIndegree(ArrayList<ArrayList<Integer>> adj, int[] indegree){
        for(ArrayList<Integer> lst:adj){
            for(Integer it: lst){
                indegree[it]++;
            }
        }
    }
}
