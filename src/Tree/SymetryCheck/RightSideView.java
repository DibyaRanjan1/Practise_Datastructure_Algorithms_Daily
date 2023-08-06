package Tree.SymetryCheck;

import Tree.SymetryCheck.TreeNode;
import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class RightSideView {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(1,null,null);

        root.left = new TreeNode(2,null,null);
        root.left.left = new TreeNode(3,null,null);
        root.left.right = new TreeNode(4,null,null);

        root.right = new TreeNode(2,null,null);
        root.right.left = new TreeNode(4,null,null);
        root.right.right = new TreeNode(3,null,null);

         RightSideView v = new RightSideView();
         v.rightSideView(root);
    }

    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> lst = new ArrayList<>();
        if(root ==null) return lst;

        rightViewUtil(root,lst,0);



        return lst;
    }

    private void rightViewUtil(TreeNode rootRight,List<Integer> integers,int level){
        if(rootRight == null) return;

        if(integers.size() == level) integers.add(rootRight.val);

        rightViewUtil(rootRight.right,integers,level+1);
        rightViewUtil(rootRight.left,integers,level+1);
    }


}
