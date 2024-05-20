package Graph.Easy;

public class FindTownJudge {
    public static void main(String[] args) {

    }

    public int findJudge(int n, int[][] trust) {

       if(trust.length < n-1) return -1;

        int[] indegree = new int[n+1];
        int[] outdegree = new int[n+1];

       for(int[] it:trust){
           outdegree[it[0]]++;
           indegree[it[1]]++;
       }
       for(int i=1;i<=n;i++){
           if(indegree[i] == n-1 && outdegree[i]==0){
               return i;
           }

       }
        return -1;
    }
}
