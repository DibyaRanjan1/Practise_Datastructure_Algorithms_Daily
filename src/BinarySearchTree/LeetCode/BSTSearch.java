package BinarySearchTree.LeetCode;

import com.sun.source.tree.Tree;

public class BSTSearch {
    public static void main(String[] args) {

    }

    public TreeNode searchBSTRec(TreeNode root, int val) {
        if (root == null) return null;

        if(root.val == val) return root;

        if(val > root.val) return searchBST(root.right,val);
        if(val < root.val)return searchBST(root.left,val);
        return root;
    }

    public TreeNode searchBST(TreeNode root, int val){

        while (root!=null && root.val!=val){
            root = val> root.val?root.right:root.left;
        }
        return root;
    }

    public int findMin(TreeNode root){

        if(root == null) return -1;
        if(root.left == null) return root.val;

        while (root.left!=null){
            root = root.left;
        }
        return root.val;
    }

    public int findCeil(TreeNode root,int key){
        int ceil = -1;
        while (root!=null){

            if(key> root.val){
                root = root.right;
            } else if (key < root.val){
                ceil = root.val;
                root = root.left;
            }else {
                ceil = root.val;
            }
        }
        return ceil;
    }

    public int findFloor(TreeNode root,int key){
        int floor = -1;
        while (root!=null){
            if(key == root.val){
                return root.val;
            }
            if(key > root.val){
                floor = root.val;
                root = root.right;
            }else {
                root = root.left;
            }
        }

        return floor;
    }
}
