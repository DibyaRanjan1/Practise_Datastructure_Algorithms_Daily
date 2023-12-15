package Tree.MediumProblems;

import java.util.*;

public class BTLevelOrder_II {
    public static void main(String[] args) {

    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
      List<List<Integer>> result = new LinkedList<List<Integer>>();

      if(root==null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);


        Stack<List<Integer>> stack = new Stack<>();
         List<Integer> lst = new ArrayList<>();
         lst.add(root.val);

        stack.add(lst);

        while (!queue.isEmpty()){

            int size = queue.size();

            List<Integer> tempLst = new ArrayList<>();
            for(int i=0;i<size;i++){

                TreeNode curr = queue.poll();

                if(curr.left!=null){
                    queue.offer(curr.left);
                    tempLst.add(curr.left.val);
                }
                if(curr.right!=null){
                    queue.offer(curr.right);
                    tempLst.add(curr.right.val);
                }
            }
        }

        while (!stack.isEmpty()){
            result.add(stack.pop());
        }

        return stack;
    }


}
