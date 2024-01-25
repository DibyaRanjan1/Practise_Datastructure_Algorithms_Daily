package LeetCode_Top_150.Stack;

import java.util.Stack;

public class Simplifypath {
    public static void main(String[] args) {

    }

    public String simplifyPath(String path) {

        Stack<String> stack = new Stack<>();

        String[] splitedString = path.split("/");

        for(String subString:splitedString){

            if(subString.equals(".") || subString.isEmpty()) continue;
            else if (subString.equals("..")) {
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }else {
                stack.push(subString);
            }
        }

        StringBuilder sb = new StringBuilder();

        for(String dir:stack){
            sb.append("/");
            sb.append(dir);
        }

        return sb.length() > 0?sb.toString():"/";
    }
}
