package Graph;

public class NumberOfProvinance {
    public static void main(String[] args) {
       int[][] isConnected =new int[3][3];
       isConnected[0][0] = 1;
        isConnected[0][1] = 1;
        isConnected[0][2] = 0;

        isConnected[1][0] = 1;
        isConnected[1][1] = 1;
        isConnected[1][2] = 0;

        isConnected[2][0] = 0;
        isConnected[2][1] = 0;
        isConnected[2][2] = 1;

    int result = findCircleNum(isConnected);
    }

    public static int findCircleNum(int[][] isConnected) {
      boolean[] visited = new boolean[isConnected.length];
      int result = 0;
      for(int i=0;i<isConnected.length;i++){
          if(!visited[i]){
              ++result;
              dfsutil(visited,isConnected,i);
          }
      }
      return result;

    }

    private static void dfsutil(boolean[] visited,int[][] isConnected,int source){

        for(int i=0;i<isConnected.length;i++){
            if(isConnected[source][i] ==1 && !visited[i]){
                visited[source] = true;
                dfsutil(visited,isConnected,i);
            }
        }

    }
}
