package Tree.MediumProblems;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRight {
    public static void main(String[] args) {

        PopulatingNextRight p = new PopulatingNextRight();
        Node root =new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.right = new Node(7);
        //p.connect(root);

        p.connect_iterative(root);
    }

    public Node connect(Node root) {

        if(root ==null) return root;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            int size = queue.size();


            for(int i=0;i<size;i++){

                Node curr = queue.poll();

                if(i < size-1){
                    curr.next = queue.peek();
                }

                if(curr.left!=null){
                    queue.offer(curr.left);
                }
                if(curr.right!=null){
                    queue.offer(curr.right);

                }
            }


        }
        return root;
    }

    public Node connect_iterative(Node root) {

        Node dummy = new Node();
        Node t = root;

        while (t!=null){
            Node current = dummy;
            while (t!=null){
                if(t.left!=null){
                     current.next = t.left;
                     current = current.next;
                }
                if(t.right!=null){
                    current.next = t.right;
                    current = current.next;
                }
                t = t.next;
            }
            t = dummy.next;
            dummy.next = null;
        }
        return root;
    }
}
