package Tree.MediumProblems;

import java.util.LinkedList;
import java.util.Queue;

public class Serialize_Deserialize {
    public static void main(String[] args) {

    }

    public String serialize(TreeNode root) {

        StringBuilder result = new StringBuilder();

        if(root ==null) return "";

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()){
                TreeNode curr = q.poll();

                if(curr==null) {
                    result.append("n ");
                    continue;
                }
                result.append(curr.val).append(" ");
                q.add(curr.left);
                q.add(curr.right);
        }

        return result.toString();

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        if(data.isEmpty()) return null;

        String[] values = data.split(" ");
        Queue<TreeNode> q  =new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        q.add(root);

        for(int i=1;i<values.length;i++){

           TreeNode curr = q.poll();

            if(!values[i].equals("n")){
             TreeNode left =  new TreeNode( Integer.parseInt(values[i]));
             curr.left = left;
                q.add(left);
            }
            if(!values[++i].equals("n")){
                TreeNode right =new TreeNode(Integer.parseInt(values[i]));
                curr.right = right;

                q.add(right);
            }
        }
        return root;
    }
}
