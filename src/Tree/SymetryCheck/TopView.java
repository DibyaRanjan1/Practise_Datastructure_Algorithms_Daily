package Tree.SymetryCheck;

import java.security.KeyPair;
import java.util.*;

public class TopView {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(2);

        root.left  = new TreeNode(1);
        root.right = new TreeNode(4);

        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(6);

        root.right.right.left = new TreeNode(5);

        topView(root);

    }

    // Failing for few testcases
    static ArrayList<Integer> topView(TreeNode root)
    {
       if(root == null) return new ArrayList<Integer>();
        TreeMap<Integer,Integer> sets = new TreeMap<Integer,Integer>();
        ArrayList<Integer> lst = new ArrayList<>();

        topViewUtil(root.left,sets,-1);

        sets.put(0, root.val);
        topViewUtilRight(root.right,sets,1);

        for(Map.Entry<Integer,Integer> it:sets.entrySet()){
         lst.add(it.getValue());
        }
        return lst;

    }

    private static void topViewUtil (TreeNode node, TreeMap<Integer,Integer> sets,int level){
        if(node ==null){
            return;
        }

        if(!sets.containsKey(level) && level < 0){
            sets.put(level,node.val);
        }

        topViewUtil(node.left,sets,level-1);

        topViewUtil(node.right,sets,level+1);



    }

    private static void topViewUtilRight (TreeNode node, TreeMap<Integer,Integer> sets,int level){
        if(node ==null){
            return;
        }

        if(!sets.containsKey(level) && level > 0){
            sets.put(level,node.val);
        }

        topViewUtilRight(node.right,sets,level+1);

        topViewUtilRight(node.left,sets,level-1);
    }

    public ArrayList<Integer> TopView(TreeNode node){

        ArrayList<Integer> lst = new ArrayList<>();

        if(node == null) return lst;
        TreeMap<Integer,Integer> treeMap = new TreeMap<Integer,Integer>();

        Queue<Pair> q  =new LinkedList<>();

          int level =0;
        q.add(new Pair(node,level));

          while (!q.isEmpty()){
              Pair pair = q.poll();
              if(!treeMap.containsKey(pair.level)){
                  treeMap.put(pair.level,pair.node.val);
              }

              if(pair.node.left!=null){
                  q.add(new Pair(pair.node.left, pair.level-1));
              }

              if(pair.node.right!=null){
                  q.add(new Pair(pair.node.right,pair.level+1));
              }

          }

          for(Map.Entry<Integer,Integer> map: treeMap.entrySet()){
              lst.add(map.getValue());
          }
          return lst;

    }

    class Pair{
        TreeNode node;
        int level;

        Pair(TreeNode node,int level){
            this.node = node;
            this.level = level;
        }
    }
}
