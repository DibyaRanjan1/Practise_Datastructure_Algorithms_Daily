package BinarySearchTree.LeetCode;

import java.util.HashSet;
import java.util.Set;

public class Two_Sum {
    public static void main(String[] args) {



    }

    // Not optimized
    public boolean findTarget1(TreeNode root, int k) {
        if(root==null) return false;
      return util(root,k,new HashSet<Integer>());
    }

    // not optimized
    private boolean util(TreeNode root, int k, Set<Integer> set){
        if(root==null) return false;

        if(!set.contains(root.val)){
            set.add(k-root.val);
        }else {
            return true;
        }

        boolean isLeftSuc =  util(root.left,k,set);
        if(isLeftSuc) return true;
       boolean isRightSuc = util(root.right,k,set);
       if(isRightSuc) return true;
      return false;
    }

    public boolean findTarget(TreeNode root,int k){

        BST_Iterator l = new BST_Iterator(root,false);
        BST_Iterator r = new BST_Iterator(root,true);

        int i = l.next();
        int j = r.next();

        while (i < j){
            if(i+j == k){
                return true;
            } else if (i+j < k) {
                i = l.next();
            }else {
                j =  r.next();
            }
        }
        return false;

    }
}
