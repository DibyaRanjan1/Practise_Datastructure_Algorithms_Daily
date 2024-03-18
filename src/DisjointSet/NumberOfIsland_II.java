package DisjointSet;

import java.util.ArrayList;
import java.util.List;

public class NumberOfIsland_II {

    class DisJointSet{
        List<Integer> rank;
        List<Integer> size;

        List<Integer> parent;


        public DisJointSet(int n){

            for(int i=0;i<=n;i++){
                rank.add(1);
                size.add(1);
                parent.add(i);
            }
        }

        public int findUParent(int node){
            if(node == parent.get(node)){
                return node;
            }

          int uParent =  findUParent(parent.get(node));
            parent.set(node,uParent);
            return parent.get(node);
        }

        public void unionByRank(int u, int v){
            int pu = findUParent(u);
            int pv = findUParent(v);

            if(pu ==pv) return;
            int rankU = rank.get(pu);
            int rankV = rank.get(pv);

            if(rankU < rankV){
                parent.set(pu,pv);
            } else if (rankV < rankU) {
                parent.set(pv,pu);
            }else {
                parent.set(pv,pu);
              int currentRank =  rank.get(pu);
              rank.set(pu,currentRank+1);
            }
        }

    }
    public static void main(String[] args) {

    }

    public List<Integer> numIslands2(int m, int n, int[][] positions) {

        DisJointSet disJointSet = new DisJointSet(m*n);
        int[][] visited = new int[m][n];
        int count=0;
        List<Integer> result = new ArrayList<>();
        int len = positions.length;

        for(int i=0;i<len;i++){
            int currentRow = positions[i][0];
            int currentCol = positions[i][1];

            if(visited[currentRow][currentCol]==1){
                result.add(count);
                continue;
            }

            visited[currentRow][currentCol] =1;
            count++;

            int[] rowCordinates = new int[]{1,0,-1,0};
            int[] colCordinates = new int[]{0,1,0,-1};

            for(int j=0;j<4;j++){
                int newRow = currentRow + rowCordinates[j];
                int newCol = currentCol  + colCordinates[j];

                if(newRow < 0|| newRow >=m || newCol <0 || newCol >=n) continue;

                if(visited[newRow][newCol] ==1){
                    int nodeNumber = currentRow * n + currentCol;
                    int adjNodeNumber = newRow * n + newCol;

                    if(disJointSet.findUParent(nodeNumber) != disJointSet.findUParent(adjNodeNumber)){
                     --count;
                      disJointSet.unionByRank(nodeNumber,adjNodeNumber);
                    }
                }
            }
            result.add(count);
        }
        return result;
    }
}
