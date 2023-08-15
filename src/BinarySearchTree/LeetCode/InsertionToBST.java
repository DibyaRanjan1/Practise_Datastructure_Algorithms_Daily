package BinarySearchTree.LeetCode;

public class InsertionToBST {
    public static void main(String[] args) {

    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root ==null) return new TreeNode(val);

           TreeNode curr = root;
           while (curr!=null){
               if(val> curr.val){
                   if(curr.right == null){
                       curr.right = new TreeNode(val); return root;
                   }
                   curr = curr.right;
               }else {
                   if(curr.left ==null){
                       curr.left = new TreeNode(val); return root;
                   }
                   curr = curr.left;
               }
           }
           return root;
    }
}
