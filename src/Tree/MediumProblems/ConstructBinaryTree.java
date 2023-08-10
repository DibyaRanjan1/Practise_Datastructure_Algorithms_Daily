package Tree.MediumProblems;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTree {
    public static void main(String[] args) {
        int preorder[] = {10,20,40,50,30,60};
        int inorder[] = {40,20,50,10,60,30};
        int postOrder[] = {40,50,20,60,30,10};

      //Node root =  constructBinaryTree(inorder,preorder);
        Node root = constructBinarybyPostOrder(inorder,postOrder);

    }

    public static Node constructBinarybyPostOrder(int[] inorder,int[] postorder){
        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return utilPostOrder(inorder,0,inorder.length-1,postorder,0,postorder.length-1,map);

    }

    private static Node utilPostOrder(int[] inorder, int inorderStartIndex, int inorderEndIndex,int[] postOrder,int postorderStartIndex,int postOrderEndIndex,Map<Integer,Integer> map){
        if(inorderStartIndex > inorderEndIndex || postorderStartIndex > postOrderEndIndex){
            return null;
        }


        Node root = new Node(postOrder[postOrderEndIndex]);
        int rightValueIndex = map.get(root.data);

        root.left = utilPostOrder(inorder,inorderStartIndex,rightValueIndex-1,postOrder,postorderStartIndex,rightValueIndex+postorderStartIndex-inorderStartIndex-1,map);
        root.right = utilPostOrder(inorder,rightValueIndex+1,inorderEndIndex,postOrder,postorderStartIndex+rightValueIndex-inorderStartIndex,postOrderEndIndex-1,map);
        return root;
    }

    public static Node constructBinaryTree(int[] inorder,int[] preOrder){



        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }

      return   util(inorder,0,inorder.length,preOrder,0,preOrder.length-1,map);


    }

    private static Node util(int[] inorder,int inordersStart,int inorderEnd,int[] preOrder,int preOrderStart,int preOrderEnd,Map<Integer,Integer> map){

         if(inordersStart > inorderEnd || preOrderStart > preOrderEnd){
             return null;
         }

         Node root = new Node(preOrder[preOrderStart]);
         int rootIndex= map.get(root.data);
         int numsLeftIndex = rootIndex - inordersStart;

        root.left = util(inorder,inordersStart,rootIndex-1,preOrder,preOrderStart+1,preOrderStart+numsLeftIndex,map);
        root.right = util(inorder,rootIndex+1,inorderEnd,preOrder,preOrderStart+numsLeftIndex+1,preOrderEnd,map);

        return root;

    }
}
