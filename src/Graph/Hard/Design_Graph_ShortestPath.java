package Graph.Hard;

public class Design_Graph_ShortestPath {
    public static void main(String[] args) {

    }
    int[][] graph;
    int size;
    public Design_Graph_ShortestPath(int n, int[][] edges) {

        graph = new int[n][n];
        this.size = n;

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                graph[i][j] =(Integer.MAX_VALUE);
                if(i==j){
                    graph[i][j] =0;
                }
            }
        }

        int rows = edges.length;
        int cols = edges[0].length;

        for(int i=0;i<rows;i++){
            int row = edges[i][0];
            int col = edges[i][1];
            int edgeCost = edges[i][2];

            graph[row][col] = edgeCost;
        }

      for(int via=0;via<n;via++){
          for(int i=0;i<n;i++){
              for(int j=0;j<n;j++){
                  graph[i][j] = Math.min(graph[i][j], graph[i][via] + graph[via][j]);
              }
          }
      }


    }

    public void addEdge(int[] edge) {
       int row = edge[0];
       int col = edge[1];
       int edgeCost = edge[2];

       graph[row][col] = edgeCost;

        for(int via=0;via<size;via++){
            for(int i=0;i<size;i++){
                for(int j=0;j<size;j++){
                    graph[i][j] = Math.min(graph[i][j], graph[i][via] + graph[via][j]);
                }
            }
        }

    }

    public int shortestPath(int node1, int node2) {
      if(graph[node1][node2] == Integer.MAX_VALUE) return -1;
      return graph[node1][node2];
    }
}
