package LeetCode_Top_150.Hashmap;

import java.util.HashMap;

public class Integer_To_Roman {
    public static void main(String[] args) {

    }

    public String intToRoman(int num) {

        if (num < 1 || num > 3999) return "";

        StringBuilder result = new StringBuilder();

        String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };

        int i = 0;

        while (num > 0){
            while (num >= values[i]){
                num = num - values[i];
                result.append(roman[i]);
            }
            i++;
        }

        return result.toString();
    }
}
