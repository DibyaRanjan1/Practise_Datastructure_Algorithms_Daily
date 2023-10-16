package LeetCode_Top_150.Hashmap;

import java.util.HashMap;

public class RomanToInteger {
    public static void main(String[] args) {
     RomanToInteger r = new RomanToInteger();
     r.romanToInt("DCXXI");
    }

    public int romanToInt(String s) {

        HashMap<String,Integer> map = new HashMap<>();
        map.put("I",1);
        map.put("V",5);
        map.put("X",10);
        map.put("L",50);
        map.put("C",100);
        map.put("D",500);
        map.put("M",1000);
        map.put("IV", 4);
        map.put("IX", 9);
        map.put("XL", 40);
        map.put("XC", 90);
        map.put("CD", 400);
        map.put("CM", 900);

        int result = 0;
        String currValue="";


         int i=0;

        while (i<s.length()){

            if(i < s.length()-1){
                currValue = s.substring(i,i+2);
                if(map.containsKey(currValue)){
                    result+=map.get(currValue);
                    i=i+2;
                    continue;
                }
            }
                currValue = s.substring(i,i+1);
                result+= map.get(currValue);
                i=i+1;
        }

        return result;
    }


    public int romanToInt_Optimal(String s) {

        int answer = 0, number = 0, prev = 0;

        for (int j = s.length() - 1; j >= 0; j--) {
            switch (s.charAt(j)) {
                case 'M' -> number = 1000;
                case 'D' -> number = 500;
                case 'C' -> number = 100;
                case 'L' -> number = 50;
                case 'X' -> number = 10;
                case 'V' -> number = 5;
                case 'I' -> number = 1;
            }
            if (number < prev) {
                answer -= number;
            }
            else {
                answer += number;
            }
            prev = number;
        }
        return answer;
    }

}
