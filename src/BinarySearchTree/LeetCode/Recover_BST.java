package BinarySearchTree.LeetCode;

public class Recover_BST {

    TreeNode first;
    TreeNode second;
    TreeNode third;
    TreeNode prev;
    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(2);

        Recover_BST r = new Recover_BST();
        r.recoverTree(root);

    }

    public void recoverTree(TreeNode root) {
        first = second = third = null;
        prev = new TreeNode(Integer.MIN_VALUE);

        inorder(root);
        if(third == null){
            int temp = 0;
            temp = first.val;
            first.val = second.val;
            second.val = temp;
        }else {
            int temp = 0;
            temp = first.val;
            first.val = third.val;
            third.val = temp;
        }

    }

    private void inorder(TreeNode root){

        if(root==null) return;

        inorder(root.left);

        if(prev!=null && root.val < prev.val){
            if(first==null) {
                first = prev;
                second = root;
            }else {
                third = root;
            }
        }

        prev = root;

        inorder(root.right);
    }
}
