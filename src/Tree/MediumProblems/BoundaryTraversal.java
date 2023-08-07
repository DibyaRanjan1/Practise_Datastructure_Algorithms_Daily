package Tree.MediumProblems;

import java.util.ArrayList;
import java.util.HashSet;

public class BoundaryTraversal {
    public static void main(String[] args) {


        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(3);
        root.left.left.right = new Node(4);
        root.left.left.right.left = new Node(5);
        root.left.left.right.right = new Node(6);
        root.right = new Node(7);
        root.right.right = new Node(8);
        root.right.right.left = new Node(9);
        root.right.right.left.left = new Node(10);
        root.right.right.left.right = new Node(11);

        ArrayList < Integer > boundaryTraversal;
       BoundaryTraversal b = new BoundaryTraversal();
       b.boundary(root);
    }

    // Not working with all test cases
    ArrayList<Integer> boundary(Node node)
    {
        ArrayList<Integer> leftlst = new ArrayList<>();

       if(node ==null) return leftlst;

       leftTraverse(node,leftlst,false);

       leafeTraversal(node,leftlst);

       rightTraverse(node.right,leftlst,false);

       return leftlst;
    }
    private void leftTraverse(Node root, ArrayList<Integer> lst,boolean flag){
       if(root ==null) return ;

       if(root.left == null & root.right ==null){
           return ;
       } else if(root.left!=null){
           if(root.left ==null && root.right==null){
              return;
           }
           lst.add(root.data);
           leftTraverse(root.left,lst,flag);
       }
       else {
           if(root.left ==null && root.right==null){
               return;
           }
               lst.add(root.data);

           leftTraverse(root.right,lst,flag);
       }
       return;
    }

    private void rightTraverse(Node root, ArrayList<Integer> lst,boolean flag){
        if(root ==null) return;

        if(root.left == null & root.right ==null){
            return;
        }else if(root.right!=null){
           rightTraverse(root.right,lst,flag);
        }
        else if(root.left!=null) {
            rightTraverse(root.left,lst,flag);
        }

        if(root.left==null && root.right==null) return ;
        lst.add(root.data);
        return;
    }

    private void leafeTraversal(Node root, ArrayList<Integer> lst){

        if(root == null){
            return;
        }
        if(root.left == null && root.right ==null){
            lst.add(root.data);
            return ;
        }

        leafeTraversal(root.left,lst);
        leafeTraversal(root.right,lst);
        return;
    }

    public ArrayList<Integer> printBoundary(Node node){
        ArrayList<Integer> result = new ArrayList<>();
        if(node ==null) return result;

        if(node.left!=null && node.right!=null){
            result.add(node.data);
        }


        leftTreeWithoutLeafe(node,result);
        leafNodes(node,result);


        rightTreeWithoutLeafes(node,result);

return result;

    }

    public ArrayList<Integer> leftTreeWithoutLeafe(Node node,ArrayList<Integer> lst){
        Node curr = node.left;
        while(curr!=null)
        {
            if(curr.left!=null && curr.right!=null){
                lst.add(curr.data);
            }
            if(curr.left!=null){
                curr = curr.left;
            }else {
                curr = curr.right;
            }
        }

        return lst;
    }

    public ArrayList<Integer> leafNodes(Node node,ArrayList<Integer> lst){

       if(node.left ==null && node.right ==null){
           lst.add(node.data);
       }
       if(node == null){
           return lst;
       }
       if(node.left!=null) leafNodes(node.left,lst);

       if(node.right!=null) leafNodes(node.right,lst);
       return lst;
    }

    public ArrayList<Integer> rightTreeWithoutLeafes(Node node,ArrayList<Integer> lst){
        ArrayList<Integer> result = new ArrayList<>();

        Node current = node.right;

        while (current!=null){

            if(current.left !=null && current.right !=null){
                result.add(current.data);
            }

            if(current.right!=null){
                current = current.right;
            }
            else {
                current = current.left;
            }
        }

        for(int i=result.size()-1;i>=0; i--){
            lst.add(result.get(i));
        }
        return lst;

    }



}
