package DisjointSet;

public class NumberOfConnectedComponent {
    public static void main(String[] args) {


    }

    public int countComponents(int n, int[][] edges) {
        UnionFindRank1 u = new UnionFindRank1(n);

        for(int i=0;i<edges.length;i++){
            u.unionByRank(edges[i][0],edges[i][1]);
        }
        return u.count;
    }
}

class  UnionFindRank1{

    public int[] root;
    public int[] rank;

    int count;

    public boolean isValidTree;

    public UnionFindRank1(int size){
        count = size;
        this.root = new int[size];
        this.rank = new int[size];
        for (int i=0;i<size;i++){
            root[i]=i;
            rank[i]=1;
        }
    }

    public boolean isConnected(int x,int y){
        return find(x)==find(y);
    }

    public int find(int x){
        if(x == root[x]) return x;
        return root[x] = find(root[x]);
    }

    public boolean unionByRank(int x,int y){
        int rootx = find(x);
        int rooty = find(y);

        if(rootx !=rooty){

            if(rank[rootx]>rank[rooty]){
                root[rooty] = rootx;
            }else if(rank[rooty]>rank[rootx]){
                root[rootx] = rooty;
            }else {
                root[rooty] = rootx;
                rank[rootx] = rank[rootx]+1;
            }
            --count;
            return true;
        }else {
            return false;
        }
    }
}
