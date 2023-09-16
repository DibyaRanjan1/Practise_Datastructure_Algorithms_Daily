package DisjointSet;

import java.util.HashMap;
import java.util.Map;

public class Remove_Stones {
    public static void main(String[] args) {

    }

    public int removeStones(int[][] stones) {
        int maxRow=0;
        int maxCol=0;

          for(int i=0;i<stones.length;i++){
              maxRow = Math.max(maxRow,stones[i][0]);
              maxCol = Math.max(maxCol,stones[i][1]);
          }

          UnionFind unionFind = new UnionFind(maxRow+maxCol+1);
        HashMap<Integer,Integer> stoneNodes = new HashMap<>();
          for (int i=0;i< stones.length;i++){
              int row = stones[i][0];
              int col  = maxRow + stones[i][1];

              unionFind.union(row,col);
              stoneNodes.put(row,1);
              stoneNodes.put(col,1);
          }
           int cnt=0;
          for(Map.Entry<Integer,Integer> it:stoneNodes.entrySet()){
               if(unionFind.find(it.getKey()) == it.getKey()){
                   cnt++;
               }
          }
          return stones.length - cnt;
    }
}
