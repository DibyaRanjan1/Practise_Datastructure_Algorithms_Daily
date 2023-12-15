package Tree.Easy;

import Tree.MediumProblems.TreeNode;

import java.util.Stack;

public class PathSum {
    public static void main(String[] args) {

    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root ==null) return false;

       return hasPathSum_util(root,targetSum);
    }

    public boolean hasPathSum_util(TreeNode root, int targetSum) {

        if(root ==null) return false;
        if(root.val == targetSum && root.left ==null && root.right ==null) return true;


        boolean leftResult = hasPathSum_util(root.left,targetSum-root.val);
        if(leftResult) return leftResult;
         boolean rightResult = hasPathSum_util(root.right,targetSum-root.val);
         if(rightResult) return rightResult;
         return false;
    }

    public boolean hasPathSum_iter(TreeNode root, int targetSum) {

        Stack<TreeNode> stackNode = new Stack<>();
        Stack<Integer> stackSum = new Stack<>();

        stackNode.push(root);
        stackSum.push(targetSum-root.val);

        while (!stackNode.isEmpty()){

            TreeNode curr = stackNode.pop();
            int currSum = stackSum.pop();

            if(currSum == 0 && curr.left ==null && curr.right ==null) return true;

                if(curr.right!=null){
                    stackNode.push(curr.right);
                    stackSum.push(currSum-curr.right.val);
                }
            if(curr.left!=null){
                stackNode.push(curr.left);
                stackSum.push(currSum-curr.left.val);
            }

        }
        return false;
    }
}
