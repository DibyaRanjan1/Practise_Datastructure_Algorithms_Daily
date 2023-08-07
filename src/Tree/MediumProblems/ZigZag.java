package Tree.MediumProblems;

import java.util.ArrayList;
import java.util.Stack;

public class ZigZag {
    public static void main(String[] args) {

    }

    ArrayList<Integer> zigZagTraversal(Node root)
    {
        ArrayList<Integer> integers = new ArrayList<>();

        if(root ==null) return integers;

        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();

        s1.push(root);

        while(!s1.isEmpty() || !s2.isEmpty()){

            while(!s1.isEmpty()){
                Node node = s1.pop();
                integers.add(node.data);

                if(node.left!=null) s2.add(node.left);
                if(node.right!=null) s2.add(node.right);
            }

            while (!s2.isEmpty()){
                Node s2Node = s2.pop();
                integers.add(s2Node.data);

                if(s2Node.right!=null) s1.add(s2Node.right);
                if(s2Node.left!=null) s1.add(s2Node.left);
            }
        }

        return integers;
    }
}
