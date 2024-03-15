package Revision.BackTrack.Tree;

import Tree.MediumProblems.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class ConstructTree {
    public static void main(String[] args) {

    }

    public TreeNode buildTree(int[] preOrder, int[] inorder) {

        HashMap<Integer,Integer> map  = new HashMap<>();
        for(int i=0;i< inorder.length;i++){
            map.put(inorder[i],i);
        }

        return buildTree_recur(preOrder,0,preOrder.length-1,inorder,0, inorder.length-1,map);
    }

    public TreeNode buildTree_recur(int[] preOrder, int preStartIndex, int preEndIndex, int[] inorder, int inStartIndex, int inEndIndex,HashMap<Integer,Integer> map) {


        if(preStartIndex > preEndIndex || inStartIndex >inEndIndex) return null;

        TreeNode root = new TreeNode(preOrder[preStartIndex]);
        int inOrderRootIndex = map.get(root.val);
        int numLeftIndex = inOrderRootIndex - inStartIndex;

       root.left = buildTree_recur(preOrder,preStartIndex+1, preStartIndex+numLeftIndex,inorder,inStartIndex,inOrderRootIndex-1,map);
       root.right = buildTree_recur(preOrder,preStartIndex+numLeftIndex+1,preEndIndex,inorder,inOrderRootIndex+1,inEndIndex,map);

       return root;

    }

    public TreeNode buildTreeByInOrderPostOder(int[] inorder, int[] postorder) {

        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return null;
    }

    public TreeNode buildTreeByInOrderPostOder_Recur(int[] inorder, int inStartIndex, int inEndIndex, int[] postorder, int poStartIndex, int poEndIndex,HashMap<Integer,Integer> map) {


        if(inStartIndex>inEndIndex || poStartIndex > poEndIndex) return null;

       TreeNode root = new TreeNode(postorder[poEndIndex]);
       int rootIndex = map.get(root.val);


       root.left = buildTreeByInOrderPostOder_Recur(inorder,inStartIndex,rootIndex-1,postorder,poStartIndex,rootIndex+poStartIndex-inStartIndex-1,map);
       root.right = buildTreeByInOrderPostOder_Recur(inorder,rootIndex+1,inEndIndex,postorder,rootIndex+poStartIndex-inStartIndex,poEndIndex-1,map);
       return root;
    }

    public String serialize(TreeNode root) {
        if(root ==null) return "";
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);



        StringBuilder sb = new StringBuilder();

        while (!queue.isEmpty()){

            TreeNode currentNode = queue.poll();

            if(currentNode ==null){
                sb.append("n ");
                continue;
            }
            sb.append( currentNode.val).append(" ");

            if(currentNode.left!=null){
                queue.add(currentNode.left);
            }
            if(currentNode.right!=null){
                queue.add(currentNode.right);
            }
        }

        return sb.toString();
    }

    public TreeNode deserialize(String s){

        if (s.isEmpty()) return null;

      String[] nodes =  s.split(" ");

      TreeNode root = new TreeNode(Integer.parseInt(nodes[0]) );

      Queue<TreeNode> queue = new LinkedList<>();
      queue.add(root);

      for(int i=1;i< nodes.length;i++){

          TreeNode current = queue.poll();

          if(!nodes[i].equals("n")){
            TreeNode left = new TreeNode(Integer.parseInt(nodes[i]));
            current.left = left;
             queue.add(left);
          }
          if(!nodes[++i].equals("n")){
             TreeNode right = new TreeNode(Integer.parseInt(nodes[i]));
             current.right = right;
              queue.add(right);
          }
      }

      return root;

    }
}
