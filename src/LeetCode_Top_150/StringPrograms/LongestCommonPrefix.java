package LeetCode_Top_150.StringPrograms;

import java.util.HashMap;

public class LongestCommonPrefix {
    public static void main(String[] args) {
       LongestCommonPrefix l = new LongestCommonPrefix();
      String result = l.longestCommonPrefix(new String[]{"ab","a"});
    }

    public String longestCommonPrefix(String[] strs) {

        if(strs.length ==0) return "";
        if(strs.length ==1) return strs[0];
        if(strs[0].equals("")) return "";


        int i=0;
        int length = strs.length;

        int minLength = Math.min(strs[0].length(),strs[1].length());

        while(i<length){
            if(i+1 >= length) break;
            String first = strs[i];
            String second = strs[i+1];

            if(first.isEmpty() || second.isEmpty()) return "";

            int count=0;
            minLength = Math.min(minLength,Math.min(first.length(),second.length()));
            for(int j=0;j<minLength;j++){
                if(first.charAt(j)==second.charAt(j)){
                    ++count;
                }else {
                    break;
                }
            }
            minLength = count;

            if(count==0) return "";
            ++i;
        }
        return strs[0].substring(0,minLength);
    }

    public String longestCommonPrefix_CleanCode(String[] strs) {

        if(strs.length==0) return "";

        String prefix = strs[0];

        for(int i=1;i< strs.length;i++){
            while (strs[i].indexOf(prefix)!=0){
                prefix = prefix.substring(0,prefix.length()-1);
                if(prefix.isEmpty()) return "";
            }

        }
        return prefix;
    }
}
