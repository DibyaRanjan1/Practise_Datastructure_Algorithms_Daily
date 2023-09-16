package LeetCode_Top_150.Array;

public class ValidPalindrom {
    public static void main(String[] args) {

    }

    public boolean isPalindrome(String s) {
        int start=0;
        int end = s.length()-1;

        while (start< end){

            Character startChar = s.charAt(start);
            Character endChar = s.charAt(end);

            if(Character.isLetterOrDigit(startChar) && Character.isLetterOrDigit(endChar)){
               if(Character.toLowerCase(startChar) !=Character.toLowerCase(endChar)) return false;
                ++start;
                --end;
            }

            if(!Character.isLetterOrDigit(startChar)){
                ++start;
            }
            if(!Character.isLetterOrDigit(endChar)){
                --end;
            }
        }
       return true;
    }
}
