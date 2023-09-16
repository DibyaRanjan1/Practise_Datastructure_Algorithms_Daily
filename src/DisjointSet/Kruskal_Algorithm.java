package DisjointSet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Edges implements Comparable<Edges>{
    int src;
    int dest;
    int weight;

   public Edges(int src,int dest,int weight){
       this.src = src;
       this.dest = dest;
       this.weight = weight;
   }
    @Override
    public int compareTo(Edges edges) {
        return this.weight - edges.weight;
    }
}
public class Kruskal_Algorithm {
    public static void main(String[] args) {

    }

    static int spanningTree(int V, int E, int edges[][]){

        List<Edges> edgeLst = new ArrayList<Edges>();
        int sum=0;

        for(int i=0;i< edges.length;i++){

                edgeLst.add(new Edges(edges[i][0],edges[i][1], edges[i][2]));
        }

        Collections.sort(edgeLst);

        UnionFind unionFind = new UnionFind(V);
        for(Edges edge:edgeLst){
           int src = edge.src;
           int dest = edge.dest;;
           int weight = edge.weight;

           if(!unionFind.isConnected(src,dest)){
               sum+= weight;
               unionFind.union(src,dest);
           }

        }
        return sum;


    }
}
