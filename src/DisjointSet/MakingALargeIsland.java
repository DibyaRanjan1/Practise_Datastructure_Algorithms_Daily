package DisjointSet;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class MakingALargeIsland {
    public static void main(String[] args) {

    }

    class DisjointSet{

        List<Integer> parent;
        List<Integer> size;
        public DisjointSet(int n){
            this.parent = new ArrayList<>();
            this.size = new ArrayList<>();

            for(int i=0;i<=n;i++){
                parent.add(i);
                size.add(1);
            }
        }

        public int findUParent(int node){
            if(node == parent.get(node)){
                return node;
            }

          int ultimateParent =   findUParent(parent.get(node));
            parent.set(node,ultimateParent);
            return parent.get(node);
        }

        public void unionBySize(int u,int v){
            int parentU = findUParent(u);
            int parentV = findUParent(v);

            if(parentU ==parentV) return;

            int uSize = size.get(parentU);
            int vSize = size.get(parentV);

            if(uSize < vSize){
                parent.set(parentU,parentV);
                size.set(parentV,size.get(parentU) + size.get(parentV));
            } else {
                parent.set(parentV,parentU);
                size.set(parentU,size.get(parentU) + size.get(parentV));
            }

        }
    }

    public int largestIsland(int[][] grid) {
     int n = grid.length;
      DisjointSet disjointSet = new DisjointSet(n*n);
        int[] rowCordinates = new int[]{1,0,-1,0};
        int[] colCordinates = new int[]{0,1,0,-1};

      for(int row=0;row<n;row++){
          for(int col=0;col<n;col++){
              if(grid[row][col]==0) continue;

            for(int corinates=0;corinates<4;corinates++){

                int newRow = rowCordinates[corinates] + row;
                int newCol = colCordinates[corinates] + col;

                if(newRow <0 || newRow >=n || newCol <0 || newCol >=n) continue;
                if(grid[newRow][newCol]==1){
                    int node = row * n + col;
                    int newNode = newRow *n + newCol;

                    disjointSet.unionBySize(node,newNode);
                }
            }

          }
      }

      int mx=0;

        for(int row=0;row<n;row++){
            for(int col=0;col<n;col++){

                if(grid[row][col]==1) continue;
                HashSet<Integer> components = new HashSet<>();
                for(int corinates=0;corinates<4;corinates++){

                    int newRow = rowCordinates[corinates] + row;
                    int newCol = colCordinates[corinates] + col;

                    if(newRow <0 || newRow >=n || newCol <0 || newCol >=n) continue;


                    if(grid[newRow][newCol]==1){
                       components.add(disjointSet.findUParent(newRow*n+newCol));
                    }

                }
                int sizeTotal=0;
                for(Integer parents:components){
                    sizeTotal += disjointSet.size.get(parents);
                }
                mx = Math.max(mx,sizeTotal+1);
            }
        }

        for(int i=0;i<n*n;i++){
            mx = Math.max(mx,disjointSet.size.get(disjointSet.findUParent(i)));
        }

     return mx;

    }
}
