package Design;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class LoggerRateLimiter {

    class Pair{
        public int timer;
        public String message;

        public Pair(int timer, String message){
            this.message = message;
            this.timer  =timer;
        }
    }
    public static void main(String[] args) {

    }

    private Queue<Pair> queue;
    private HashSet<String> set;

    private HashMap<String,Integer> map;

    public LoggerRateLimiter() {
     queue = new LinkedList<>();
     set = new HashSet<>();
     map = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {

        while (true){
            if(queue.isEmpty()) break;
           Pair pair = queue.peek();
           if(pair.timer <= timestamp) {
               queue.remove();
               set.remove(pair.message);
           }else {
               break;
           }
        }
            if(set.contains(message)) return false;

        queue.add(new Pair(timestamp+10,message));
        set.add(message);
        return true;
    }

    public boolean shouldPrintMessage_optimize(int timestamp, String message) {

         if(!map.containsKey(message)){
             map.put(message,timestamp);
             return true;
         }else {
             int oldTimeStamp = map.get(message);
             if( oldTimeStamp+10 < timestamp){
                map.put(message,timestamp);
                return true;
             }
             return false;
         }

    }
}
