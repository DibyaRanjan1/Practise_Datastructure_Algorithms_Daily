package Hashmap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Hashmap_problems {
    public static void main(String[] args) {

        int[] arr = {
                2, 2, 6, -1, -1, -1, 6, -1, 6};
        isFrequencyUnique(9,arr);

    }

    public static boolean isFrequencyUnique(int n, int[] arr) {
        HashMap<Integer,Integer> hm = new HashMap<Integer, Integer>();
        for(int i=0;i< arr.length;i++){

            if(hm.containsKey(arr[i])){
                int count = hm.get(arr[i]);
                hm.put(arr[i],++ count);
            }else {
                hm.put(arr[i],1);
            }
        }

        HashSet<Integer> hs = new HashSet<Integer>();

        for (Map.Entry<Integer, Integer> en :
                hm.entrySet()){
            hs.add(en.getValue());
        }



        if(hs.size() == hm.size()){
            return false;
        }
        return true;
    }
}
