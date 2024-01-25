package LeetCode_Top_150.Graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class EvaluateDivision {
    public static void main(String[] args) {

    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        HashMap<String,HashMap<String,Double>> graph = new HashMap<>();

        for (int i=0;i<equations.size();i++){

           String dividend = equations.get(i).get(0);
           String divisor = equations.get(i).get(1);

           double quotient = values[i];

           if(!graph.containsKey(dividend)){
               graph.put(dividend,new HashMap<String,Double>());
           }
           if(!graph.containsKey(divisor)){
               graph.put(divisor,new HashMap<String,Double>());
           }

           graph.get(dividend).put(divisor,quotient);
           graph.get(divisor).put(dividend,1/quotient);

        }

        double[] result = new double[queries.size()];
        HashSet<String> visited = new HashSet<>();

        for(int i=0;i< graph.size();i++){

            List<String> query = queries.get(i);
            String source = query.get(0);
            String destination = query.get(1);

            if(!graph.containsKey(source) || !graph.containsKey(destination)){
                result[i] = -1.0;
            } else if (source.equals(destination)) {
                result[i] = 1.0;
            }else {
              result[i] = backTrack(source,destination,visited,graph,1);
            }
        }
        return result;
    }

    private double backTrack(String source, String destination, HashSet<String> visited, HashMap<String,HashMap<String ,Double>> graph, double accproduct ){

        visited.add(source);
        double rec = -1.0;

        Map<String,Double> neighbours = graph.get(source);
        if(neighbours.containsKey(destination)){
            rec = accproduct * neighbours.get(destination);
        }else {

            for(Map.Entry<String,Double> entry:neighbours.entrySet()){
                String nextNode = entry.getKey();
                if(visited.contains(nextNode)) continue;
                rec = backTrack(nextNode,destination,visited,graph,accproduct*entry.getValue());
                if(rec!=-1) break;
            }
        }
        visited.remove(source);
        return rec;
    }
}
