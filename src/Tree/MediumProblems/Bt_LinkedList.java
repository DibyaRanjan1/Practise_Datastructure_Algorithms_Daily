package Tree.MediumProblems;

public class Bt_LinkedList {
    public void flatten(TreeNode root) {
        if(root ==null) return;

        TreeNode cur = root;

        while (cur!=null){

            if(cur.left!=null){

                TreeNode rightMost = cur.left;
                while (rightMost.right!=null){
                    rightMost = rightMost.right;
                }

                rightMost.right = cur.right;
                cur.right = cur.left;
                cur.left = null;

            }
            cur = cur.right;
        }

    }

}
