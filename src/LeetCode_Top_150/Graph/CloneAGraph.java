package LeetCode_Top_150.Graph;

import java.util.*;

public class CloneAGraph {

    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public static void main(String[] args) {
       CloneAGraph c = new CloneAGraph();

    }

    private HashMap<Node,Node> visited = new HashMap<>();

    public Node cloneGraph(Node node) {

        if(node ==null) return node;

        if(visited.containsKey(node)){
            return visited.get(node);
        }

        Node clonedGraph = new Node(node.val,new ArrayList<>());
        visited.put(node,clonedGraph);

        for(Node neigbour:node.neighbors){

            Node oldnode = cloneGraph(neigbour);
            clonedGraph.neighbors.add(oldnode);
        }

        return clonedGraph;
    }

    public Node cloneGraph_bfs(Node node) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

       visited.put(node,new Node(node.val,new ArrayList<>()));

       while (!queue.isEmpty()){



           Node currNode = queue.poll();


           for(Node neigbour: currNode.neighbors){

               if(!visited.containsKey(neigbour)){
                   visited.put(neigbour,new Node(neigbour.val,new ArrayList<>()));
                   queue.add(neigbour);
               }


               visited.get(currNode).neighbors.add(new Node(neigbour.val));
           }

       }

       return visited.get(node);
    }


}
