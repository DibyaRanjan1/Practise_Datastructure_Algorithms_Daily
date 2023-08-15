package BinarySearchTree.LeetCode;

import java.math.BigInteger;

public class CheckBST {
    public static void main(String[] args) {

    }

    public boolean isValidBST(TreeNode root) {
        long min = Long.MIN_VALUE;
        long max = Long.MAX_VALUE;

        return util(root,min,max);

    }

    private boolean util(TreeNode root,long min,long max){
        if(root ==null) return true;

        if(!(root.val > min && root.val < max)){
            return false;
        }
      return util(root.left,min,root.val) && util(root.right, root.val, max);
    }

    }
