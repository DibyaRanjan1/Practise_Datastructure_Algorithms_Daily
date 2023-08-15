package BinarySearchTree.LeetCode;

public class DeletionBST {
    public static void main(String[] args) {

    }

    public TreeNode deleteNode(TreeNode root, int key) {

        if(root==null) return null;

        if(root.val ==key){
            return deletionHelper(root);
        }

        TreeNode dummy = root;

        while (root!=null){
            if(key > root.val){
                if(root.right!=null && root.right.val ==key){
                    root.right = deletionHelper(root.right);
                    break;
                }else {
                    root = root.right;
                }
            }

            if(key < root.val){
                if(root.left!=null && root.left.val == key){
                    root.left = deletionHelper(root.left);
                    break;
                }
                else {
                    root = root.left;
                }
            }
        }
        return dummy;

    }

    private TreeNode findRightMostNode(TreeNode node){
        if(node.right==null) return node;
       return findRightMostNode(node.right);
    }

    private TreeNode deletionHelper(TreeNode node){
        if(node.left==null) return node.right;
        else if (node.right==null) return node.left;
        else {
            TreeNode tempRightNode = node.right;

            TreeNode rightMostNode = findRightMostNode(node.left);
            rightMostNode.right = tempRightNode;
            return node.left;
        }
    }

}

