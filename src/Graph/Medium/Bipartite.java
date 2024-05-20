package Graph.Medium;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Bipartite {
    public boolean isBipartite(int[][] graph) {
        int rows = graph.length;
        int[] colours = new int[rows];
        Arrays.fill(colours,-1);

       for(int i=0;i<rows;i++){
           if(colours[i]==-1){
               if(!dfs(colours,graph,i)){
                   return false;
               }
           }
       }
       return true;

    }

    private boolean dfs(int[] colours,int[][] graph, int src){

        Queue<Integer> queue = new ArrayDeque<>();
         queue.add(src);
         colours[src]=1;

        while (!queue.isEmpty()){
            int currEle = queue.poll();
            int currColour = colours[currEle];

            for(int ele:graph[currEle]){

                if(colours[ele]==-1){
                    colours[ele] = 1-currColour;
                    queue.add(ele);
                }else if(colours[ele]==currColour){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
         int[][] graph = new int[][]{{1,3},{0,2},{1,3},{0,2}};
         Bipartite b = new Bipartite();
         b.isBipartite(graph);
    }
}
