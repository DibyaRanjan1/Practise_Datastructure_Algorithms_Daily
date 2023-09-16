package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Dj_Pair{
    public int node;
    public int weight;
}
public class Dijsktras_Algorithm {
    public static void main(String[] args) {
        int V = 3, E=3,S=2;
        ArrayList<Integer> node1 = new ArrayList<Integer>() {{add(1);add(1);}};
        ArrayList<Integer> node2 = new ArrayList<Integer>() {{add(2);add(6);}};
        ArrayList<Integer> node3 = new ArrayList<Integer>() {{add(2);add(3);}};
        ArrayList<Integer> node4 = new ArrayList<Integer>() {{add(0);add(1);}};
        ArrayList<Integer> node5 = new ArrayList<Integer>() {{add(1);add(3);}};
        ArrayList<Integer> node6 = new ArrayList<Integer>() {{add(0);add(6);}};

        ArrayList<ArrayList<Integer>> inter1 = new ArrayList<ArrayList<Integer>>(){
            {
                add(node1);
                add(node2);
            }
        };
        ArrayList<ArrayList<Integer>> inter2 = new ArrayList<ArrayList<Integer>>(){
            {
                add(node3);
                add(node4);
            }
        };
        ArrayList<ArrayList<Integer>> inter3 = new ArrayList<ArrayList<Integer>>(){
            {
                add(node5);
                add(node6);
            }
        };
        ArrayList<ArrayList<ArrayList<Integer>>> adj= new ArrayList<ArrayList<ArrayList<Integer>>>(){
            {
                add(inter1); // for 1st node
                add(inter2); // for 2nd node
                add(inter3); // for 3rd node
            }
        };

      dijkstra(3,adj,2);

    }

    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        PriorityQueue<Dj_Pair> pq = new PriorityQueue<Dj_Pair>((x,y) -> x.weight- y.weight);
        int[] distance = new int[V];

        Arrays.fill(distance,(int)(1e9));

        distance[S] = 0;
        Dj_Pair srcPair = new Dj_Pair();
        srcPair.weight = 0;
        srcPair.node = S;

        pq.add(srcPair);

        while (!pq.isEmpty()){
           Dj_Pair minNode =  pq.poll();

           for(ArrayList<Integer> it:adj.get(minNode.node)){
               if(distance[minNode.node] + it.get(1) < distance[it.get(0)]){
                   distance[it.get(0)] = distance[minNode.node] + it.get(1);

                   Dj_Pair newEle = new Dj_Pair();
                   newEle.node = it.get(0);
                   newEle.weight = distance[it.get(0)];
                   pq.add(newEle);
               }
           }
        }
        return distance;
    }
}
