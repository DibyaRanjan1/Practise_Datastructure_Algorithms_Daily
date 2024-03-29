package Tree.Easy;

import Tree.MediumProblems.TreeNode;

public class SubTreeOfAnotherTree {
    public static void main(String[] args) {

    }
    boolean isEqual = false;
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
     if(root==null) return false;
        if(root.val== subRoot.val){
            isEqual = util(root,subRoot);
        }else {
            isSubtree(root.left, subRoot);
            isSubtree(root.right, subRoot);

        }
        return isEqual;
    }

    private boolean util(TreeNode root, TreeNode subRoot){
        if(root==null && subRoot ==null) return true;
        if(root==null || subRoot==null) return false;

        if(root.val != subRoot.val) return false;

       boolean isLeftEqual = util(root.left,subRoot.left);
       if(!isLeftEqual) return false;
       boolean isRightEqual = util(root.right,subRoot.right);
       return isLeftEqual && isRightEqual;
    }
}
