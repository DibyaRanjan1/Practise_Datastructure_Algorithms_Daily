package Tree.MediumProblems;

import java.util.*;

public class VerticalOrderTraversal {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(8);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(0);
        root.left.right.left = new TreeNode(5);

        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(7);
        root.right.left.right = new TreeNode(2);

        VerticalOrderTraversal v = new VerticalOrderTraversal();
        v.verticalOrder(root);
    }

    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        verticalOrder_util(root,map,0);

        List<Integer> sortedKeys = new ArrayList<>(map.keySet());
        Collections.sort(sortedKeys);
        for(int k:sortedKeys){
            result.add(map.get(k));
        }
        return result;
    }

    public void verticalOrder_util(TreeNode root,HashMap<Integer,List<Integer>> map, int depth) {
        if(root == null) return;
        if(map.containsKey(depth)){
            map.get(depth).add(root.val);
        }else {
            List<Integer> temp = new ArrayList<Integer>();
            temp.add(root.val);
            map.put(depth,temp);
        }
        verticalOrder_util(root.left,map,depth-1);
        verticalOrder_util(root.right,map,depth+1);
    }

    public List<List<Integer>> verticalOrder_optimize(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root==null) return result;
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        verticalOrder_util_optimize(root,map,result);


        return result;
    }

    class Pair {
        public TreeNode treeNode;
        public Integer distance;

        public Pair(TreeNode treeNode, Integer distance) {
            this.treeNode = treeNode;
            this.distance = distance;
        }
    }

    public void verticalOrder_util_optimize(TreeNode root,HashMap<Integer,List<Integer>> map, List<List<Integer>> res) {

        Queue<Pair> queue =new ArrayDeque<>();
        queue.add(new Pair(root,0));

        int minCol=0;
        int macCol=0;

        while (!queue.isEmpty()){

            Pair p = queue.poll();

            TreeNode currNode = p.treeNode;
            int dis = p.distance;

            if(currNode!=null){

                if(!map.containsKey(dis)){
                    map.put(dis,new ArrayList<>());
                }
                map.get(dis).add(currNode.val);
                minCol = Math.min(minCol,dis);
                macCol = Math.max(macCol,dis);

                queue.add(new Pair(currNode.left,dis-1));
                queue.add(new Pair(currNode.right,dis+1));
            }

        }

        for(int i=minCol;i<macCol+1;i++){
            res.add(map.get(i));
        }

    }
}
