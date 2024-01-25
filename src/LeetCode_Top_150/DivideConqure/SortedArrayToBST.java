package LeetCode_Top_150.DivideConqure;

import Tree.MediumProblems.TreeNode;

public class SortedArrayToBST {
    public static void main(String[] args) {
      SortedArrayToBST s = new SortedArrayToBST();
      int[] arr = new int[]{-10,-3,0,5,9};
      s.sortedArrayToBST(arr);
    }

    public TreeNode sortedArrayToBST(int[] nums) {

  return util(0,nums.length-1,nums);
    }

    private TreeNode util(int left,int right,int[] nums){
        if(left> right) return null;

        int mid = left + (right-left)/2;
        TreeNode root = new TreeNode(nums[mid]);

       root.left =  util(left,mid-1,nums);
       root.right = util(mid+1,right,nums);
       return root;
    }

}
