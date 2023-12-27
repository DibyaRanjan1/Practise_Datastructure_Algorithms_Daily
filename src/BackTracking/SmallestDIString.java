package BackTracking;

import java.util.Stack;

public class SmallestDIString {
    public static void main(String[] args) {
        SmallestDIString s = new SmallestDIString();
        s.smallestNumber("IIIDIDDD");
    }

    public String smallestNumber(String pattern) {

        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        StringBuilder sb  =new StringBuilder();
        int num=1;

        for(int i=0;i<pattern.length();i++){

            char ch = pattern.charAt(i);
            if(ch=='I'){
                while (!stack.isEmpty()){
                    sb.append(stack.pop());
                }
            }
            num ++;
            stack.push(num);



        }
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }


        return sb.toString();
    }

}
