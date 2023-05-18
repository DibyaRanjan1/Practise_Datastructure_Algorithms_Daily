package Tree;

public class PrintNodeKDistance {
    Node node;
    public static void main(String[] args) {
        PrintNodeKDistance printNodeKDistance = new PrintNodeKDistance();
        printNodeKDistance.node = new Node(10);
        printNodeKDistance.node.left = new Node(20);

        printNodeKDistance.node.left.left = new Node(40);
        printNodeKDistance.node.left.right = new Node(50);

        printNodeKDistance.node.right = new Node(30);
        printNodeKDistance.node.right.right = new Node(70);

        Node tempNode = printNodeKDistance.node;
        printNodeKDistance.PrintNodeKDistance(tempNode,2);
    }

    public void PrintNodeKDistance(Node node, int k){
        if(node == null) return;

        if(k == 0){
            System.out.println(node.data);
        } else {
            PrintNodeKDistance(node.left,k-1);
            PrintNodeKDistance(node.right,k-1);
        }


    }
}
