package Tree.SymetryCheck;

import java.util.*;

public class BottomView {
    public static void main(String[] args) {

    }

    public ArrayList<Integer> bottomView(TreeNode root)
    {
        // Code here

        if(root==null){
            return new ArrayList<Integer>();
        }
        TreeMap<Integer,Integer> map = new TreeMap<>();
        ArrayList<Integer> lst = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        root.hd = 0;
        q.add(root);

        while (!q.isEmpty()){
            TreeNode node = q.poll();
            map.put(node.hd,node.val);

            if(node.left !=null){
                node.left.hd = node.hd-1;
                q.add(node.left);
            }

            if(node.right!=null){
                node.right.hd = node.hd+1;
                q.add(node.right);
            }
        }

        for(Map.Entry<Integer,Integer> m: map.entrySet()){
            lst.add(m.getValue());
        }
        return lst;

    }
}
