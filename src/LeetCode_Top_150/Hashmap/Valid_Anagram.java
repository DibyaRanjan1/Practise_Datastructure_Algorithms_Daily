package LeetCode_Top_150.Hashmap;

import java.util.HashMap;

public class Valid_Anagram {
    public static void main(String[] args) {

    }

    public boolean isAnagram(String s, String t) {
        HashMap<Character,Integer> map = new HashMap<>();

        if(s.length()!=t.length()) return false;

        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }

        for(int i=0;i<t.length();i++){
            if(!map.containsKey(t.charAt(i)) || map.getOrDefault(t.charAt(i),-1) <= 0){
                return false;
            }
            map.put(t.charAt(i), map.get(t.charAt(i))-1);
        }
        return true;
    }

    public boolean isAnagram1(String s, String t) {
        int[] map = new int[256];

        if(s.length()!=t.length()) return false;

        for(int i=0;i<s.length();i++){
            map[s.charAt(i) - 'a']++;
        }

        for(int i=0;i<t.length();i++){
            if(map[t.charAt(i)-'a'] <= 0){
                return false;
            }
            map[t.charAt(i) - 'a']--;
        }
        return true;
    }
}
