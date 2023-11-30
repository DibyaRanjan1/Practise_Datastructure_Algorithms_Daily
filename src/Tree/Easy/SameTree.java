package Tree.Easy;

import Tree.MediumProblems.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class SameTree {
    public static void main(String[] args) {

    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q ==null) return true;
        if(p ==null || q ==null) return false;
        if(p.val !=q.val) return false;
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);

    }

    public boolean isSameTree_Iterative(TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(p);
        queue.add(q);

        while (!queue.isEmpty()){

            TreeNode pnode = queue.poll();
            TreeNode qnode = queue.poll();

            if(pnode==null && qnode ==null) continue;
            if((pnode==null || qnode == null)) return false;
            if(pnode.val!= qnode.val) return false;

            queue.add(pnode.left);
            queue.add(qnode.left);

            queue.add(pnode.right);
            queue.add(qnode.right);
        }
        return true;

    }
}
