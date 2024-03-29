package Graph;

public class RedundantConnection {

    private class UnionFind{

        int[] parents;
        int[] rank;

        public UnionFind(int size){
            parents = new int[size];
            rank = new int[size];

            for(int i=0;i<=size;i++){
                parents[i]=i;
                rank[i]=1;
            }
        }

        public int findParent(int node){

            if(node==parents[node]){
                return node;
            }

           parents[node] = findParent(parents[node]);
            return parents[node];
        }

        public int[] unionByRank(int u,int v){
            int uUltimateParent = findParent(u);
            int vUlimateParent = findParent(v);

            if(uUltimateParent == vUlimateParent) return new int[] {u,v};

            if(rank[uUltimateParent]>rank[vUlimateParent]){
                parents[vUlimateParent] = uUltimateParent;
            } else if (rank[vUlimateParent] > rank[uUltimateParent]) {
                parents[uUltimateParent] =vUlimateParent;
            }
            else {
                rank[vUlimateParent]++;
                parents[uUltimateParent] =vUlimateParent;
            }

            return new int[]{0};
        }

    }

    public int[] findRedundantConnection(int[][] edges) {

        int[] ans = new int[2];
        UnionFind unionFind = new UnionFind(edges.length);
        for(int i=0;i<edges.length;i++){

           int[] temp = unionFind.unionByRank(edges[i][0],edges[i][1]);
           if(temp.length ==2){
               ans = temp;
           }
        }
        return ans;
    }
}
