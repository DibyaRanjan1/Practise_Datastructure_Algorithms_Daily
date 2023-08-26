package Graph;

import java.util.*;

public class EventualSafe {
    public static void main(String[] args) {

    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
       int v = graph.length;
        ArrayList<ArrayList<Integer>> revAdj = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<v;i++){
            revAdj.add(new ArrayList<Integer>());
        }

        int[] indegree = new int[v];

        for(int i=0;i<v;i++){
            for(int it:graph[i]){
                revAdj.get(it).add(i);
                indegree[i]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int i=0;i<v;i++){
            if(indegree[i]==0){
                queue.add(i);
            }
        }

        List<Integer> result = new ArrayList<>();

        while (!queue.isEmpty()){
          int safeElement =   queue.poll();
          result.add(safeElement);

          for(int it:revAdj.get(safeElement)){
              indegree[it]--;
              if(indegree[it]==0){
                  queue.add(it);
              }
          }
        }

        Collections.sort(result);
        return result;

    }
}
