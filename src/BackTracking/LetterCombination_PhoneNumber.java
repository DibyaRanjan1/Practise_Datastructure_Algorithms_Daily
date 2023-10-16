package BackTracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombination_PhoneNumber {
    public static void main(String[] args) {
     LetterCombination_PhoneNumber l = new LetterCombination_PhoneNumber();
     l.letterCombinations("23");
    }

    public List<String> letterCombinations(String digits) {
        Map<Character,String> map = Map.of('2', "abc", '3', "def", '4', "ghi", '5', "jkl",
                '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");
        ArrayList<String> comb = new ArrayList<>();
        String phoneDigit = digits;
        if (digits.length() == 0) {
            return comb;
        }
        backTrack(0,new StringBuilder(),phoneDigit,comb,map);
        return comb;

    }

    private void backTrack(int index,StringBuilder letters, String digits,List<String> comb, Map<Character,String> map){

        if(letters.length()== digits.length()){
            comb.add(letters.toString());
            return;
        }

          String currentDigits = map.get(digits.charAt(index));
        for(Character c:currentDigits.toCharArray()){
            letters.append(c);
            backTrack(index+1,letters,digits,comb,map);
            letters.deleteCharAt(letters.length()-1);
        }
    }
}
