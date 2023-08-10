package Tree.MediumProblems;

import java.util.*;

public class KDistanceBinaryTree {
    public static void main(String[] args) {
        TreeNode  root = new TreeNode(3);

        root . left = new TreeNode(5);
        root.right = new TreeNode(1);

        root . left . left = new TreeNode(6);
        root . left . right = new TreeNode(2);

        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);


        root . right . left = new TreeNode(0);
        root . right . right = new TreeNode(8);

        KDistanceBinaryTree k = new KDistanceBinaryTree();
        k.distanceK(root,root . left ,2);
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        Map<Integer,Boolean> visited = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(target);
        visited.put(target.val,true);

        Map<TreeNode,TreeNode> map = findParent(root);

        int distance=0;

        while (!q.isEmpty() ){

            if(distance == k) break;;
            ++distance;
            int size = q.size();

            for(int i=0;i<size;i++){
                TreeNode curr = q.poll();
                if(curr.left!=null && visited.get(curr.left.val)==null){
                    q.add(curr.left);
                    visited.put(curr.left.val,true);
                }

                if(curr.right!=null && visited.get(curr.right.val) ==null){
                    q.add(curr.right);
                    visited.put(curr.right.val,true);
                }

                TreeNode parent =  map.get(curr);
                if(parent!=null && visited.get(parent.val) == null){
                    q.add(parent);
                    visited.put(parent.val,true);
                }
            }

        }

        List<Integer> lst = new ArrayList<>();

        while (!q.isEmpty()){
            lst.add(q.poll().val);
        }

        return lst;

    }
    private Map<TreeNode,TreeNode> findParent(TreeNode root){

        Map<TreeNode,TreeNode> map = new HashMap<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()){
            TreeNode curr = q.poll();
                if(curr.left!=null){
                    q.add(curr.left);
                    map.put(curr.left,curr);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                    map.put(curr.right,curr);
                }
        }
      return map;
    }


}
