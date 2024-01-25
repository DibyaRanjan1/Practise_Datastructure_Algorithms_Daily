package LeetCode_Top_150.Array;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class IPO {
    public static void main(String[] args) {

    }

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {

        int n = capital.length;
        Project[] projects = new Project[n];

        for(int i=0;i<n;i++){
            projects[i] = new Project(capital[i], profits[i]);
        }

        Arrays.sort(projects);

        PriorityQueue<Integer> pq = new PriorityQueue<>(n, Collections.reverseOrder());

        int pntr=0;
        for(int i=0;i<k;i++){

            while (pntr < n && projects[pntr].capital <= w){
                pq.add(projects[pntr++].profit);
            }
            if(pq.isEmpty()) break;

            w+= pq.poll();
        }
        return w;
    }

    class Project implements Comparable<Project>{
        int capital, profit;
        public Project(int capital,int profit){
            this.capital = capital;
            this.profit = profit;
        }

        @Override
        public int compareTo(Project project) {
            return capital-project.capital;
        }
    }
}
