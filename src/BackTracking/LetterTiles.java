package BackTracking;

import java.util.HashSet;
import java.util.Set;

public class LetterTiles {
    public static void main(String[] args) {
    LetterTiles l = new LetterTiles();
    l.numTilePossibilities("AAB");
    }

    public int numTilePossibilities(String tiles) {

        Set<String> set = new HashSet<>();
        boolean[] visited = new boolean[tiles.length()];

        utility(tiles,"",set,visited);
        return set.size();
    }

    public void utility(String tiles,String str, Set<String> set, boolean[] visited) {
        if(!str.isEmpty()) set.add(str);

      for(int i=0;i<tiles.length();i++){

          if(!visited[i]){
              visited[i]=true;
              utility(tiles,str+tiles.charAt(i),set,visited);
              visited[i]=false;
          }
      }
    }
}
