package Tree.Easy;

import Tree.MediumProblems.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    public static void main(String[] args) {

    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
      util(root,result,new StringBuilder());
      return result;
    }

    private void util(TreeNode root, List<String> result, StringBuilder s){
        if(root.left==null&&root.right==null){
            result.add(s.toString());
            return;
        }
        if(root==null) return;
        s.append(root.val);
        s.append("->");

        util(root.left,result,s);
        util(root.right,result,s);
    }
}
