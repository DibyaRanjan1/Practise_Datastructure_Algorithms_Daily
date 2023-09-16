package DisjointSet;

public class UnionFind {

    private int[] root;
    private int[] rank;
    public UnionFind(int size){
        this.root = new int[size];
        this.rank = new int[size];
       for(int i=0;i<size;i++){
           root[i] = i;
           rank[i] = 1;
       }
    }

    public boolean isConnected(int x,int y){
     return root[x]==root[y];
    }

    public int find(int x){
       if(x == root[x]) return x;

      return root[x] = find(root[x]);
    }

    public void union(int x,int y){

        int rootx = find(x);
        int rooty = find(y);

        if(rootx!=rooty){

            if(rank[rootx] > rank[rooty]){
               root[rooty] = rootx;
            }else if(rank[rooty] > rank[rootx]){
                root[rootx] = rooty;
            }else {
                root[rooty] = rootx;
                rank[rootx] = rank[rootx]+1;
            }

        }
    }
}
