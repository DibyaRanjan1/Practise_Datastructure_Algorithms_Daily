package LeetCode_Top_150.Stack;

import java.util.Stack;

public class ValidParanthesis {
    public static void main(String[] args) {

    }

    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for(Character ch:s.toCharArray()){

            if(ch == '(' || ch== '[' || ch=='{'){
                stack.push(ch);
            } else  {
               Character topEle = stack.peek();
                switch (ch){
                    case  ')':
                        if(topEle.equals('(')) stack.pop();
                        else return false;
                        break;
                    case  '}':
                        if(topEle.equals('{')) stack.pop();
                        else return false;
                        break;
                    case  ']':
                        if(topEle.equals('[')) stack.pop();
                        else return false;
                        break;
                }
            }
        }

        return stack.isEmpty();
    }
}
