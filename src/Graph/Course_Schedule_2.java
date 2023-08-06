package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Course_Schedule_2 {
    public static void main(String[] args) {

        int N = 4;
        int M = 3;
        ArrayList<ArrayList<Integer>> prerequisites = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            prerequisites.add(i, new ArrayList<>());
        }


        prerequisites.get(0).add(0);
        prerequisites.get(0).add(1);

        prerequisites.get(1).add(1);
        prerequisites.get(1).add(2);

        prerequisites.get(2).add(2);
        prerequisites.get(2).add(3);

        findOrder(N,M,prerequisites);
    }

    static int[] findOrder(int n, int m, ArrayList<ArrayList<Integer>> prerequisites)
    {
        // add your code here
        int[] inorder = new int[n];

        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<Integer>());
        }

        for(int i=0;i<m;i++){
            adj.get(prerequisites.get(i).get(1)).add(prerequisites.get(i).get(0));
        }



        getInorder(inorder,adj);

        int[] result = new int[n];
        int index = 0;
        Queue<Integer> q = new LinkedList<>();

        for(int i=0;i<inorder.length;i++){
            if(inorder[i]==0){
                q.add(i);
            }
        }

        while (!q.isEmpty()){

            Integer val = q.poll();
            result[index++] = val;

            for(Integer it:adj.get(val)){
                inorder[it]--;
                if(inorder[it] ==0){
                    q.add(it);
                }
            }

        }

        if(index == n) return result;
        return new int[0];

    }

    private  static void getInorder(int[] inorder, ArrayList<ArrayList<Integer>> adj){

        for(ArrayList<Integer> lst:adj){
            for(Integer it:lst){
                inorder[it]++;
            }
        }

    }


}
