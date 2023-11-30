package Tree.MediumProblems;

import java.util.LinkedList;
import java.util.List;

public class UniqueBST_II {
    public static void main(String[] args) {
       UniqueBST_II u = new UniqueBST_II();
     List<TreeNode> res =  u.generateTrees(3);
    }

    public List<TreeNode> generateTrees(int n) {
         return generateTrees_util(1,n);
    }

    private List<TreeNode> generateTrees_util(int start,int end){

        List<TreeNode> result = new LinkedList<>();
        if(start>end){
            result.add(null);
            return result;
        }

      for(int index=start;index<=end;index++){
          List<TreeNode> leftSubTree = generateTrees_util(start,index-1);
          List<TreeNode> rightSubTree = generateTrees_util(index+1,end);

          for(TreeNode left: leftSubTree){
              for(TreeNode right: rightSubTree){

                  TreeNode root = new TreeNode(index);
                  root.left = left;
                  root.right = right;
                  result.add(root);
              }
          }
      }
      return result;
    }


}
