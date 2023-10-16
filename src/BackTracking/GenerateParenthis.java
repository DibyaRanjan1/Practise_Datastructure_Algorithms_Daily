package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthis {
    public static void main(String[] args) {
      GenerateParenthis g = new GenerateParenthis();
      g.generateParenthesis(3);
    }

    public List<String> generateParenthesis(int n) {
    List<String> result = new ArrayList<>();
    StringBuilder sb = new StringBuilder();

    backTrack(result,0,0,n,sb);
    return result;
    }

    private void backTrack(List<String> ans,int leftCount,int rightCount,int n,StringBuilder combination){

        if(combination.length() == 2*n){
            ans.add(combination.toString());
            return;
        }

        if(leftCount < n){
            combination.append("(");
            backTrack(ans,leftCount+1,rightCount,n,combination);
            combination.deleteCharAt(combination.length()-1);
        }

        if(leftCount>rightCount){
            combination.append(")");
            backTrack(ans,leftCount,rightCount+1,n,combination);
            combination.deleteCharAt(combination.length()-1);
        }
    }
}
