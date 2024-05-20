package Design;

import java.util.Comparator;
import java.util.TreeSet;

public class MaxStack {
    public static void main(String[] args) {

    }

    TreeSet<int[]> stack;
    TreeSet<int[]> values;
    int count;

    public MaxStack() {
        Comparator<int[]> comparator = (a,b) -> {
            return a[0] == b[0] ? a[1] - b[1] : a[0] - b[0];
        };

       stack = new TreeSet<>(comparator);
       values = new TreeSet<>(comparator);
       count=0;
    }

    public void push(int x) {
       stack.add(new int[]{count,x});
       values.add(new int[]{x,count});
       ++count;
    }

    public int pop() {
     int[] stackValues = stack.pollLast();
     values.remove(new int[]{stackValues[1],stackValues[0]});
     return stackValues[1];
    }

    public int top() {
        return stack.last()[1];

    }

    public int peekMax() {
      return values.last()[0];
    }

    public int popMax() {
      int[] maxTopValue = values.pollLast();
      stack.remove(new int[]{maxTopValue[1], maxTopValue[0]});
      return maxTopValue[0];
    }

}
