package LeetCode_Top_150.Stack;

import java.util.Stack;

public class BasicCalculator {
    public static void main(String[] args) {
          BasicCalculator b = new BasicCalculator();
          b.calculate("(1+(4+5+2)-3)+(6+8)");
    }

    public int calculate(String s) {
        int result =0;
        int sign = 1;
        int operand=0;

        Stack<Integer> stack = new Stack<>();

        for(char item:s.toCharArray()){

            if(Character.isDigit(item)){
                operand = 10 * operand + (int)(item-'0');
            } else if (item == '+') {
                result += sign * operand;
                sign =1;
                operand =0;
            } else if (item == '-') {
                result += sign * operand;
                sign = -1;
                operand =0;
            }else if(item == '('){
               stack.push(result);
               stack.push(sign);
               
               sign=1;
               result =0;
            } else if (item == ')') {
                result += sign * operand;
                result *= stack.pop();
                result += stack.pop();

                operand =0;
            }
        }
        return result + (sign * operand);
    }
}
