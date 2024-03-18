package Tree.MediumProblems;

import java.util.*;

public class DeletNodesReturnForest {
    public static void main(String[] args) {
      TreeNode root = new TreeNode(1);
      root.left = new TreeNode(2);
      root.right = new TreeNode(3);

      root.left.left = new TreeNode(4);
      root.left.right = new TreeNode(5);

      root.right.left = new TreeNode(6);
      root.right.right = new TreeNode(7);

      DeletNodesReturnForest f = new DeletNodesReturnForest();
      f.delNodes(root,new int[]{3,5});
    }

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {

        Set<Integer> sets = new HashSet<>();
        for(int i=0;i<to_delete.length;i++){
            sets.add(to_delete[i]);
        }
        List<TreeNode> result = new ArrayList<>();

       delnodes_util(root,sets,result);

       if(!sets.contains(root.val)){
           result.add(root);
       }
      return result;
    }

    private TreeNode delnodes_util(TreeNode node, Set<Integer> sets, List<TreeNode> result){

        if(node ==null) return null;

      node.left = delnodes_util(node.left,sets,result);
      node.right = delnodes_util(node.right,sets,result);

      if(sets.contains(node.val)){
          if(node.left!=null){
              result.add(node.left);
          }
          if(node.right!=null){
              result.add(node.right);
          }
          return null;
      }
      return node;
    }
}
