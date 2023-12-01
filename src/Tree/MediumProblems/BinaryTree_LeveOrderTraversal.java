package Tree.MediumProblems;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTree_LeveOrderTraversal {
    public static void main(String[] args) {
       BinaryTree_LeveOrderTraversal b = new BinaryTree_LeveOrderTraversal();
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);

    b.levelOrder(root);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
      List<List<Integer>> result = new LinkedList<>();
      if(root ==null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        List<Integer> temp = new LinkedList<>();
        temp.add(root.val);
        result.add(temp);

        while (!queue.isEmpty()){
             List<Integer> temp1 = new LinkedList<>();
             int size = queue.size();


            for(int i=0;i<size;i++){
                TreeNode  node = queue.poll();
                if(node.left !=null){
                    queue.add(node.left);
                    temp1.add(node.left.val);
                }
                if(node.right!=null){
                    queue.add(node.right);
                    temp1.add(node.right.val);
                }

            }
            if(temp1.size()!=0){
                result.add(temp1);
            }
        }
        return result;
    }
}
