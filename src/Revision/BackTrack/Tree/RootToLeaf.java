package Revision.BackTrack.Tree;

import BinarySearchTree.LeetCode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RootToLeaf {
    public static void main(String[] args) {
      TreeNode root = new TreeNode(1);
      root.left = new TreeNode(2);
      root.right = new TreeNode(3);

      root.left.left = new TreeNode(4);
      root.left.right = new TreeNode(5);

      allRootToLeaf(root);

    TreeNode ans =  lowestCommonAncestor(root,root.left.right,root.right);

    }

    public static List<String> allRootToLeaf(TreeNode root) {
        List<String> lst = new ArrayList<>();
      allRootToLeaf(root,lst,new ArrayList<Integer>());
      return lst;
    }

    public static void allRootToLeaf(TreeNode root, List<String> lst, List<Integer> comb) {

        if(root.left==null && root.right ==null){
            StringBuilder sb = new StringBuilder();
          for(int i=0;i<comb.size();i++){
              sb.append(comb.get(i) + " ");
          }
          sb.append(root.val);
          lst.add(sb.toString());


            return;
        }
        if(root.left==null) return;
        if(root.right==null) return;


        comb.add(root.val);
        allRootToLeaf(root.left,lst,comb);

        allRootToLeaf(root.right,lst,comb);

        comb.remove(comb.size()-1);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root ==null || root==p || root==q) return root;

       TreeNode left =   lowestCommonAncestor(root.left,p,q);
       TreeNode right = lowestCommonAncestor(root.right,p,q);

       if(left ==null) return right;
       else if(right ==null) return left;
       else return root;
    }

    class Pair{
        public int index;
        public TreeNode node;

        public Pair(int index, TreeNode node){
            this.index = index;
            this.node = node;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {

        Queue<Pair> queue = new LinkedList<>();

        Pair rootpair = new Pair(0,root);
        queue.add(rootpair);

        int answer = 0;

        while (!queue.isEmpty()){
            int size = queue.size();

            int first=0; int last=0;
            Pair p1 = queue.peek();
            int minIndex = p1.index;

            for(int i=0;i<size;i++){
               Pair node = queue.poll();
               int curIndex = node.index - minIndex;

               if(i==0) first = curIndex;
               if(i==size-1) last = curIndex;

               if(node.node.left!=null){
                   queue.add(new Pair(2*curIndex+1,node.node.left));
               }

               if(node.node.right!=null){
                   queue.add(new Pair(2*curIndex+2,node.node.right));
               }

            }
            answer = Math.max(answer,last-first+1);
        }
        return answer;
    }
}
