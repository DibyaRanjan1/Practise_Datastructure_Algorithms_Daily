package LeetCode_Top_150.Array;

public class SubsequenceString {
    public static void main(String[] args) {

    }

    public boolean isSubsequence(String s, String t) {
       if(s.length() > t.length()) return false;
       if(s.isEmpty()) return true;

       int slowPointer = 0;
       int fastPointer = 0;

       for(;fastPointer <t.length(); fastPointer++){

           if(t.charAt(fastPointer) == s.charAt(slowPointer)){
               ++slowPointer;
           }

           if(slowPointer >=s.length()) return true;
       }

       return slowPointer>=s.length();
    }
}
