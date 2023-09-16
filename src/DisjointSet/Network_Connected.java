package DisjointSet;

public class Network_Connected {
    public static void main(String[] args) {

    }

    public int makeConnected(int n, int[][] connections) {
      UnionFind unionFind = new UnionFind(n);

      int extras=0;
      for(int i=0;i<connections.length;i++){
          if(unionFind.find(connections[i][0]) == unionFind.find(connections[i][1])){
             ++ extras;
          }
          else {
              unionFind.union(connections[i][0],connections[i][1]);
          }
      }

      int numberOfDisconnectedGraph=0;

      for(int i=0;i<n;i++){

          if(unionFind.find(i)==i){
              ++numberOfDisconnectedGraph;
          }
      }
         int ans = numberOfDisconnectedGraph-1;
       if(extras>= ans) return ans;

       return -1;


    }
}
