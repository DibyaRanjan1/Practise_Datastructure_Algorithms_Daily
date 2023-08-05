package Graph;

import java.util.ArrayList;

public class BipartiteGraph {

    public static void main(String[] args) {
        ArrayList < ArrayList < Integer >> adj = new ArrayList < > ();
        for (int i = 0; i < 4; i++) {
            adj.add(new ArrayList < > ());
        }
        adj.get(0).add(2);
        adj.get(2).add(0);
        adj.get(0).add(3);
        adj.get(3).add(0);
        adj.get(1).add(3);
        adj.get(3).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);



        BipartiteGraph b = new BipartiteGraph();
        b.isBipartite(4,adj);
    }

    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        if(adj ==null) return true;

        long[] color = new long[adj.size()];
        for(int i=0;i<adj.size();i++){
            color[i] = -1;
        }
        for(int i=0;i< adj.size();i++){
            if(color[i] == -1){
             boolean result =   dfs(adj,color,0,1);
             if(!result) return false;
            }
        }
        return true;
    }

    private boolean dfs(ArrayList<ArrayList<Integer>> adj,long[] color,int source,int currentColor){
            color[source] = currentColor;
       for(int i=0;i<adj.get(source).size();i++){

           if(color[adj.get(source).get(i)] ==-1){
               int tempColor;
               if(currentColor ==1){
                   tempColor = 0;
               }else{
                   tempColor = 1;
               }
             boolean result =  dfs(adj,color,adj.get(source).get(i),tempColor);
               if(!result) return false;


           }else {
             if(currentColor==color[adj.get(source).get(i)]){
                 return false;
             }

           }
       }
return true;
    }
}
