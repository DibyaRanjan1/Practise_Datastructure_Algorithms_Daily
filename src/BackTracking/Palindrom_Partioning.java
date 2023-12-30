package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class Palindrom_Partioning {
    public static void main(String[] args) {
          Palindrom_Partioning p = new Palindrom_Partioning();
          p.partition("aab");
    }

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> comb = new ArrayList<>();
        backtrack(result,comb,s,0);
        return result;
    }

    private void backtrack(List<List<String>> result,List<String> comb, String s, int index){

        if(index >= s.length()){
            result.add(new ArrayList<>(comb));

        }
        for(int i=index;i<s.length();i++){

            String cuur = s.substring(index,i+1);
            if(checkPalindrome(cuur)){
                comb.add(cuur);
                backtrack(result,comb,s,i+1);
                comb.remove(comb.size()-1);
            }
        }
    }

    private boolean checkPalindrome(String temp){
        if(temp.isEmpty()) return false;
        if(temp.length()==1) return true;
        int length = temp.length()-1;
        int i=0;
        while (i<length && i>=0 && length>=0){
            if(temp.charAt(i) != temp.charAt(length)) return false;
            i++;
            --length;
        }
        return true;
    }
}
