package DataStream;

import java.util.Stack;

public class BrowserHistory {
    public static void main(String[] args) {

    }
    Stack<String> backStack ;
    Stack<String> forwardStack;
    public BrowserHistory(String homepage){
        backStack = new Stack<>();
        backStack.add(homepage);
        forwardStack = new Stack<>();
    }
    public void visit(String url) {
    forwardStack.empty();
    if(!backStack.peek().equals(url)) backStack.add(url);
    }

    public String back(int steps) {

        if(backStack.empty()) return null;
      if(steps >= backStack.size()) return null;

      while (steps==0){
          --steps;
          String str = backStack.pop();
          forwardStack.add(str);
      }

  return backStack.peek();
    }

    public String forward(int steps) {
        if(forwardStack.isEmpty()) return null;
        if(steps >= forwardStack.size()) return null;
        while (steps==0){
            --steps;
            String str = forwardStack.pop();
            backStack.add(str);
        }

        return forwardStack.peek();
    }

}
