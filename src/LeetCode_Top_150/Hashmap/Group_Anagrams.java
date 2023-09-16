package LeetCode_Top_150.Hashmap;

import java.util.*;

public class Group_Anagrams {
    public static void main(String[] args) {
       Group_Anagrams g = new Group_Anagrams();
       String[] strs = new String[]{"eat","tea","tan","ate","nat","bat"};
       g.groupAnagrams1(strs);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length ==0) return new ArrayList<>();
        HashMap<String,List<String>> map = new HashMap<>();
        int[] count = new int[26];

        for(int i=0;i< strs.length;i++){
            Arrays.fill(count,0);

            char[] currentString = strs[i].toCharArray();

            for(int j=0;j<currentString.length;j++){
               count[currentString[j]-'a']++;
            }

            StringBuilder sb = new StringBuilder();

            for(int j=0;j<26;j++){
                sb.append('#');
                sb.append(count[j]);
            }

            String mapKey = sb.toString();

            if(!map.containsKey(mapKey)){
                map.put(mapKey,new ArrayList<String>());
            }

            map.get(mapKey).add(strs[i]);
        }

        return new ArrayList<>(map.values());
    }

    public List<List<String>> groupAnagrams1(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] ca = new char[26];
            for (char c : s.toCharArray()) ca[c - 'a']++;
            String keyStr = String.valueOf(ca);
            if (!map.containsKey(keyStr)) map.put(keyStr, new ArrayList<>());
            map.get(keyStr).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
