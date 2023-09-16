package DisjointSet;

public class validTree {
    public static void main(String[] args) {

    }

    public boolean validTree(int n, int[][] edges) {
        UnionFindRank unionFindRank = new UnionFindRank(n);

         boolean result=false;
        for (int i=0;i< edges.length;i++){
           result =  unionFindRank.unionByRank(edges[i][0],edges[i][1]);
           if(!result) return false;
        }
        if(unionFindRank.count!=1) return false;
        return true;
    }
}

class  UnionFindRank{

    public int[] root;
    public int[] rank;

    int count;

    public boolean isValidTree;

    public UnionFindRank(int size){
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
