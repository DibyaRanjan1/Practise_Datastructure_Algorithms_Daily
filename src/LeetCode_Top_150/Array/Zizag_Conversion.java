package LeetCode_Top_150.Array;

import java.util.Arrays;

public class Zizag_Conversion {
    public static void main(String[] args) {

    }

    public String convert(String s, int numRows) {

        if(numRows ==1) return s;
        if(s.isEmpty()) return s;
        int n = s.length();
        int sections = (int)(Math.ceil(n/(2*numRows)-2.0));
        int numCols = sections*(numRows-1);

        char[][] charArray = new char[numRows][numCols];

        for(char[] it:charArray){
            Arrays.fill(it,' ');
        }

        int row=0;
        int col=0;
        int currentIndex=0;

        while (currentIndex<n){

            while (row<numRows && currentIndex < n){
                charArray[row][col] = s.charAt(currentIndex);
                ++row;
                ++currentIndex;
            }

            row = row-2;
            ++col;

            while (row>0 && col < numCols && currentIndex<n){
                charArray[row][col] = s.charAt(currentIndex);
                --row;
                ++col;
                ++currentIndex;
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i=0;i< charArray.length;i++){
            for(int j=0;j<charArray[i].length;j++){
                if(charArray[i][j]!=' '){
                    sb.append(charArray[i][j]);
                }
            }
        }
        return sb.toString();
    }
}
