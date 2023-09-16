package LeetCode_Top_150.Hashmap;

import java.util.HashMap;

public class RansomNote {
    public static void main(String[] args) {

    }

    public boolean canConstruct(String ransomNote, String magazine) {
      if(ransomNote.length()> magazine.length()) return false;

        HashMap<Character,Integer> map = new HashMap<>();

        for(int i=0;i<magazine.length();i++){

            map.put(magazine.charAt(i),map.getOrDefault(magazine.charAt(i),0)+1);
        }

        for(int i=0;i<ransomNote.length();i++){
            if(!map.containsKey(ransomNote.charAt(i))) return false;

            int count = map.get(ransomNote.charAt(i));
            if(count==1){
                map.remove(ransomNote.charAt(i));
            }else {
                map.put(ransomNote.charAt(i),count-1);
            }
        }
        return true;
    }

    public boolean canConstructWithOutHasMap(String ransomNote, String magazine) {
        if(ransomNote.length()> magazine.length()) return false;

        int[] alphabets = new int[26];


        for(int i=0;i<magazine.length();i++){

           alphabets[magazine.charAt(i) -'a']++;
        }

        for(int i=0;i<ransomNote.length();i++){
           if(alphabets[ransomNote.charAt(i)-'a'] ==0) return false;
           alphabets[ransomNote.charAt(i)-'a']--;
        }
        return true;
    }
}
