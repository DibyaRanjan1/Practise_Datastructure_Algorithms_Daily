package Tree.Easy;

import Tree.MediumProblems.TreeNode;

public class DiamterOfTree {

    int dia=0;
    public int diameterOfBinaryTree(TreeNode node) {
      if(node==null) return 0;
        int leftHeight = 0;

        if(node.left!=null){
            leftHeight =diameterOfBinaryTree(node.left);
        }
        int rightHeight = 0;
        if(node.right!=null){
            rightHeight = diameterOfBinaryTree(node.right);
        }

        dia = Math.max(dia,leftHeight+rightHeight);

        return 1 + Math.max(leftHeight,rightHeight);
    }

}
