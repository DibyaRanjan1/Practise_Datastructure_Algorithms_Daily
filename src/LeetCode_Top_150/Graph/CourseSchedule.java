package LeetCode_Top_150.Graph;

import java.util.ArrayList;

public class CourseSchedule {
    public static void main(String[] args) {
    CourseSchedule c = new CourseSchedule();
    int[][] arr = {{1,0}};
    c.canFinish(2,arr);
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i=0;i< numCourses;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i< prerequisites.length;i++){
            int source = prerequisites[i][1];
            int destination = prerequisites[i][0];
            adj.get(source).add(destination);
        }

        int[] visited = new int[numCourses];
        int[] parVisited = new int[numCourses];

       for(int i=0;i<numCourses;i++){

           if(visited[i] == 0){
               if(dfs(i,adj,visited,parVisited)) return false;
           }
       }
       return true;
    }

    private boolean dfs(int source,ArrayList<ArrayList<Integer>> graph,int[] visited,int[] parVisited){

        visited[source] =1;
        parVisited[source]=1;

        ArrayList<Integer> neigbours  = graph.get(source);

        for(int i=0;i<neigbours.size();i++){

            int newSource = neigbours.get(i);
            if(visited[newSource]==0){
               if(dfs(newSource,graph,visited,parVisited)) return true;
            } else if (parVisited[newSource]==1) {
                return true;
            }
        }

        parVisited[source] = 0;
        return false;
    }
}
