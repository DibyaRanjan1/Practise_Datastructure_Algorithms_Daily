package DisjointSet;

public class Graph {
    int V,E;
    Edge edge[];

    class Edge{
        int src, dest;
    }

    public Graph(int v, int e){
        V = v;
        E = e;
        edge = new Edge[e];
        for(int i=0; i<e;i++){
            edge[i] = new Edge();
        }
    }

    int find(int parent[],int i){
        if(parent[i]==-1){
            return i;
        }
       return find(parent,parent[i]);
    }

    void union(int parent[],int x,int y){

        int xset = find(parent,x);
        int yset = find(parent,y);

        parent[xset] = yset;

    }

    int isCycle(Graph graph){
        int parent[] = new int[graph.V];

        for(int i=0;i< graph.V;i++){
            parent[i] = -1;
        }

        for(int i=0;i< graph.E;i++){
            int x = find(parent,graph.edge[i].src);
            int y = find(parent,graph.edge[i].dest);

            if(x ==y) return 1;

         graph.union(parent,x,y);

        }

        return 0;
    }

    public static void main(String[] args) {
        int V =3, E =3;
        Graph graph = new Graph(V,E);

        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;

        graph.edge[1].src = 1;
        graph.edge[1].dest = 2;

        graph.edge[2].src = 0;
        graph.edge[2].dest = 2;

        int result = graph.isCycle(graph);

        System.out.println(result);
    }

}
