package Tree;

public class PrintLeftOfBinaryTree {
    Node node;
    public static void main(String[] args) {
        PrintLeftOfBinaryTree printLeftOfBinaryTree = new PrintLeftOfBinaryTree();
        printLeftOfBinaryTree.node = new Node(10);
        printLeftOfBinaryTree.node.left = new Node(20);

        printLeftOfBinaryTree.node.left.left = new Node(40);
        printLeftOfBinaryTree.node.left.right = new Node(50);

        printLeftOfBinaryTree.node.right = new Node(30);
        printLeftOfBinaryTree.node.right.right = new Node(70);

        Node tempNode = printLeftOfBinaryTree.node;
        printLeftOfBinaryTree.PrintLeftBinaryTree(tempNode,true);
    }

    public void PrintLeftBinaryTree(Node root, boolean isLeft){

        if(root ==null) return;
        if(isLeft) System.out.println(root.data);

        PrintLeftBinaryTree(root.left,true);
        PrintLeftBinaryTree(root.right,false);
    }
}
