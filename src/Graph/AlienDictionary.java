package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class AlienDictionary {
    public static void main(String[] args) {

    }

    public String findOrder(String [] dict, int N, int K)
    {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<K;i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int i=0;i< N-1;i++){
            String s1 = dict[i];
            String s2 = dict[i+1];

            int sLen = Math.min(s1.length(),s2.length());

            for(int j=0;j<sLen;j++){
                if(s1.charAt(j)!=s2.charAt(j)){
                    adj.get(s1.charAt(j)-'a').add(s2.charAt(j)-'a');
                    break;
                }
            }
        }

        ArrayList<Integer> result = topologicalSort(adj,K);
        String s = new String();
        for(int i=0;i<result.size();i++){
            s = s+(char)(result.get(i)+ (int)('a'));
        }
        return s;
    }

    private ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> adj, int K){
        int[] inorder = new int[K];
        ArrayList<Integer> result = new ArrayList<>();

        for(int i=0;i<K;i++){

            for(int it:adj.get(i)){
                inorder[it]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<inorder.length;i++){
            if(inorder[i]==0){
                queue.add(i);
            }
        }

        while (!queue.isEmpty()){
            int element =  queue.poll();
            result.add(element);


            for(int it: adj.get(element)){
                inorder[it]--;
                if(inorder[it]==0){
                    queue.add(it);
                }
            }

        }
        return result;
    }
}
