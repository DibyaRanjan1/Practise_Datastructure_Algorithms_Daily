package Tree.MediumProblems;

import java.util.ArrayList;
import java.util.Stack;

public class PrintRoot_To_Node {
    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(6);
        root.left.right.right = new Node(7);
        root.right = new Node(3);

        PrintRoot_To_Node printRootToNode = new PrintRoot_To_Node();
        printRootToNode.getAll(root,7);
    }

    public ArrayList<Integer> getAll(Node root,int data){

        Stack<Integer> s1 = new Stack<>();
         print(root,data,s1);
         ArrayList<Integer> lst = new ArrayList<>();

         while (!s1.isEmpty()){
             lst.add(s1.pop());
         }

         return lst;
    }

    public boolean print(Node root, int data, Stack<Integer> lst){

        if(root == null) return false;

        if(root.data == data){
         lst.push(data);
            return true;
        }

       boolean leftResult = print(root.left,data,lst);

        if(leftResult) lst.push(root.data);
       boolean rightResult = print(root.right,data,lst);
        if(rightResult) lst.push(root.data);
        if(leftResult  || rightResult) return true;
        return false;
    }
}
