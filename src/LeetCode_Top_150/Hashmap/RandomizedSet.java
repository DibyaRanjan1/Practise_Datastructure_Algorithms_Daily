package LeetCode_Top_150.Hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.concurrent.RecursiveTask;

public class RandomizedSet {

    private HashMap<Integer,Integer> map = null;
    private ArrayList<Integer> arrayList = null;
    Random rand = new Random();

    public static void main(String[] args) {

    }

    public RandomizedSet() {
this.map = new HashMap<>();
this.arrayList = new ArrayList<>();
    }

    public boolean insert(int val) {

        if(map.containsKey(val)) return false;

        arrayList.add(arrayList.size(),val);
        map.put(val,arrayList.size()-1);
       return true;
    }

    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;

        int lastEle = arrayList.get(arrayList.size()-1);
        int eleIndex = map.get(val);
        arrayList.set(eleIndex,lastEle);
        arrayList.remove(arrayList.size()-1);
        map.put(lastEle,eleIndex);
        map.remove(val);
        return true;
    }

    public int getRandom() {

      return arrayList.get(rand.nextInt(arrayList.size()));
    }
}
