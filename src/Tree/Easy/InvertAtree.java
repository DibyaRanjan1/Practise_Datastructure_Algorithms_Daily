package Tree.Easy;

import Tree.MediumProblems.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class InvertAtree {

    public static void main(String[] args) {
       InvertAtree invertAtree = new InvertAtree();
       TreeNode root = new TreeNode(1);
       root.left = new TreeNode(2);

       invertAtree.invertTree(root);
    }

    public TreeNode invertTree(TreeNode root) {
        if(root==null) return root;

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        root.left = right;
        root.right = left;
        return root;
    }

    public TreeNode invertTree_iterative(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){

            int size = queue.size();

            for(int i=0;i<size;i++){
                TreeNode curr = queue.poll();

                TreeNode left = curr.left;
                TreeNode right = curr.right;

                curr.right = left;
                curr.left = right;

                if(curr.left!=null) queue.offer(curr.left);
                if(curr.right!=null) queue.offer(curr.right);

            }
        }

        return root;
    }

}
