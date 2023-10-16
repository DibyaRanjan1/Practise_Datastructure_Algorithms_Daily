package LeetCode_Top_150.StringPrograms;

public class Length_of_Last_Word {
    public static void main(String[] args) {
       Length_of_Last_Word l = new Length_of_Last_Word();
       l.lengthOfLastWord("   fly me   to   the moon  ");
    }

    public int lengthOfLastWord(String s) {

        int result = 0;
         s = s.trim();
        for(int i=s.length()-1;i>=0;i++){
            ++result;
            if(s.charAt(i) == ' '){
                return result;
            }
        }
        return result;
    }
}
