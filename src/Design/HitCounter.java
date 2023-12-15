package Design;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class HitCounter {
    public static void main(String[] args) {
        HitCounter h = new HitCounter();
        h.hit(1);
        h.hit(1);
        h.hit(1);
        h.hit(300);

        h.getHits(300);

        h.hit(300);

        h.getHits(300);

        h.hit(301);

        h.getHits(301);
    }

    public Queue<Integer> queue;
    public HitCounter() {
     this.queue = new LinkedList<>();
     this.deque = new LinkedList<>();
    }

    public void hit(int timestamp) {
     //this.queue.add(timestamp);

        if(deque.isEmpty() || deque.getLast().key != timestamp){
            deque.addLast(new Pair(timestamp,1));
        }else {
            Pair lastInsertedData = deque.getLast();
            deque.removeLast();
            deque.addLast(new Pair(lastInsertedData.key ,lastInsertedData.value+1));
        }
        this.total+=1;
    }

    public int getHits(int timestamp) {

//        if(timestamp>300){
//            while (!this.queue.isEmpty()){
//
//                int curTimeStamp = timestamp- this.queue.peek();
//                if(curTimeStamp>=300){
//                    this.queue.remove();
//                }else {
//                    break;
//                }
//            }
//        }
//        return this.queue.size();
        if(timestamp >300){
            while (!this.deque.isEmpty()){
                Pair firstEle = this.deque.getFirst();
                int cuurentTimeStamp = timestamp - firstEle.value;
                if(cuurentTimeStamp>=300){
                    deque.removeFirst();
                    this.total = this.total - firstEle.value;
                }else {
                    break;
                }

            }
        }
        return this.total;

    }

    Deque<Pair> deque = new LinkedList<>();
    public int total;


}


