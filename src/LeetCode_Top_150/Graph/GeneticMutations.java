package LeetCode_Top_150.Graph;

import java.util.*;

public class GeneticMutations {
    public static void main(String[] args) {
     GeneticMutations g = new GeneticMutations();

       String startGene = "AACCGGTT", endGene = "AAACGGTA";
       String[] bank = new String[]{"AACCGGTA","AACCGCTA","AAACGGTA"};

    g.minMutation(startGene,endGene,bank);
    }

    public int minMutation(String startGene, String endGene, String[] bank) {

        Queue<String> queue = new LinkedList<>();
        queue.add(startGene);

        Set<String> visited = new HashSet<>();
        visited.add(startGene);

        List<String> bankAsAList = Arrays.asList(bank);

        int steps=0;

        while (!queue.isEmpty()){

           int nodesInQueue = queue.size();

           for(int i=0;i<nodesInQueue;i++){
               String node = queue.remove();
               if(node.equals(endGene)) return steps;

               for(char c:new char[]{'A', 'C', 'G', 'T'}){
                   for(int j=0;j<node.length();j++){

                       String first = node.substring(0,j);
                       String second = node.substring(j+1);
                       String neighbour = first+c+second;

                       if(!visited.contains(neighbour) && bankAsAList.contains(neighbour)){
                           queue.add(neighbour);
                           visited.add(neighbour);
                       }
                   }
               }

               ++steps;
           }

        }
        return -1;
    }
}
