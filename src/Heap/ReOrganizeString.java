package Heap;

import java.util.HashMap;
import java.util.PriorityQueue;

public class ReOrganizeString {
    public static void main(String[] args) {

        ReOrganizeString reOrganizeString = new ReOrganizeString();
        reOrganizeString.reorganizeString("aabccde");
    }

    public String reorganizeString(String s) {

        HashMap<Character,Integer> charMap = new HashMap<>();
        for(int i=0;i<s.length();i++){
            charMap.put(s.charAt(i),charMap.getOrDefault(s.charAt(i),0)+1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) ->{
            return Integer.compare(b[1],a[1]);
        });

        for(char key:charMap.keySet()){
            pq.add(new int[]{key,charMap.get(key)});
        }

        StringBuilder sb = new StringBuilder();

        while (!pq.isEmpty()){

            int[] currentItem = pq.poll();
            char currentChar  = (char)currentItem[0];
            int count = currentItem[1];

            if(sb.length()==0 || currentChar != sb.charAt(sb.length()-1)){
                sb.append(currentChar);

                --count;
                if(count>0){
                    pq.add(new int[]{currentItem[0],count});
                }
            }else {

                if(pq.isEmpty()){
                    return "";
                }

                int[] secondCurrentItem = pq.poll();
                char secondCurrentChar  = (char)secondCurrentItem[0];
                int secondCount = secondCurrentItem[1];

                sb.append(secondCurrentChar);
                --secondCount;
                if(secondCount >0){
                    pq.add(new int[]{secondCurrentItem[0],secondCount});
                }
                pq.add(new int[]{currentItem[0],count});
            }
        }
        return sb.toString();
    }
}
