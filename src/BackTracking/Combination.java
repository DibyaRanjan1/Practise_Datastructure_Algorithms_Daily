package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class Combination {
    public static void main(String[] args) {

    }

    public List<List<Integer>> combine(int n, int k) {
      List<List<Integer>> result = new ArrayList<>();
      List<Integer> comb = new ArrayList<>();

       backTrack(result,comb,1,n,k);

       return result;
    }

    private void backTrack(List<List<Integer>> result,List<Integer> comb,int index, int n, int k){

        if(comb.size()==k){
            result.add(new ArrayList<>(comb));
            return;
        }
        for(int i=index;i<=n;i++){

            if(!comb.contains(i)){
                comb.add(i);
            }

            backTrack(result,comb,index+1,n,k);
            if(comb.size()>0){
                comb.remove(comb.size()-1);
            }

        }
    }
}
