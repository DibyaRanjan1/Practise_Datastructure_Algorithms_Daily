package Revision.BackTrack;

import java.util.ArrayList;

public class MColoring {

    class Pair{

        public Pair(int row, int col, int color){
            this.row = row;
            this.col = col;
            this.color =  color;
        }

        int row;
        int col;
        int color;
    }
    public static void main(String[] args) {

    }

    public boolean graphColoring(boolean graph[][], int m, int n) {

      int rows = graph.length;
      int cols = graph[0].length;

      ArrayList<ArrayList<Pair>> adjGraph = new ArrayList<>();

      for(int i=0;i< rows;i++){
          adjGraph.add(new ArrayList<Pair>());
      }

      for(int i=0;i<rows;i++){
          for(int j=0;j<cols;j++){
              if(graph[i][j]){
                  adjGraph.get(i).add(new Pair(i,j,-1));
              }
          }
      }


     return backTrack(adjGraph,0,m,new int[n]);
    }

    private boolean backTrack(ArrayList<ArrayList<Pair>> adjGraph, int node, int colorLength, int[] colorArray){

        if(node == adjGraph.size()) return true;

        for(int color=1;color<= colorLength;color++){

            if(isSafe(adjGraph,node,color,colorArray)){

                colorArray[node] = color;
                if(backTrack(adjGraph,node+1,colorLength,colorArray)) return true;
                else {
                    colorArray[node] = 0;
                }

            }
        }
        return false;

    }

    private boolean isSafe(ArrayList<ArrayList<Pair>> adjGraph, int node, int currentColor, int[] color){

        for(Pair pair: adjGraph.get(node)){
            if(pair.color == currentColor || color[pair.row] == currentColor) return false;
        }
        return true;
    }
}
