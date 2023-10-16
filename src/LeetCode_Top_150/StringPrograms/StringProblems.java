package LeetCode_Top_150.StringPrograms;

import java.util.*;

public class StringProblems {
    public static void main(String[] args) {

        StringProblems s = new StringProblems();
     String result =  s.reverseWords_optimal(" hello world ");
    }

    public String reverseWords(String s) {

        List<String> spliedArray = Arrays.asList(s.trim().split(" "));
        Collections.reverse(spliedArray);

       return String.join(" ",spliedArray);

    }

    public String reverseWords_optimal(String s){

        StringBuilder sb = new StringBuilder();
        Deque<String> dq  = new ArrayDeque<>();

        int start=0;
        int end = s.length()-1;

        while (s.charAt(start) == ' '){
            ++start;
        }

        while (s.charAt(end) == ' '){
            --end;
        }

        while (start<=end){

            if(sb.length()!=0 && s.charAt(start) == ' '){
                dq.offerFirst(sb.toString());
                sb.setLength(0);
            } else if (s.charAt(start) != ' ') {
                sb.append(s.charAt(start));
            }
            ++start;
        }

        dq.offerFirst(sb.toString());
        return String.join(" ",dq);


    }
}
