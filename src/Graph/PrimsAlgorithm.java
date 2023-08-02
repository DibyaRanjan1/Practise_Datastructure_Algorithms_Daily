package Graph;

import java.util.Arrays;

public class PrimsAlgorithm {
    public static void main(String[] args) {
        int V = 4;
        int[][] graph = new int[V][V];

        graph[0][0] = 0;
        graph[0][1] = 5;
        graph[0][2] = 8;
        graph[1][2] = 10;
        graph[1][3] = 15;
        graph[2][3] = 20;

        primsAlgo(graph, V,0);
    }

    public static void primsAlgo(int[][] graph,int V,int source){
        int parent[] = new int[V];
        int[] key = new int[V];
        int res =0;
        Arrays.fill(key,Integer.MAX_VALUE);
        key[source] =0;
        boolean[] mSet = new boolean[V];

        for(int count=0;count<V;count++){
            int u =-1;
            for(int i=0;i<V;i++){
                if(!mSet[i] && (u==-1 || key[i] < key[u])){
                    u = i;
                }
            }
            mSet[u] = true;

            for(int v=0;v< V;v++){
                if(!mSet[v] && graph[u][v] !=0 && graph[u][v] < key[v]){
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
            }
        }
    }
}
