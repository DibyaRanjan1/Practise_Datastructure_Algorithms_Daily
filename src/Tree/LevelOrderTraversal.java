package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {
    Node node;
    public static void main(String[] args) {
        LevelOrderTraversal levelOrderTraversal = new LevelOrderTraversal();

        levelOrderTraversal.node = new Node(10);
        levelOrderTraversal.node.left = new Node(20);

        levelOrderTraversal.node.left.left = new Node(40);
        levelOrderTraversal.node.left.right = new Node(50);

        levelOrderTraversal.node.right = new Node(30);
        levelOrderTraversal.node.right.right = new Node(70);

        //Node tempNode = levelOrderTraversal.node;
        //levelOrderTraversal.PrintLevelOrder(tempNode);


        //levelOrderTraversal.LevelOrderTraversalUsingQueue(levelOrderTraversal.node);

        levelOrderTraversal.LevelOrderTraversalLineByLine(levelOrderTraversal.node);
    }

    public void PrintLevelOrder(Node node){
        if(node ==null) return;
       int height = this.GetHeight(node);
        for(int i=0;i<height;i++){
            PrintNodeKDistance(node,i);
        }
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

    private  int GetHeight(Node node){
        if(node == null) return 0;
        return Math.max(GetHeight(node.left),GetHeight(node.right)) + 1;
    }

    public void LevelOrderTraversalUsingQueue(Node node){

        if(node ==null) return;
        Queue<Node> q1= new LinkedList<Node>();
        q1.add(node);

        while (!q1.isEmpty()){
          Node temp =  q1.poll();
            System.out.println(temp.data);
            if(temp.left !=null){
                q1.add(temp.left);
            }

            if(temp.right !=null){
                q1.add(temp.right);
            }
        }

    }

    public void LevelOrderTraversalLineByLine(Node node){
        if(node ==null) return;
        Queue<Node> q1 = new LinkedList<Node>();
        Queue<Node> q2 = new LinkedList<Node>();
        q1.add(node);
        boolean lineFlag = true;

        while (!q1.isEmpty() || !q2.isEmpty()){

            while(!q1.isEmpty()){
                Node temp =  q1.poll();

                System.out.println(temp.data);
                if(temp.left !=null){
                    q2.add(temp.left);
                }
                if(temp.right !=null){
                    q2.add(temp.right);
                }
            }

            System.out.println();

            while(!q2.isEmpty()){

                Node temp =  q2.poll();

                System.out.println(temp.data);
                if(temp.left !=null){
                    q1.add(temp.left);
                }
                if(temp.right !=null){
                    q1.add(temp.right);
                }
            }

            System.out.println();

        }
    }
}
