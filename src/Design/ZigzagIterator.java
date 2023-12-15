package Design;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Pair{
    public int key;
   public   int value;
    Pair(int key,int value){
        this.key = key;
        this.value = value;
    }
}
public class ZigzagIterator {

    public static void main(String[] args) {

    }
     List<List<Integer>> vec = new ArrayList<>();

    LinkedList<Pair> queue = new LinkedList<Pair>();

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        this.vec.add(v1);
        this.vec.add(v2);

        int key=0;
        for(List<Integer> lst:this.vec){
            if(lst.size()>0){
                queue.addLast(new Pair(key++,0));
            }
        }
    }

    public int next() {
        Pair curr =  this.queue.removeFirst();

        int currIndex = curr.value;
        int currListIndex = curr.key;
        int nextIndex = currIndex+1;

        if(nextIndex < this.vec.get(currListIndex).size()){
            queue.add(new Pair(currListIndex,nextIndex));
        }

        return this.vec.get(currListIndex).get(currIndex);
    }
    public boolean hasNext() {
       return !queue.isEmpty();
    }
}
