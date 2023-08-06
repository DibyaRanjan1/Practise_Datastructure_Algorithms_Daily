import Tree.SymetryCheck.TreeNode;

public class Solution {


    public  void main(String[] args) {



        TreeNode root = new TreeNode(1,null,null);

        root.left = new TreeNode(2,null,null);
        root.left.left = new TreeNode(3,null,null);
        root.left.right = new TreeNode(4,null,null);

        root.right = new TreeNode(2,null,null);
        root.right.left = new TreeNode(4,null,null);
        root.right.right = new TreeNode(3,null,null);



    }

    public  boolean isSymmetric(TreeNode root) {

        TreeNode rootLeft = root.left;
        TreeNode rootRight = root.right;

      return isSymmetricUtil(rootLeft,rootRight);
    }

    private boolean isSymmetricUtil( TreeNode root1, TreeNode root2){

        if(root1 ==null || root2 ==null){
            return root1 ==root2;
        }

        return (root1.val == root2.val && isSymmetricUtil(root1.left,root2.right) && isSymmetricUtil(root1.right,root2.left));

    }


}
