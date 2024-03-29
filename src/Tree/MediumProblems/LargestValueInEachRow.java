package Tree.MediumProblems;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LargestValueInEachRow {
    public static void main(String[] args) {

    }

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root==null) return result;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);



        while (!queue.isEmpty()){

            int size = queue.size();
            int maxi=Integer.MIN_VALUE;

            for(int i=0;i<size;i++){
                 TreeNode node = queue.poll();
                 maxi = Math.max(maxi, node.val);

                 if(node.left!=null) queue.add(node.left);
                 if(node.right!=null) queue.add(node.right);

            }
            result.add(maxi);
        }
        return result;
    }
}
