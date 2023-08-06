package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Course_Schedule_1 {
    public static void main(String[] args) {

        int N = 4;
        int M = 3;


        int[][] a = new int[3][2];
        a[0][0] = 1;
        a[0][1] = 0;

        a[1][0] = 2;
        a[1][1] = 1;

        a[2][0] = 3;
        a[2][1] = 2;

        isPossible(N,M,a);
    }

    public static boolean isPossible(int N,int P, int[][] prerequisites)
    {
        // Your Code goes here



        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

        for(int i=0;i< N;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<P;i++){
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        int[] inorder = new int[N];

        Queue<Integer> q = new LinkedList<>();
        topoDfs(adj,inorder);
       for(int i=0;i<inorder.length;i++){
           if(inorder[i]==0){
               q.add(i);
           }
       }

        int count=0;

        while (!q.isEmpty()){
            count++;
            Integer number = q.poll();

            for(Integer it: adj.get(number)){
                inorder[it]--;
                if(inorder[it]==0){
                    q.add(it);
                }

            }
        }

        if(count == N) return true;
        return false;

    }

    private static void topoDfs(ArrayList<ArrayList<Integer>> adj, int[] inorder ){
        for(ArrayList<Integer> lst:adj){
            for(Integer it:lst){
                inorder[it]++;
            }
        }
    }
}
