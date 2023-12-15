package Tree.Easy;

import Tree.MediumProblems.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageLevelBT {
    public static void main(String[] args) {

    }


    public List<Double> averageOfLevels(TreeNode root) {

        List<Double> result = new ArrayList<>();
        if(root ==null) return result;
            Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty()){

            double size = queue.size();
            Double avg = 0.0;
            for(int i=0;i<size;i++){
              TreeNode curr =  queue.poll();
              avg += curr.val;

              if(curr.left!=null) queue.add(curr.left);
              if(curr.right!=null) queue.add(curr.right);
            }
            result.add(avg/size);
        }
        return result;
    }

    public List<Double> averageOfLevels_dfs(TreeNode root) {
          averageOfLevels_dfs_util(0,root);
          List<Double> res = new ArrayList<>();
          for(Double[] item:temp){
              res.add(item[0]/item[1]);
          }
          return res;
    }

    List<Double[]> temp = new ArrayList<>();

   public void averageOfLevels_dfs_util(int level, TreeNode node){

       if(node ==null) return;

       if(temp.size()<=level){
           temp.add(new Double[2]);
       }
       temp.get(level)[0] +=node.val;
       temp.get(level)[1]++;

        averageOfLevels_dfs_util(level+1,node.left);
        averageOfLevels_dfs_util(level+1,node.right);
   }
}
