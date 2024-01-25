package LeetCode_Top_150.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule_II {
    public static void main(String[] args) {
       CourseSchedule_II c = new CourseSchedule_II();

       int[][] arr = {{1,0},{2,0},{3,1},{3,2}};
       c.findOrder(4,arr);
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i< prerequisites.length;i++){
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        int[] topoSort = new int[numCourses];

        for(int i=0;i< adj.size();i++){

            for(Integer node: adj.get(i)){
                topoSort[node]++;
            }
        }

        ArrayList<Integer> topoOutPut = new ArrayList<>();

        Queue<Integer> queue = new LinkedList<>();

        for(int i=0;i<topoSort.length;i++){
            if(topoSort[i]==0){
              queue.add(i);
            }
        }

        while (!queue.isEmpty()){

            int currentNode = queue.peek();
            queue.remove();
            topoOutPut.add(currentNode);

            for(int neiggbour:adj.get(currentNode)){

                topoSort[neiggbour]--;
                if(topoSort[neiggbour] ==0){
                    queue.add(neiggbour);
                }
            }
        }

        if(topoOutPut.size() != adj.size()) return new int[0];

        return topoOutPut.stream().mapToInt(i->i).toArray();


    }
}
