package DisjointSet;

import java.util.Arrays;

public class EarliestMoment_Friend {
    public static void main(String[] args) {

    }

    public int earliestAcq(int[][] logs, int n) {

        UnionFindRank2 u = new UnionFindRank2(n);
        Arrays.sort(logs,(x,y) -> x[0]-y[0]);

        for(int i=0;i< logs.length;i++){
            u.unionByRank(logs[i][1],logs[i][2]);
            if(u.count == n-1) return logs[i][0];
        }
        return -1;
    }
}

class  UnionFindRank2{

    public int[] root;
    public int[] rank;

    int count;

    public boolean isValidTree;

    public UnionFindRank2(int size){
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



