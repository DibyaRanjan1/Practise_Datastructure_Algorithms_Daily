package DisjointSet;

import java.util.*;

public class SmallestStringWithSwap {
    public static void main(String[] args) {

        SmallestStringWithSwap s = new SmallestStringWithSwap();
        List<List<Integer>> lst = new ArrayList<>();

        for (int i=0;i<3;i++){
            lst.add(new ArrayList<>());
        }

        lst.get(0).add(0);
        lst.get(0).add(3);

        lst.get(1).add(1);
        lst.get(1).add(2);

        lst.get(2).add(0);
        lst.get(2).add(2);

        s.smallestStringWithSwaps("dcab",lst);
    }

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {

        UnionFind u = new UnionFind(s.length());

        for(int i=0;i<pairs.size();i++){
            u.union(pairs.get(i).get(0),pairs.get(i).get(1));
        }

        Map<Integer,List<Integer>> rootToComponent = new HashMap<>();

        for(int i=0;i<s.length();i++){

            int root = u.find(i);
            rootToComponent.putIfAbsent(root,new ArrayList<>());
            rootToComponent.get(root).add(i);
        }

        char[] smallestString = new char[s.length()];

        for(List<Integer> indices:rootToComponent.values()){
            List<Character> characters = new ArrayList<>();

            for(int ind:indices){
                characters.add(s.charAt(ind));
            }

            Collections.sort(characters);

            for(int i=0;i<indices.size();i++){
                smallestString[indices.get(i)] = characters.get(i);
            }
        }

        return new String(smallestString);


    }
}


