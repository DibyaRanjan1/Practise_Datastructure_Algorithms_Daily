package LeetCode_Top_150.Stack;

import java.util.Stack;

public class EvaluateReversepolishNotation {
    public static void main(String[] args) {

        EvaluateReversepolishNotation e = new EvaluateReversepolishNotation();
        String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        e.evalRPN(tokens);
    }

    public int evalRPN(String[] tokens) {

        if(tokens.length==1){
            if(Character.isDigit(tokens[0].charAt(tokens[0].length()-1))){
                return Integer.parseInt(tokens[0]);
            }

        }

        Stack<Integer> stack = new Stack<>();
        int result =0;

        for(String element:tokens){

            if(Character.isDigit(element.charAt(element.length()-1))){
                stack.push(Integer.parseInt(element));
                continue;
            }

            int elem2 = stack.pop();
            int elem1 = stack.pop();
            switch (element){
                case "+":
                    result = elem1 + elem2;
                    break;
                case "-":
                    result = (elem1-elem2);
                    break;
                case "*":
                    result = (elem1 * elem2);
                    break;
                case "/":
                    result = (elem1/elem2);
                    break;
            }
            stack.push(result);
        }
        return result;

    }

}
