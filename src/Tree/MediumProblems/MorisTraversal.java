package Tree.MediumProblems;

import java.util.ArrayList;

public class MorisTraversal {
    public static void main(String[] args) {

    }

    public ArrayList<Integer> morisInorder(TreeNode root){

        TreeNode curr = root;
        ArrayList<Integer> result = new ArrayList<>();

        while (curr!=null){
            if(curr.left ==null){
                result.add(curr.val);
                curr = curr.right;
            }else {
                TreeNode temp = curr.left;
                while (temp.right!=null && temp.right!=curr){
                    temp = temp.right;
                }

                if(temp.right == null){
                    temp.right = curr;
                    curr = curr.left;
                }else {
                    temp.right =null;
                    result.add(curr.val);
                    curr = curr.right;
                }


            }


        }

        return result;

    }
}
