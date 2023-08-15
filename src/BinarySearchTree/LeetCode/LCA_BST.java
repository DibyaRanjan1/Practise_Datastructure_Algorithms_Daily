package BinarySearchTree.LeetCode;

public class LCA_BST {
    public static void main(String[] args) {

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

      if(root==null) return null;

      if(p.val > root.val && q.val > root.val){
         return lowestCommonAncestor(root.right,p,q);
      } else if (p.val < root.val && q.val < root.val) {
         return lowestCommonAncestor(root.left,p,q);
      }
        return root;
    }
}
