package DataStream;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class MovingAverage {
    public static void main(String[] args) {

    }

    private Queue<Integer> queue;
    private int currentValue=0;
    private int windowSum=0;
    private int size=0;

    private Deque<Integer> deque;

    public MovingAverage(int size) {
    this.queue = new LinkedList<>();
    this.deque = new LinkedList<>();
    this.size = size;
    }

    public double next(int val) {

    queue.add(val);
    if(queue.size() <=3){
        currentValue += val;
        return (double) currentValue /queue.size();
    }else {
        while (queue.size() >3){
            currentValue = currentValue - queue.peek();
            queue.remove();
        }
       return (double)currentValue/3;
    }
    }

    public double next_optimum(int val){
        deque.add(val);

        int tail = deque.size() <= this.size ? 0:deque.poll();
        windowSum = windowSum - tail;

        return (double) windowSum/deque.size();

    }
}
