package Tree.MediumProblems;

import java.util.*;

public class BT_ZigZag {
    public static void main(String[] args) {

    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        if(root ==null) return result;

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.add(root);


        boolean isZigzag = true;

        while (!stack1.isEmpty() || !stack2.isEmpty()) {


            List<Integer> levelnodeList = new ArrayList<>();

            if(isZigzag){
                while (!stack1.isEmpty())
                {
                    TreeNode curr = stack1.pop();
                    levelnodeList.add(curr.val);

                    if(curr.left!=null) stack2.push(curr.left);
                    if(curr.right!=null) stack2.push(curr.right);
                }
            }else {
                while (!stack2.isEmpty()){
                    TreeNode curr = stack2.pop();
                    levelnodeList.add(curr.val);

                    if(curr.right!=null) stack1.push(curr.right);
                    if(curr.left!=null) stack1.push(curr.left);
                }
            }

            isZigzag =!isZigzag;
            result.add(levelnodeList);
        }
        return result;

    }
}
