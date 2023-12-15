package Tree.Easy;

import LeetCode_Top_150.LinkedListPrograms.ListNode;
import Tree.MediumProblems.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MaxDepth {
    public static void main(String[] args) {

    }

    public int maxDepth(TreeNode root) {

        if(root==null) return 0;

     return  1 + Math.max(maxDepth(root.left),maxDepth(root.right));

    }

    public int maxDepth_bfs(TreeNode root) {

        if(root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int count=0;

        while (!queue.isEmpty()){
            int size = queue.size();

            for(int i=0;i<size;i++){
                TreeNode curr = queue.poll();
                if(curr.left!=null) queue.add(curr.left);
                if(curr.right!=null) queue.add(curr.right);
            }
            ++count;
        }
        return count;

    }


}
