package Tree.MediumProblems;

public class CountNodeOfCompleteBinaryTree {
    public static void main(String[] args) {

    }

    public int countNodes(TreeNode root) {

        if(root ==null) return 0;

       int leftheight = getLeftHeight(root);
       int rightheight = getRightHeight(root);

       if(leftheight ==rightheight){
           return (int)Math.pow(leftheight,2)-1;
       }

           return 1+ countNodes(root.left)+countNodes(root.right);

    }


    private int getLeftHeight(TreeNode root){
        int count=0;
        while (root!=null){
            root = root.left;
            ++count;
        }
        return count;
    }

    private int getRightHeight(TreeNode root){
        int count=0;
        while (root!=null){
            root = root.right;
            ++count;
        }
        return count;
    }
}
