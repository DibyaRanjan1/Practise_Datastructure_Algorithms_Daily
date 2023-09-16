package LeetCode_Top_150.Hashmap;

import java.util.Arrays;
import java.util.HashMap;

public class Isomorphic {
    public static void main(String[] args) {
      Isomorphic i = new Isomorphic();
      i.isIsomorphic1("foo","bar");
    }

    // Not working with all testcases
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character,Integer> map1 = new HashMap<>();
        HashMap<Character,Integer> map2 = new HashMap<>();

        for(int i=0;i<s.length();i++){
            map1.put(s.charAt(i),map1.getOrDefault(s.charAt(i),0)+1);
        }

        for(int i=0;i<t.length();i++){
            map2.put(t.charAt(i),map2.getOrDefault(t.charAt(i),0)+1);
        }

        for(int i=0;i<s.length();i++){
            if(map1.get(s.charAt(i)) != map2.get(t.charAt(i))) return false;
        }
        return true;
    }

    public boolean isIsomorphic1(String s, String t){
        int map1[]=new int[200];
        int map2[]=new int[200];

        if(s.length()!=t.length())
            return false;


        for(int i=0;i<s.length();i++)
        {
            if(map1[s.charAt(i)]!=map2[t.charAt(i)])
                return false;

            map1[s.charAt(i)]=i+1;
            map2[t.charAt(i)]=i+1;
        }
        return true;
    }

    public boolean isIsomorphic2(String s, String t){
        int map1[]=new int[256];
        Arrays.fill(map1,-1);

        int map2[]=new int[256];
        Arrays.fill(map2,-1);

      for(int i=0;i<s.length();i++){

          Character sChar = s.charAt(i);
          Character tChar = t.charAt(i);

          if(map1[sChar] == -1 && map2[tChar] == -1){
              map1[sChar] = tChar;
              map2[tChar] = sChar;
          }else if(!(map1[sChar] == tChar && map2[tChar] == sChar)){
              return false;
          }
      }

        return true;
    }
}
