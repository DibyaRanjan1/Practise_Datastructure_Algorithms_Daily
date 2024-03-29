package Graph;

import java.util.Arrays;

public class Redundant_Connection_II {
    public static void main(String[] args) {

    }

    private class UnionFind{

        int[] parent;
        int[] rank;
        public UnionFind(int size){
            this.parent = new int[size+1];
            this.rank =new int[size+1];

            for(int i=1;i<=size;i++){
                parent[i]=i;
                rank[i]=1;
            }
        }

        public int findParent(int node){
            if(node==parent[node]) return node;
            parent[node] =findParent(parent[node]);
            return parent[node];
        }

        public boolean unionByRank(int u,int v){
            int uUltimateParent = findParent(u);
            int vUlimateParent = findParent(v);
            if(uUltimateParent == vUlimateParent) return true;

            if(rank[uUltimateParent] > rank[vUlimateParent]){
                parent[vUlimateParent] = uUltimateParent;
            } else if (rank[vUlimateParent] > rank[uUltimateParent]) {
                parent[uUltimateParent] = vUlimateParent;
            }else {
                rank[vUlimateParent]++;
                parent[uUltimateParent] = vUlimateParent;
            }
            return false;
        }
    }


    public int[] findRedundantDirectedConnection(int[][] edges) {
      int size = edges.length;
      int firstEdgeIndex = -1;
      int seconfEdgeindex =-1;
      int[] inDegree = new int[size+1];
      Arrays.fill(inDegree,-1);

      for(int i=0;i<size;i++){
          int source = edges[i][0];
          int target = edges[i][1];

          if(inDegree[i]==-1){
              inDegree[i] = i;
          }else {
              firstEdgeIndex = inDegree[i];
              seconfEdgeindex =i;
              break;
          }
      }

      UnionFind unionFind = new UnionFind(size);

      for(int i=0;i<size;i++){

          int source = edges[i][0];
          int destination = edges[i][1];

         boolean isCyclePresent = unionFind.unionByRank(source,destination);
         if(isCyclePresent){
             if(firstEdgeIndex ==-1){
                 return new int[]{source,destination};
             }else {
                 return edges[firstEdgeIndex];
             }
         }
      }
      return edges[seconfEdgeindex];
    }
}
